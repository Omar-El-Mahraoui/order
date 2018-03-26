package com.mygroupid.api.orders;

import com.mygroupid.api.customers.CustomerDto;

public class OrderDto {

    private String id;
    private CustomerDto customer;
    private ItemGroupDto itemGroup;
    private String price;

    public OrderDto() {}

    public String getId() {
        return id;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public ItemGroupDto getItemGroup() {
        return itemGroup;
    }

    public String getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public void setItemGroup(ItemGroupDto itemGroup) {
        this.itemGroup = itemGroup;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
