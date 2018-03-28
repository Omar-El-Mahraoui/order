package com.mygroupid.api.customers;


import com.mygroupid.api.orders.ItemGroupDto;
import com.mygroupid.api.orders.ItemGroupMapper;
import com.mygroupid.api.orders.OrderDto;
import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.customers.CustomerDatabase;
import com.mygroupid.domain.items.Item;
import com.mygroupid.domain.items.ItemDatabase;
import com.mygroupid.domain.orders.ItemGroup;
import com.mygroupid.domain.orders.Order;
import com.mygroupid.domain.orders.OrderDatabase;
import com.mygroupid.service.customers.CustomerService;
import com.mygroupid.service.items.ItemService;
import com.mygroupid.service.orders.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.SpringApplication.run;
// copied and adapted code from funiversity

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
    private CustomerMapper customerMapper;
    @Inject
    private ItemService itemService;
    @Inject
    private OrderService orderService;
    @Inject
    private ItemGroupMapper itemGroupMapper;

    @Before
    public void clearDatabase() {
        orderService.clearDatabase();
        itemService.clearDatabase();
        customerService.clearDatabase();
    }

    private CustomerDto createCustomerDto() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(UUID.randomUUID().toString());
        customerDto.setFirstName("Jan");
        customerDto.setLastName("Janssens");
        customerDto.setEmailAddress("jansemailaddress@exampleameil.com");
        customerDto.setAddress("jansaddress");
        customerDto.setPhoneNumber("0123456789");
        return customerDto;
    }

    private ItemGroupDto createItemGroupDto() {
        Item item = new Item();
        item.setName("pen");
        item.setDescription("blue pen");
        item.setPrice("1.00");
        item.setAmountInStock("5");
        itemService.createItem(item);
        ItemGroupDto itemGroupDto = new ItemGroupDto();
        itemGroupDto.setItemId(item.getId());
        itemGroupDto.setAmount("4");
        return itemGroupDto;
    }

    @Test
    public void createCustomer_givenAnEmptyDatabaseAndACustomerDto_thenAddCustomerToCustomerDatabaseAnd(){
        // given
        CustomerDto customerDtoGiven = createCustomerDto();

        //when
        CustomerDto customerDtoReturned = new TestRestTemplate()
                        .postForObject(String.format("http://localhost:%s/%s", port, "customers")
                                        , customerDtoGiven
                                        , CustomerDto.class);

        //then
        assertThat(customerService.getCustomers()).hasSize(1);
        assertThat(customerService.getCustomers().get(0).getFirstName()).isEqualTo(customerDtoGiven.getFirstName());
        assertThat(customerService.getCustomers().get(0).getLastName()).isEqualTo(customerDtoGiven.getLastName());
        assertThat(customerService.getCustomers().get(0).getEmailAddress()).isEqualTo(customerDtoGiven.getEmailAddress());
        assertThat(customerService.getCustomers().get(0).getAddress()).isEqualTo(customerDtoGiven.getAddress());
        assertThat(customerService.getCustomers().get(0).getPhoneNumber()).isEqualTo(customerDtoGiven.getPhoneNumber());
    }

    @Test
    public void createOrder_givenACustomerIdAndAItemGroupDto_thenCreateOrderAndAddItToOrderDatabseAndUpdateItem(){
        // given
        Customer customer = new Customer();
        customer.setFirstName("Jan");
        customer.setLastName("Janssens");
        customer.setEmailAddress("jansemailaddress@exampleemail.com");
        customer.setAddress("jansaddress");
        customer.setPhoneNumber("0123456789");
        customerService.createCustomer(customer);

        Item item = new Item();
        item.setName("pen");
        item.setDescription("blue pen");
        item.setPrice("1.00");
        item.setAmountInStock("5");
        itemService.createItem(item);

        ItemGroup itemGroup = new ItemGroup();
        itemGroup.setItemId(item.getId());
        itemGroup.setAmount("4");

        ItemGroupDto itemGroupDto = itemGroupMapper.toDto(itemGroup);


        /*CustomerDto customerDtoGiven = createCustomerDto();
        String customerId = customerDtoGiven.getId();
        ItemGroupDto itemGroupDto = createItemGroupDto();*/

        //when
        OrderDto orderDtoReturned = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/customers/%s/%s", port, customer.getId(), "order")
                        , itemGroupDto
                        , OrderDto.class);

        //then
        assertThat(orderService.getOrders()).hasSize(1);
        /*assertThat(customerService.getCustomers().get(0).getFirstName()).isEqualTo(customerDtoGiven.getFirstName());
        assertThat(customerService.getCustomers().get(0).getLastName()).isEqualTo(customerDtoGiven.getLastName());
        assertThat(customerService.getCustomers().get(0).getEmailAddress()).isEqualTo(customerDtoGiven.getEmailAddress());*/
    }

    /*
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
    */
}
