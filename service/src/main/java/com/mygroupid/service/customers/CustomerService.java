package com.mygroupid.service.customers;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.customers.CustomerDatabase;
import com.mygroupid.service.exceptions.UnknownResourceException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.UUID;

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
        if (customerDatabase.getCustomer(id) == null) {
            throw new UnknownResourceException("ID", Customer.class.getSimpleName());
        }
        return customerDatabase.getCustomer(id);
    }

    public void clearDatabase() {
        customerDatabase.clearDatabase();
    }
}
