package com.mygroupid.domain.orders;

public class ItemGroup {

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
