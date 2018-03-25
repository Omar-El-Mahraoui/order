package com.mygroupid.service.customers;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.customers.CustomerRepository;
import com.mygroupid.domain.orders.Order;
import com.mygroupid.service.orders.OrderService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;
    @Inject
    private OrderService orderService;

    public Customer createCustomer(Customer customer) {
        return customerRepository.createCustomer(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    public void clearDatabase() {
        customerRepository.clearDatabase();
    }

    public Order order(Order order) {
        return orderService.createOrder(order);
    }

}
