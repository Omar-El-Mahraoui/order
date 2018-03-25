package com.mygroupid.api.orders;

import com.mygroupid.api.customers.CustomerDto;

import java.util.List;

public class OrderDto {

    private CustomerDto customer;
    private List<ItemGroupDto> itemGroups;


    public OrderDto(CustomerDto customer, List<ItemGroupDto> itemGroups) {
        this.customer = customer;
        this.itemGroups = itemGroups;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public List<ItemGroupDto> getItemGroups() {
        return itemGroups;
    }
}
