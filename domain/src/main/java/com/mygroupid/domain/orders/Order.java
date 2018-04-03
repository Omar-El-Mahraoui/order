package com.mygroupid.domain.orders;

import com.mygroupid.domain.customers.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Order {

    private UUID id;
    private Customer customer;
    private List<ItemGroup> itemGroups;
    private BigDecimal price;

    private Order() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    private void setItemGroups(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(customer, order.customer) &&
                Objects.equals(itemGroups, order.itemGroups) &&
                Objects.equals(price, order.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customer, itemGroups, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", itemGroups=" + itemGroups +
                ", price=" + price +
                '}';
    }

    public static class OrderBuilder {

        private Customer customer;
        private List<ItemGroup> itemGroups;
        private BigDecimal price;

        private OrderBuilder() {}

        public static OrderBuilder order() { return new OrderBuilder(); }

        public Order build() {
            Order order = new Order();
            order.setCustomer(customer);
            order.setItemGroups(itemGroups);
            order.setPrice(price);
            return order;
        }

        public OrderBuilder withCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public OrderBuilder withItemGroups(List<ItemGroup> itemGroups) {
            this.itemGroups = itemGroups;
            return this;
        }

        public OrderBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

    }
}
