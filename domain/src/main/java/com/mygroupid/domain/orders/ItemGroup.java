package com.mygroupid.domain.orders;

import com.mygroupid.domain.items.Item;

import java.time.LocalDate;

import static java.lang.Integer.parseInt;

public class ItemGroup {

    private Item item;
    private String amount;
    private String shippingDate;

    public ItemGroup() {
    }

    public void setShippingDate() {
        if (parseInt(item.getAmountInStock()) >= parseInt(amount)) {
            this.shippingDate = LocalDate.now().plusDays(1).toString();
        } else {
            this.shippingDate = LocalDate.now().plusDays(7).toString();
        }
    }

    public Item getItem() {
        return item;
    }

    public String getAmount() {
        return amount;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
