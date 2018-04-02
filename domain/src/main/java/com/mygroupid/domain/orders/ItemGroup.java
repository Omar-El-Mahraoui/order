package com.mygroupid.domain.orders;

import com.mygroupid.domain.items.Item;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import static com.mygroupid.domain.items.Item.ItemBuilder.item;

public class ItemGroup {

    private UUID id;
    private Item item;
    private int amount;
    private LocalDate shippingDate;

    private ItemGroup() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    private void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    private void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemGroup itemGroup = (ItemGroup) o;
        return amount == itemGroup.amount &&
                Objects.equals(id, itemGroup.id) &&
                Objects.equals(item, itemGroup.item) &&
                Objects.equals(shippingDate, itemGroup.shippingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, amount, shippingDate);
    }

    @Override
    public String toString() {
        return "ItemGroup{" +
                "id=" + id +
                ", item=" + item +
                ", amount=" + amount +
                ", shippingDate=" + shippingDate +
                '}';
    }

    public static class ItemGroupBuilder {

        private Item item;
        private int amount;
        private LocalDate shippingDate;

        private ItemGroupBuilder() {}

        public static ItemGroupBuilder itemGroup() { return new ItemGroupBuilder(); }

        public ItemGroup build() {
            ItemGroup itemGroup = new ItemGroup();
            itemGroup.setItem(item);
            itemGroup.setAmount(amount);
            itemGroup.setShippingDate(shippingDate);
            return itemGroup;
        }

        public ItemGroupBuilder withItem(Item item) {
            Item itemCopy = item()
                                .withName(item.getName())
                                .withDescription(item.getDescription())
                                .withPrice(item.getPrice())
                                .withAmountInStock(item.getAmountInStock())
                                .build();
            this.item = itemCopy;
            return this;
        }

        public ItemGroupBuilder withAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public ItemGroupBuilder withShippingDate(LocalDate shippingDate) {
            this.shippingDate = shippingDate;
            return this;
        }

    }
}
