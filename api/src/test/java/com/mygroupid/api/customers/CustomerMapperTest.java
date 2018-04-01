package com.mygroupid.api.customers;

import com.mygroupid.domain.customers.Customer;
import org.junit.Before;
import org.junit.Test;

import static com.mygroupid.api.customers.CustomerDto.customerDto;
import static com.mygroupid.domain.customers.Customer.CustomerBuilder.customer;
import static org.assertj.core.api.Assertions.assertThat;
// copied parts from funiversity mapper (switchfully)

public class CustomerMapperTest {

    private CustomerMapper customerMapper;

    @Before
    public void instantiateCustomerMapper() {
        customerMapper = new CustomerMapper();
    }

    @Test
    public void toDto_givenACustomer_thenMapAllFieldsToTheCorrespondingCustomerDto() {
        // given
        Customer customer = customer()
                                .withFirstName("Jan")
                                .withLastName("Janssens")
                                .withEmailAddress("janjanssensemail@exampleemail.com")
                                .withAddress("jansaddress")
                                .withPhoneNumber("0123456789")
                                .build();

        // when
        CustomerDto actualResult = customerMapper.toDto(customer);

        // then
        assertThat(actualResult)
                .isEqualToComparingFieldByField(customer);
    }

    @Test
    public void toDomain_givenACustomerDto_thenMapAllFieldsExceptForTheIdToTheCorrespondingCustomer() {
        // given
        CustomerDto customerDto = customerDto()
                                        .withFirstName("Jan")
                                        .withLastName("Janssens")
                                        .withEmailAddress("janjanssensemail@email.com")
                                        .withAddress("jansaddress")
                                        .withPhoneNumber("0123456789");

        // when
        Customer actualResult = customerMapper.toDomain(customerDto);

        // then
        assertThat(actualResult)
                .isEqualToIgnoringGivenFields(customerDto, "id");
    }

}
