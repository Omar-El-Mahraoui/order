package com.mygroupid.domain.items;
// copied and adapted code from funiversity example switchfully
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Item {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private int amountInStock;

    private Item() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    private void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return amountInStock == item.amountInStock &&
                Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(description, item.description) &&
                Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, amountInStock);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amountInStock=" + amountInStock +
                '}';
    }

    public static class ItemBuilder {

        private String name;
        private String description;
        private BigDecimal price;
        private int amountInStock;

        private ItemBuilder() {}

        public static ItemBuilder item() { return new ItemBuilder(); }

        public Item build() {
            Item item = new Item();
            item.setName(name);
            item.setDescription(description);
            item.setPrice(price);
            item.setAmountInStock(amountInStock);
            return item;
        }

        public ItemBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ItemBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ItemBuilder withAmountInStock(int amountInStock) {
            this.amountInStock = amountInStock;
            return this;
        }
    }
}
