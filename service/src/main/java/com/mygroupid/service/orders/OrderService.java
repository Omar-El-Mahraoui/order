package com.mygroupid.service.orders;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.orders.ItemGroup;
import com.mygroupid.domain.orders.Order;
import com.mygroupid.domain.orders.OrderDatabase;
import com.mygroupid.service.customers.CustomerService;
import org.springframework.format.annotation.DateTimeFormat;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.LocalDate.now;
import static java.time.LocalDate.parse;
import static java.time.Period.between;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.stream.Collectors.toList;

@Named
public class OrderService {

    @Inject
    private CustomerService customerService;
    @Inject
    private OrderDatabase orderDatabase;

    public List<Order> getOrders() {
        return orderDatabase.getOrders();
    }

    public Order createOrder(String customerId, ItemGroup itemGroup) {
        Order order = new Order();
        order.setId();
        order.setCustomer(customerService.getCustomer(customerId));
        itemGroup.setShippingDate();
        order.setItemGroup(itemGroup);
        order.setPrice();
        orderDatabase.createOrder(order);
        itemGroup.getItem().decrementAmountInStock(itemGroup.getAmount());
        return order;
    }

    public List<Order> getReportOfOrders(String customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return orderDatabase.getOrders().stream()
                .filter(order->order.getCustomer().equals(customer))
                .collect(toList());
    }

    public Order createReOrder(String customerId, String orderId) {
        Order orderToReOrder = orderDatabase.getOrders().stream()
                .filter(order->order.getCustomer().getId().equals(customerId) && order.getId().equals(orderId))
                .findFirst()
                .get();
        createOrder(customerId, orderToReOrder.getItemGroup());
        orderToReOrder.getItemGroup().getItem()
                .decrementAmountInStock(orderToReOrder.getItemGroup().getAmount());
        return orderToReOrder;
    }

    public List<Order> getOrdersShippingToday() {
        return getOrders().stream()
                .filter(order->order.getItemGroup().getShippingDate().equals(now().toString()))
                .collect(toList());
    }

    public boolean wasOrderedInLast7Days(String itemId) {
        return getOrders().stream()
                .filter(order -> order.getItemGroup().getItem().getId().equals(itemId))
                .collect(toList())
                .stream()
                // https://www.mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
                .filter(order -> between(parse(order.getItemGroup().getShippingDate(), ofPattern("yyyy-mm-dd"))
                                                , now()).getDays() <= 7)
                .collect(toList())
                .size() != 0;
    }
}
