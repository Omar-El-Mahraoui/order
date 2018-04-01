package com.mygroupid.api.items;
// copied and adapted code from funiversity example switchfully

public class ItemDto {

    private String id;
    private String name;
    private String description;
    private String price;
    private String amountInStock;

    private ItemDto() {}

    public static ItemDto itemDto() { return new ItemDto(); }

    public ItemDto withId(String id) {
        this.id = id;
        return this;
    }

    public ItemDto withName(String name) {
        this.name = name;
        return this;
    }

    public ItemDto withDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemDto withPrice(String price) {
        this.price = price;
        return this;
    }

    public ItemDto withAmountInStock(String amountInStock) {
        this.amountInStock = amountInStock;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getAmountInStock() {
        return amountInStock;
    }
}
