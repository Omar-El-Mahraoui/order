package com.mygroupid.api.customers;

import com.mygroupid.domain.customers.Customer;

import javax.inject.Named;

import static com.mygroupid.api.customers.CustomerDto.customerDto;

@Named
public class CustomerMapper {

    public CustomerDto toDto(Customer customer) {
        return customerDto()
                .withId(customer.getId())
                .withFirstName(customer.getFirstName())
                .withLastName(customer.getLastName())
                .withEmailAddress(customer.getEmailAddress())
                .withAddress(customer.getAddress())
                .withPhoneNumber(customer.getAddress());
    }

    public Customer toDomain(CustomerDto customerDto) {
        return Customer.CustomerBuilder.customer()
                .withFirstName(customerDto.getFirstName())
                .withLastName(customerDto.getLastName())
                .withEmailAddress(customerDto.getEmailAddress())
                .withAddress(customerDto.getAddress())
                .withPhoneNumber(customerDto.getPhoneNumber())
                .build();
    }

}
