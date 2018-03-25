package com.mygroupid.service.orders;

import com.mygroupid.domain.items.Item;
import com.mygroupid.domain.orders.ItemGroup;
import com.mygroupid.domain.orders.Order;
import com.mygroupid.domain.orders.OrderDatabase;
import com.mygroupid.service.customers.CustomerService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class OrderService {

    @Inject
    private CustomerService customerService;
    @Inject
    private OrderDatabase orderDatabase;

    public Order createOrder(String customerId, ItemGroup itemGroup) {
        Order order = new Order();
        order.setCustomer(customerService.getCustomer(customerId));
        itemGroup.setShippingDate();
        order.setItemGroup(itemGroup);
        orderDatabase.createOrder(order);
        return order;
    }

}
