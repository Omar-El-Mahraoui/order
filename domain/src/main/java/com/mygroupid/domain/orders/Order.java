package com.mygroupid.domain.orders;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.items.ItemGroup;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.Collections.unmodifiableList;

public class Order {

    private UUID id;
    private Customer customer;
    private List<ItemGroup> itemGroups;

    public Order(Customer customer, List<ItemGroup> itemGroups) {
        id = UUID.randomUUID();
        this.customer = customer;
        this.itemGroups = itemGroups;
    }

    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ItemGroup> getItemGroups() {
        return unmodifiableList(itemGroups);
    }

    public BigDecimal getPrice() {
        return itemGroups.stream()
                .map(ItemGroup::getPrice)
                .reduce(BigDecimal.ZERO.setScale(2, RoundingMode.CEILING), BigDecimal::add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(customer, order.customer) &&
                Objects.equals(itemGroups, order.itemGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, itemGroups);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", itemGroups=" + itemGroups +
                '}';
    }
}
