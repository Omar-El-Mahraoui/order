package com.mygroupid.api.orders;

import com.mygroupid.api.customers.CustomerDto;

public class OrderDto {

    private String id;
    private CustomerDto customer;
    private ItemGroupDto[] itemGroups;
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

    public OrderDto withItemGroupsDto(ItemGroupDto[] itemGroupsDto) {
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

    public ItemGroupDto[] getItemGroups() {
        return itemGroups;
    }

    public String getPrice() {
        return price;
    }
}
