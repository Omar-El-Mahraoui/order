package com.mygroupid.service.customers;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.customers.CustomerDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.mygroupid.domain.customers.Customer.CustomerBuilder.customer;
import static java.util.Collections.unmodifiableList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerDatabase customerDatabase;

    @InjectMocks
    private CustomerService customerService;

    @Before
    public void clearCustomerDatabase() {
        customerDatabase.clearDatabase();
    }

    @Test
    public void createCustomer_givenACustomer_thenCallCreateCustomerOfCustomerDatabaseAndReturnTheCustomer() {
        // given
        Customer customer = customer()
                                .withFirstName("Jan")
                                .withLastName("Janssens")
                                .withEmailAddress("jansemailaddress@example.com")
                                .withAddress("jansaddress")
                                .withPhoneNumber("0123456789")
                                .build();
        Mockito.when(customerDatabase.createCustomer(customer)).thenReturn(customer);

        //when
        Customer actualResult = customerService.createCustomer(customer);

        //then
        assertThat(actualResult).isEqualTo(customer);
    }

    @Test
    public void getCustomers_givenAnEmptyCustomerDatabase_thenReturnEmptyList() {
        // given
        Mockito.when(customerDatabase.getCustomers()).thenReturn(new ArrayList<>());

        //when
        List<Customer> actualResult = customerService.getCustomers();

        //then
        assertThat(actualResult).isEmpty();
    }

    @Test
    public void getCustomers_givenANonEmptyCustomerDatabase_thenReturnTheListOfCustomers() {
        // given
        List<Customer> customers = new ArrayList<>();
        customers.add(customer()
                .withFirstName("Jan")
                .withLastName("Janssens")
                .withEmailAddress("jansemailaddress@example.com")
                .withAddress("jansaddress")
                .withPhoneNumber("0123456789")
                .build());
        Mockito.when(customerDatabase.getCustomers()).thenReturn(unmodifiableList(customers));

        //when
        List<Customer> actualResult = customerService.getCustomers();

        //then
        assertThat(actualResult).isEqualTo(customers);
    }

    @Test
    public void getCustomer_givenACustomerIdThatIsPresentInCustomerDatabase_thenReturnThisCustomer() {
        // given
        Customer customer = customer()
                .withFirstName("Jan")
                .withLastName("Janssens")
                .withEmailAddress("jansemailaddress@example.com")
                .withAddress("jansaddress")
                .withPhoneNumber("0123456789")
                .build();
        Mockito.when(customerDatabase.getCustomer(customer.getId())).thenReturn(customer);

        //when
        Customer actualResult = customerService.getCustomer(customer.getId());

        //then
        assertThat(actualResult).isEqualTo(customer);
    }

}