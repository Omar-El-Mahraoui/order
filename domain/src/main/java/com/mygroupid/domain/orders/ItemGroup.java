package com.mygroupid.domain.orders;

import com.mygroupid.domain.items.ItemDatabase;

import javax.inject.Inject;

public class ItemGroup {

    @Inject
    private ItemDatabase itemDatabase;

    private String itemId;
    private String amount;
    private String shippingDate;

    public ItemGroup() {
    }

    public String getItemId() {
        return itemId;
    }

    public String getAmount() {
        return amount;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
