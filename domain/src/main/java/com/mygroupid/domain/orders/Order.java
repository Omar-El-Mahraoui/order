/*
package com.mygroupid.domain.orders;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.items.ItemGroup;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Order {

    private UUID id;
    private Customer customer;
    private ItemGroup itemGroup;

    public Order(Customer customer, ItemGroup itemGroup) {
        id = UUID.randomUUID();
        this.customer = customer;
        this.itemGroup = itemGroup;
    }

    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public BigDecimal getPrice() {
        return itemGroup.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(customer, order.customer) &&
                Objects.equals(itemGroup, order.itemGroup);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customer, itemGroup);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", itemGroup=" + itemGroup +
                '}';
    }
}
*/
