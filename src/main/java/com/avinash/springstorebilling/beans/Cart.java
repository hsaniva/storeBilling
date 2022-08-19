package com.avinash.springstorebilling.beans;

import java.util.List;

public class Cart {
    private String uniqueId;
    private List<CartItem> cartItems;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public Cart setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
        return this;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public Cart setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
        return this;
    }


}
