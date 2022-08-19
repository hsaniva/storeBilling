package com.avinash.springstorebilling.beans;

public class Item {
    private String itemId;
    private String brand;
    private String itemName;
    private long quantity;
    private String desc;
    private float discount;
    private float pricePerItem;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(float pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", brand='" + brand + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", desc='" + desc + '\'' +
                ", discount=" + discount +
                ", pricePerItem=" + pricePerItem +
                '}';
    }
}
