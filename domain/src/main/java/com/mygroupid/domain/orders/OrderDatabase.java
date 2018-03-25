package com.mygroupid.domain.orders;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class OrderDatabase {

    private List<Order> orders;

    public OrderDatabase() {
        this.orders = new ArrayList<>();
    }

    public Order createOrder(Order order) {
        orders.add(order);
        return order;
    }
}
