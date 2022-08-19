package com.avinash.springstorebilling.dao;

import com.avinash.springstorebilling.beans.Cart;
import com.avinash.springstorebilling.beans.CartItem;
import com.avinash.springstorebilling.beans.Item;

import java.util.List;

public interface DatabaseAccessLayer {
    List<Item> getItems();
    List<Item> getSelectedItems(String items);
    void insertIntoCart(Cart cart);
}
