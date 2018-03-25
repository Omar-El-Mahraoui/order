/*
package com.mygroupid.api.customers;

import com.mygroupid.domain.customers.Customer;

import javax.inject.Named;

import static com.mygroupid.api.customers.CustomerDto.customerDto;
import static com.mygroupid.domain.customers.Customer.CustomerBuilder.customer;

@Named
public class CustomerMapper {

    public CustomerDto toDto(Customer customer) {
        return customerDto()
                .withFirstName(customer.getFirstName())
                .withLastName(customer.getLastName())
                .withEmailAddress(customer.getEmailAddress())
                .withAddress(customer.getAddress())
                .withPhoneNumber(customer.getPhoneNumber());
    }

    public Customer toDomain(CustomerDto customerDto) {
        return customer()
                .withFirstName(customerDto.getFirstName())
                .withLastName(customerDto.getLastName())
                .withEmailAddress(customerDto.getEmailAddress())
                .withAddress(customerDto.getAddress())
                .withPhoneNumber(customerDto.getPhoneNumber())
                .build();
    }

}
*/