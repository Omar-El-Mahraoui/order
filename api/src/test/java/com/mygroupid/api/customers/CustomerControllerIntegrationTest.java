package com.mygroupid.api.customers;


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
// copied and adapted code from funiversity switchfully

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerControllerIntegrationTest.CustomerControllerIntegrationTestRunner.class
                        , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegrationTest {

    @SpringBootApplication(scanBasePackages = {"com.mygroupid"})
    public static class CustomerControllerIntegrationTestRunner {

        public static void main(String[] args) {
            run(CustomerControllerIntegrationTestRunner.class, args);
        }
    }

    @LocalServerPort
    private int port;

    @Inject
    private CustomerService customerService;
    @Inject
    private CustomerController customerController;

    @Before
    public void clearDatabase() {
        customerService.clearDatabase();
    }


    @Test
    public void createCustomer_givenAnEmptyDatabaseAndACustomerDto_thenAddCustomerToCustomerDatabaseAndReturnThisCustomerDto(){
        // given
        CustomerDto customerDtoGiven = customerDto()
                .withFirstName("Jan")
                .withLastName("Janssens")
                .withEmailAddress("jansemailaddress@exampleemail.com")
                .withAddress("jansaddress")
                .withPhoneNumber("0123456789");

        //when
        CustomerDto customerDtoReturned = new TestRestTemplate()
                        .postForObject(String.format("http://localhost:%s/%s", port, "customers")
                                        , customerDtoGiven
                                        , CustomerDto.class);

        //then
        assertThat(customerService.getCustomers()).hasSize(1);
        assertThat(customerDtoReturned.getId()).isNotNull();
        assertThat(customerService.getCustomers().get(0).getFirstName()).isEqualTo(customerDtoGiven.getFirstName());
        assertThat(customerService.getCustomers().get(0).getLastName()).isEqualTo(customerDtoGiven.getLastName());
        assertThat(customerService.getCustomers().get(0).getEmailAddress()).isEqualTo(customerDtoGiven.getEmailAddress());
        assertThat(customerService.getCustomers().get(0).getAddress()).isEqualTo(customerDtoGiven.getAddress());
        assertThat(customerService.getCustomers().get(0).getPhoneNumber()).isEqualTo(customerDtoGiven.getPhoneNumber());
    }

    @Test
    public void getCustomers_givenAnEmptyCustomerDatabase_thenReturnAnEmptyList(){
        // given
        //when
        //https://stackoverflow.com/questions/23674046/get-list-of-json-objects-with-spring-resttemplate
        CustomerDto[] customerDtoListReturned = new TestRestTemplate()
                .getForObject(String.format("http://localhost:%s/%s", port, "customers")
                        , CustomerDto[].class);

        //then
        assertThat(customerDtoListReturned).isEmpty();
    }

    @Test
    public void getCustomers_givenANonEmptyCustomerDatabase_thenReturnTheListOfCustomers(){
        // given
        customerController.createCustomer(customerDto()
                .withFirstName("Jan")
                .withLastName("Janssens")
                .withEmailAddress("jansemailaddress@exampleemail.com")
                .withAddress("jansaddress")
                .withPhoneNumber("0123456789"));

        //when
        //https://stackoverflow.com/questions/23674046/get-list-of-json-objects-with-spring-resttemplate
        CustomerDto[] customerDtoListReturned = new TestRestTemplate()
                .getForObject(String.format("http://localhost:%s/%s", port, "customers")
                        , CustomerDto[].class);

        //then
        assertThat(customerDtoListReturned).hasSize(1);
        assertThat(customerDtoListReturned[0].getId()).isNotNull();
        assertThat(customerDtoListReturned[0].getFirstName()).isEqualTo("Jan");
        assertThat(customerDtoListReturned[0].getLastName()).isEqualTo("Janssens");
        assertThat(customerDtoListReturned[0].getEmailAddress()).isEqualTo("jansemailaddress@exampleemail.com");
        assertThat(customerDtoListReturned[0].getAddress()).isEqualTo("jansaddress");
        assertThat(customerDtoListReturned[0].getPhoneNumber()).isEqualTo("0123456789");
    }

    @Test
    public void getCustomer_givenAnIdThatIsPresentInCustomerDatabase_thenReturnTheCorrespondingCustomerDto(){
        // given
        CustomerDto customerDtoGiven = customerDto()
                .withFirstName("Jan")
                .withLastName("Janssens")
                .withEmailAddress("jansemailaddress@exampleemail.com")
                .withAddress("jansaddress")
                .withPhoneNumber("0123456789");
        CustomerDto customerDtoCreated = customerController.createCustomer(customerDtoGiven);

        //when
        //https://stackoverflow.com/questions/23674046/get-list-of-json-objects-with-spring-resttemplate
        CustomerDto customerDtoReturned = new TestRestTemplate()
                .getForObject(String.format("http://localhost:%s/%s/%s", port, "customers", customerDtoCreated.getId())
                        , CustomerDto.class);

        //then
        assertThat(customerDtoReturned).isEqualTo(customerDtoCreated);
    }
}
