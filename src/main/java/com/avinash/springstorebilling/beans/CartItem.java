package com.avinash.springstorebilling.beans;

public class CartItem {
    private int quantity;
    private int totalPrice;
    private int price;
    private String itemName;

    public int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public CartItem setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public CartItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public CartItem setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public CartItem setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", price=" + price +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
