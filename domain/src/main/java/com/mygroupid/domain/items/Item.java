package com.mygroupid.domain.items;

import java.util.Objects;
import java.util.UUID;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Item {

    private String id;
    private String name;
    private String description;
    private String price;
    private String amountInStock;
    private UrgencyIndicator urgencyIndicator;

    public Item() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(String amountInStock) {
        this.amountInStock = amountInStock;
    }

    public void decrementAmountInStock(String amountToSubtract) {
        this.amountInStock = valueOf(parseInt(amountInStock) - parseInt(amountToSubtract));
    }

    public UrgencyIndicator getUrgencyIndicator() {
        return urgencyIndicator;
    }

    public void setUrgencyIndicator(UrgencyIndicator urgencyIndicator) {
        this.urgencyIndicator = urgencyIndicator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(description, item.description) &&
                Objects.equals(price, item.price) &&
                Objects.equals(amountInStock, item.amountInStock) &&
                urgencyIndicator == item.urgencyIndicator;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, price, amountInStock, urgencyIndicator);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", amountInStock='" + amountInStock + '\'' +
                ", urgencyIndicator=" + urgencyIndicator +
                '}';
    }
}
