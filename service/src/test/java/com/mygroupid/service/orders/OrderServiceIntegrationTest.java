package com.mygroupid.service.orders;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.items.Item;
import com.mygroupid.domain.orders.ItemGroup;
import com.mygroupid.domain.orders.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.mygroupid.domain.customers.Customer.CustomerBuilder.customer;
import static com.mygroupid.domain.items.Item.ItemBuilder.item;
import static com.mygroupid.domain.orders.Order.OrderBuilder.order;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.SpringApplication.run;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServiceIntegrationTest.OrderServiceIntegrationTestRunner.class)
public class OrderServiceIntegrationTest {

    @Inject
    private OrderService orderService;

    @Test
    public void createOrder_givenAnOrderAndACustomer_thenCalculateShippingDateAndPriceAndAddOrderToDatabaseAndReturnOrder() {
        // given
        Customer customer = customer()
                            .withFirstName("Jan")
                            .withLastName("Janssens")
                            .withEmailAddress("jansemailaddress")
                            .withAddress("jansaddress")
                            .withPhoneNumber("0123456789")
                            .build();
        Item item = item()
                .withName("Pen")
                .withDescription("A blue pen to wriet with")
                .withPrice(new BigDecimal(1))
                .withAmountInStock(5)
                .build();
        ItemGroup itemGroup = ItemGroup.ItemGroupBuilder.itemGroup()
                .withItem(item)
                .withAmount(4)
                .build();
        List<ItemGroup> itemGroups = new ArrayList<>();
        itemGroups.add(itemGroup);

        Order orderGiven = order()
                .withCustomer(customer)
                .withItemGroups(itemGroups)
                .build();

        //when
        Order actualResult = orderService.createOrder(orderGiven, customer);

        //then
        assertThat(actualResult.getCustomer()).isEqualTo(customer);
        assertThat(actualResult.getItemGroups().get(0).getShippingDate()).isEqualTo(LocalDate.now().plusDays(1));
        assertThat(actualResult.getPrice()).isEqualTo(new BigDecimal(4));
    }

    @SpringBootApplication(scanBasePackages = {"com.mygroupid"})
    public static class OrderServiceIntegrationTestRunner {

        public static void main(String[] args) {
            run(OrderServiceIntegrationTestRunner.class, args);
        }
    }

}