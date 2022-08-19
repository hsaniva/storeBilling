package com.avinash.springstorebilling.controllers;

import com.avinash.springstorebilling.beans.Cart;
import com.avinash.springstorebilling.beans.CartItem;
import com.avinash.springstorebilling.beans.Item;
import com.avinash.springstorebilling.daoImpl.DatabaseAccessImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Controller
public class MVController {

    @GetMapping("/loadShopPage")
    public String loadShopPage(Model model) {
        List<Item> items = DatabaseAccessImpl.getInstance().getItems();
        model.addAttribute("itemList", items);
        return "shop";
    }

    @PostMapping("/checkout")
    public String proceedToCheckout(@RequestBody String inputString, Model model){
        inputString = URLDecoder.decode(inputString, StandardCharsets.UTF_8);
        inputString = inputString.substring(2, inputString.length());
        JSONObject jsonObject = new JSONObject(inputString);
        JSONArray jsonArray = jsonObject.names();
        List<CartItem> cartItems = new ArrayList<>();
        int totalPrice = 0;

        for(int i = 0; i < jsonArray.length(); i++){
            totalPrice += (Integer) ((JSONObject)jsonObject.get(jsonArray.getString(i))).get("totalPrice");
        }
        jsonArray.forEach(key->{
            JSONObject jsonObject1 = (JSONObject)jsonObject.get(key.toString());
            cartItems.add(new CartItem().setPrice((Integer) jsonObject1.get("price"))
                    .setQuantity((Integer) jsonObject1.get("quantity"))
                    .setTotalPrice((Integer) jsonObject1.get("totalPrice"))
                    .setItemName(key.toString()));
        });
//        String uniqueId = UUID.randomUUID().toString().replace('-', '\0');
        String uniqueId = String.valueOf((int)(Math.random()*1000000));
        Cart cart = new Cart();
        cart.setCartItems(cartItems);
        cart.setUniqueId(uniqueId);

        DatabaseAccessImpl.getInstance().insertIntoCart(cart);
        model.addAttribute("cartId", uniqueId);
        model.addAttribute("totalPrice", totalPrice);

        return "checkout";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestBody String inputString, Model model){
        try {
            inputString = URLDecoder.decode(inputString, StandardCharsets.UTF_8);
            inputString = inputString.substring(2, inputString.length());

            if(inputString.isEmpty()){
                model.addAttribute("selectedItems", Collections.emptyList());
                return "cart";
            }
            inputString = "(" + inputString + ")";
            List<Item> selectedItems = DatabaseAccessImpl.getInstance().getSelectedItems(inputString);
            model.addAttribute("selectedItems", selectedItems);
            return "cart";
        }catch (JSONException err){
            System.err.println(err.getStackTrace());
        }
        model.addAttribute("selectedItems", Collections.emptyList());
        return "cart";
    }


    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody String inputString, Model model){
        JSONObject jsonObject = new JSONObject(inputString);
//        model.addAttribute("object", jsonObject);
        return "invoice";
    }

}
