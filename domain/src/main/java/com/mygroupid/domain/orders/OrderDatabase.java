package com.mygroupid.domain.orders;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
public class OrderDatabase {

    private List<Order> orders;

    public OrderDatabase() {
        orders = new ArrayList<>();
    }

    public Order createOrder(Order order) {
        orders.add(order);
        return order;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }
}
