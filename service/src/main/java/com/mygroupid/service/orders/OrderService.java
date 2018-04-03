package com.mygroupid.service.orders;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.orders.Order;
import com.mygroupid.domain.orders.OrderDatabase;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Named
public class OrderService {

    @Inject
    private OrderDatabase orderDatabase;

    public List<Order> getOrders() {
        return orderDatabase.getOrders();
    }

    public Order createOrder(Order order, Customer customer) {
        order.setCustomer(customer);
        calculateShippingDateForEachItemGroupInOrder(order);
        calculateTotalPrice(order);
        return orderDatabase.createOrder(order);
    }

    private void calculateShippingDateForEachItemGroupInOrder(Order order) {
        for (int index=0; index<order.getItemGroups().size(); index++) {
            if (order.getItemGroups().get(index).getAmount()
                    <= order.getItemGroups().get(index).getItem().getAmountInStock()) {
                order.getItemGroups().get(index).setShippingDate(LocalDate.now().plusDays(1));
            } else {
                order.getItemGroups().get(index).setShippingDate(LocalDate.now().plusDays(7));
            }
        }
    }

    private void calculateTotalPrice(Order order) {
        BigDecimal price = BigDecimal.ZERO;
        for (int index=0; index<order.getItemGroups().size(); index++) {
            order.setPrice(price.add(order.getItemGroups().get(index).getItem().getPrice()
                    .multiply(new BigDecimal(order.getItemGroups().get(index).getAmount()))));
        }
    }

}
