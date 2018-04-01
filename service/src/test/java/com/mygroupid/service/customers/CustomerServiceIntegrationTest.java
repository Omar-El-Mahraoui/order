package com.mygroupid.service.customers;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.customers.CustomerDatabase;
import com.mygroupid.domain.items.Item;
import com.mygroupid.service.items.ItemServiceIntegrationTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static com.mygroupid.domain.customers.Customer.CustomerBuilder.customer;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.SpringApplication.run;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemServiceIntegrationTest.ItemServiceIntegrationTestRunner.class)
public class CustomerServiceIntegrationTest {

    @Inject
    private CustomerService customerService;

    @Before
    public void clearItemDatabase() {
        customerService.clearDatabase();
    }

    @Test
    public void createCustomer_givenACustomer_thenAddItToCustomerDatabaseAndReturnTheCustomer() {
        // given
        Customer customer = customer()
                .withFirstName("Jan")
                .withLastName("Janssens")
                .withEmailAddress("jansemailaddress")
                .withAddress("jansaddress")
                .withPhoneNumber("0123456789")
                .build();

        //when
        Customer actualResult = customerService.createCustomer(customer);

        //then
        assertThat(customerService.getCustomers()).containsExactly(customer);
        assertThat(actualResult).isEqualTo(customer);
    }

    @SpringBootApplication(scanBasePackages = {"com.mygroupid"})
    public static class CustomerServiceIntegrationTestRunner {

        public static void main(String[] args) {
            run(CustomerServiceIntegrationTestRunner.class, args);
        }
    }
}
