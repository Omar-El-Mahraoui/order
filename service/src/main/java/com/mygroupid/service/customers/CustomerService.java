package com.mygroupid.service.customers;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.customers.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.createCustomer(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    public Customer getCustomer(String id) {
        return customerRepository.getCustomer(id);
    }
}
