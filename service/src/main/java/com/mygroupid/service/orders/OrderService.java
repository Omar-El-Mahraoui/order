package com.mygroupid.service.orders;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.orders.ItemGroup;
import com.mygroupid.domain.orders.Order;
import com.mygroupid.domain.orders.OrderDatabase;
import com.mygroupid.service.customers.CustomerService;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;

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
                .filter(order->order.getItemGroup().getShippingDate().equals(LocalDate.now().toString()))
                .collect(toList());
    }
}
