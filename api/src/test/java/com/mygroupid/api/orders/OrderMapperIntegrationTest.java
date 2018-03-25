/*
package com.mygroupid.api.orders;

import com.mygroupid.api.customers.CustomerDto;
import com.mygroupid.api.customers.CustomerMapper;
import com.mygroupid.api.items.ItemDto;
import com.mygroupid.api.items.ItemMapper;
import com.mygroupid.domain.customers.CustomerRepository;
import com.mygroupid.domain.items.ItemRepository;
import com.mygroupid.domain.orders.OrderRepository;
import com.mygroupid.service.customers.CustomerService;
import com.mygroupid.service.items.ItemService;
import com.mygroupid.service.orders.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.boot.SpringApplication.run;

// copied and adapted code from funiversity

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderMapperIntegrationTest.OrderMapperIntegrationTestRunner.class
        , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderMapperIntegrationTest {

    @LocalServerPort
    private int port;

    @Inject
    private OrderService customerService;
    @Inject
    private OrderMapper customerMapper;


    @Test
    public void createOrder_givenAnEmptyDatabaseAndAnItem_thenAddOrderToOrderDatabaseAndReturnItsTotalPrice(){
        // given
        CustomerDto customerDto = CustomerDto.customerDto().withFirstName("Jan")
                .withLastName("Janssens")
                .withEmailAddress("jansemailaddress@example.com")
                .withAddress("jansaddress")
                .withPhoneNumber("0123456789");

        ItemDto itemDto = new ItemDto("pen", "blue pen", "1", "5");
        List<ItemGroupDto> itemGroupDtoList = new ArrayList<>();
        ItemGroupDto itemGroupDto = new ItemGroupDto(itemDto, "2");
        itemGroupDtoList.add(itemGroupDto);

        OrderDto orderDto = new OrderDto(customerDto, itemGroupDtoList);

        //when
        String priceOfOrderReturned = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "orders")
                        , orderDto
                        , String.class);

        //then
        org.assertj.core.api.Assertions.assertThat(priceOfOrderReturned).isEqualTo("2");
    }


    @SpringBootApplication(scanBasePackageClasses = {OrderService.class, OrderRepository.class, OrderMapper.class,
                                                    ItemMapper.class, CustomerMapper.class, ItemService.class,
            ItemRepository.class, CustomerService.class, CustomerRepository.class})
    public static class OrderMapperIntegrationTestRunner {

        public static void main(String[] args) {
            run(OrderMapperIntegrationTestRunner.class, args);
        }
    }

}
*/