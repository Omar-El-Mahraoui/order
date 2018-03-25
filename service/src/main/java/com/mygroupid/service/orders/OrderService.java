package com.mygroupid.service.orders;

import com.mygroupid.domain.orders.Order;
import com.mygroupid.domain.orders.OrderRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Named
public class OrderService {

    @Inject
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.createOrder(order);
    }

    public String showPrice(Order order) {
        return null;
    }

    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }
}
