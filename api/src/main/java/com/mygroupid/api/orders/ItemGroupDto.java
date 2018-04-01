package com.mygroupid.api.orders;

import com.mygroupid.api.items.ItemDto;

import java.util.Objects;
// copied and adapted code from funiversity example switchfully

public class ItemGroupDto {

    private String id;
    private ItemDto item;
    private String amount;
    private String shippingDate;

    private ItemGroupDto() {}

    public static ItemGroupDto itemGroupDto() { return new ItemGroupDto(); }

    public ItemGroupDto withId(String id) {
        this.id = id;
        return this;
    }

    public ItemGroupDto withItemDto(ItemDto itemDto) {
        this.item = itemDto;
        return this;
    }

    public ItemGroupDto withAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public ItemGroupDto withShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public String getId() {
        return id;
    }

    public ItemDto getItemDto() {
        return item;
    }

    public String getAmount() {
        return amount;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemGroupDto that = (ItemGroupDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(item, that.item) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(shippingDate, that.shippingDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, item, amount, shippingDate);
    }

    @Override
    public String toString() {
        return "ItemGroupDto{" +
                "id='" + id + '\'' +
                ", item=" + item +
                ", amount='" + amount + '\'' +
                ", shippingDate='" + shippingDate + '\'' +
                '}';
    }
}
