package com.mygroupid.api.orders;

import com.mygroupid.api.customers.CustomerDto;

import java.util.List;

public class OrderDto {

    private String id;
    private CustomerDto customer;
    private List<ItemGroupDto> itemGroups;
    private String price;

    private OrderDto() {}

    public static OrderDto orderDto() {
        return new OrderDto();
    }

    public OrderDto withId(String id) {
        this.id = id;
        return this;
    }

    public OrderDto withCustomerDto(CustomerDto customerDto) {
        this.customer = customerDto;
        return this;
    }

    public OrderDto withItemGroupsDto(List<ItemGroupDto> itemGroupsDto) {
        this.itemGroups = itemGroupsDto;
        return this;
    }

    public OrderDto withPrice(String price) {
        this.price = price;
        return this;
    }

    public String getId() {
        return id;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public List<ItemGroupDto> getItemGroups() {
        return itemGroups;
    }

    public String getPrice() {
        return price;
    }
}
