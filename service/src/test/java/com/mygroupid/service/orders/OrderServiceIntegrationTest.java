/*
package com.mygroupid.service.orders;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.items.Item;
import com.mygroupid.domain.orders.ItemGroup;
import com.mygroupid.domain.orders.Order;
import com.mygroupid.service.customers.CustomerService;
import com.mygroupid.service.items.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.SpringApplication.run;
// copied and adapted code from funiversity

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServiceIntegrationTest.OrderServiceIntegrationTestRunner.class)
public class OrderServiceIntegrationTest {

    @Inject
    OrderService orderService;
    @Inject
    CustomerService customerService;
    @Inject
    ItemService itemService;

    @Test
    public void createOrder_givenACustomerIdAndAnItemGroup_thenCreateOrderAndUpdateItem() {
        //given
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

        //when
        Order actualResult = orderService.createOrder(customer.getId(), itemGroup);

        // then
        assertThat(orderService.getOrders())
                .hasSize(1);
    }

    @Test
    public void calculateShippingDate_givenAnItemGroupWithARequestedItemThatIsInStock_thenReturnDateOfTomorrow() {
        //given
        Item item = new Item();
        item.setName("pen");
        item.setDescription("blue pen");
        item.setPrice("1.00");
        item.setAmountInStock("5");
        itemService.createItem(item);

        ItemGroup itemGroup = new ItemGroup();
        itemGroup.setItemId(item.getId());
        itemGroup.setAmount("4");

        String expectedResult = LocalDate.now().plusDays(1).toString();

        //when
        String actualResult = orderService.calculateShippingDate(itemGroup);

        //then
        assertThat(actualResult)
                .isEqualTo(expectedResult);
    }

    @Test
    public void calculateShippingDate_givenAnItemGroupWithARequestedItemThatIsNotInStock_thenReturnDateOfTodayPlus7Days() {
        //given
        Item item = new Item();
        item.setName("pen");
        item.setDescription("blue pen");
        item.setPrice("1.00");
        item.setAmountInStock("5");
        itemService.createItem(item);

        ItemGroup itemGroup = new ItemGroup();
        itemGroup.setItemId(item.getId());
        itemGroup.setAmount("8");

        String expectedResult = LocalDate.now().plusDays(7).toString();

        //when
        String actualResult = orderService.calculateShippingDate(itemGroup);

        //then
        assertThat(actualResult)
                .isEqualTo(expectedResult);
    }

    @SpringBootApplication(scanBasePackages = {"com.mygroupid"})
    public static class OrderServiceIntegrationTestRunner {

        public static void main(String[] args) {
            run(OrderServiceIntegrationTestRunner.class, args);
        }
    }

}
*/
