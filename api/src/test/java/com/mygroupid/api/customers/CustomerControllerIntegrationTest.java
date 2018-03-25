/*
package com.mygroupid.api.customers;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.customers.CustomerRepository;
import com.mygroupid.service.customers.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static com.mygroupid.api.customers.CustomerDto.customerDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.SpringApplication.run;
// copied and adapted code from funiversity

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerControllerIntegrationTest.CustomerControllerIntegrationTestRunner.class
                        , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Inject
    private CustomerService customerService;
    @Inject
    private CustomerMapper customerMapper;

    @Before
    public void clearDatabase() {
        customerService.clearDatabase();
    }

    @Test
    public void createCustomer_givenAnEmptyDatabaseAndACustomer_thenAddCustomerToCustomerDatabaseAndReturnThisCustomer(){
        // given
        CustomerDto customerDtoGiven = createCustomerDto();

        //when
        CustomerDto customerDtoReturned = new TestRestTemplate()
                        .postForObject(String.format("http://localhost:%s/%s", port, "customers")
                                        , customerDtoGiven
                                        , CustomerDto.class);

        //then
        assertThat(customerDtoReturned).isEqualToIgnoringGivenFields(customerMapper.toDomain(customerDtoGiven)
                                                                        , "id");
        assertThat(customerService.getCustomers()).hasSize(1);
        assertThat(customerService.getCustomers().get(0).getFirstName()).isEqualTo(customerDtoGiven.getFirstName());
        assertThat(customerService.getCustomers().get(0).getLastName()).isEqualTo(customerDtoGiven.getLastName());
        assertThat(customerService.getCustomers().get(0).getEmailAddress()).isEqualTo(customerDtoGiven.getEmailAddress());
        assertThat(customerService.getCustomers().get(0).getAddress()).isEqualTo(customerDtoGiven.getAddress());
        assertThat(customerService.getCustomers().get(0).getPhoneNumber()).isEqualTo(customerDtoGiven.getPhoneNumber());
    }

    @Test
    public void getCustomers_givenAnEmptyDatabase_thenReturnAnEmptyArrayList(){
        // given

        //when
        CustomerDto[] customerDtos = new TestRestTemplate()
                .getForObject(String.format("http://localhost:%s/%s", port, "customers"), CustomerDto[].class);

        //then
        assertThat(customerDtos).isEmpty();
    }

    @Test
    public void getCustomers_givenADatabaseWithOneCustomer_thenReturnListOfCustomersContainingThatCustomer(){
        // given
        CustomerDto customerDtoGiven = createCustomerDto();
        customerService.createCustomer(customerMapper.toDomain(customerDtoGiven));

        //when
        CustomerDto[] customerDtos = new TestRestTemplate()
                .getForObject(String.format("http://localhost:%s/%s", port, "customers"), CustomerDto[].class);

        //then
        assertThat(customerDtos).hasSize(1);
        assertThat(customerService.getCustomers().get(0).getFirstName()).isEqualTo(customerDtoGiven.getFirstName());
        assertThat(customerService.getCustomers().get(0).getLastName()).isEqualTo(customerDtoGiven.getLastName());
        assertThat(customerService.getCustomers().get(0).getEmailAddress()).isEqualTo(customerDtoGiven.getEmailAddress());
        assertThat(customerService.getCustomers().get(0).getAddress()).isEqualTo(customerDtoGiven.getAddress());
        assertThat(customerService.getCustomers().get(0).getPhoneNumber()).isEqualTo(customerDtoGiven.getPhoneNumber());

    }

    private CustomerDto createCustomerDto() {
        return customerDto()
                .withFirstName("Jan")
                .withLastName("Janssens")
                .withEmailAddress("jansemailaddress@example.com")
                .withAddress("jansaddress")
                .withPhoneNumber("0123456789");
    }


    @SpringBootApplication(scanBasePackageClasses = {CustomerService.class, CustomerRepository.class, CustomerMapper.class})
    public static class CustomerControllerIntegrationTestRunner {

        public static void main(String[] args) {
            run(CustomerControllerIntegrationTestRunner.class, args);
        }
    }

}
*/