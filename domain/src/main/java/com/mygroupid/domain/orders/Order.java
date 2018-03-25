package com.mygroupid.domain.orders;

import com.mygroupid.domain.customers.Customer;

import java.util.UUID;

public class Order {

    private String id;
    private Customer customer;
    private ItemGroup itemGroup;

    public Order() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
    }
}
