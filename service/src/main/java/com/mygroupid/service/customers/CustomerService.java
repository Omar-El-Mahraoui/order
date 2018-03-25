package com.mygroupid.service.customers;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.customers.CustomerDatabase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CustomerService {

    @Inject
    private CustomerDatabase customerDatabase;

    public Customer createCustomer(Customer customer) {
        return customerDatabase.createCustomer(customer);
    }

    public List<Customer> getCustomers() {
        return customerDatabase.getCustomers();
    }

    public Customer getCustomer(String id) {
        return customerDatabase.getCustomer(id);
    }
}
