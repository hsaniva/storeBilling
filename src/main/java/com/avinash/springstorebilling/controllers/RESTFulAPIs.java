package com.avinash.springstorebilling.controllers;

import com.avinash.springstorebilling.beans.Item;
import com.avinash.springstorebilling.daoImpl.DatabaseAccessImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTFulAPIs {
    @GetMapping("/getAllItems")
    public List<Item> getAllItems() {
        return DatabaseAccessImpl.getInstance().getItems();
    }
}
