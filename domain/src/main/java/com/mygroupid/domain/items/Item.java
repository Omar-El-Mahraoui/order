package com.mygroupid.domain.items;

import java.util.UUID;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Item {

    private String id;
    private String name;
    private String description;
    private String price;
    private String amountInStock;

    public Item() {
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
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
}
