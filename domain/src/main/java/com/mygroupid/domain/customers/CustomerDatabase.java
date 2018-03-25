package com.mygroupid.domain.customers;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Named
public class CustomerDatabase {

    private List<Customer> customers;

    public CustomerDatabase() {
        this.customers = new ArrayList<>();
    }

    public Customer createCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public List<Customer> getCustomers() {
        return unmodifiableList(customers);
    }

    public void clearDatabase() {
        customers.clear();
    }
}
