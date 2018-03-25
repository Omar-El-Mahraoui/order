/*
package com.mygroupid.domain.items;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

public class ItemGroup {

    private Item item;
    private int amountOfItems;
    private LocalDate shippingDate;

    private ItemGroup() {
        setShippingDate();
    }

    public Item getItem() {
        return item;
    }

    private void setItem(Item item) {
        this.item = item;
    }

    public int getAmountOfItems() {
        return amountOfItems;
    }

    private void setAmountOfItems(int amountOfItems) {
        this.amountOfItems = amountOfItems;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    private void setShippingDate() {
        if (item.isInStock()) {
            shippingDate = LocalDate.now().plusDays(1);
        } else {
            shippingDate = LocalDate.now().plusDays(7);
        }
    }

    public BigDecimal getPrice() {
        return item.getPrice().multiply(BigDecimal.valueOf(amountOfItems).setScale(2, RoundingMode.CEILING));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemGroup itemGroup = (ItemGroup) o;
        return amountOfItems == itemGroup.amountOfItems &&
                Objects.equals(item, itemGroup.item) &&
                Objects.equals(shippingDate, itemGroup.shippingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, amountOfItems, shippingDate);
    }

    @Override
    public String toString() {
        return "ItemGroup{" +
                "item=" + item +
                ", amountOfItems=" + amountOfItems +
                ", shippingDate=" + shippingDate +
                '}';
    }

    public static class ItemGroupBuilder {
        private Item item;
        private int amountOfItems;
        private LocalDate shippingDate;

        private ItemGroupBuilder() {}

        public static ItemGroupBuilder itemGroup() { return new ItemGroupBuilder(); }

        public ItemGroup build() {
            ItemGroup itemGroup = new ItemGroup();

            itemGroup.setItem(item);
            itemGroup.setAmountOfItems(amountOfItems);

            return itemGroup;
        }

        public ItemGroupBuilder withItem(Item item) {
            this.item = item;
            return this;
        }

        public ItemGroupBuilder withAmountOfItems(int amountOfItems) {
            this.amountOfItems = amountOfItems;
            return this;
        }
    }
}
*/
