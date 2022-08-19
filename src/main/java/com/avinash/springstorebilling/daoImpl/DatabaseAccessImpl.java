package com.avinash.springstorebilling.daoImpl;

import com.avinash.springstorebilling.ApplicationContextHolder;
import com.avinash.springstorebilling.beans.Cart;
import com.avinash.springstorebilling.beans.CartItem;
import com.avinash.springstorebilling.beans.Item;
import com.avinash.springstorebilling.dao.DatabaseAccessLayer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DatabaseAccessImpl implements DatabaseAccessLayer {

    private static DatabaseAccessImpl databaseAccess;

    public static DatabaseAccessImpl getInstance(){
        if(databaseAccess == null){
            databaseAccess = new DatabaseAccessImpl();
        }
        return databaseAccess;
    }
    @Override
    public List<Item> getItems() {
        JdbcTemplate jdbcTemplate = ApplicationContextHolder.getJdbcTemplate();
        String sql = "SELECT * from item";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Item.class));
    }
    @Override
    public List<Item> getSelectedItems(String items) {
        JdbcTemplate jdbcTemplate = ApplicationContextHolder.getJdbcTemplate();
        String query = "SELECT * from item where itemId IN "+items;
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Item.class));
    }

    @Override
    public void insertIntoCart(Cart cart) {
        JdbcTemplate jdbcTemplate = ApplicationContextHolder.getJdbcTemplate();
        for (CartItem cartItem : cart.getCartItems()) {

            String query = "INSERT INTO Cart VALUES('"+cartItem.getItemName()+"',"+cartItem.getQuantity()+","+ cartItem.getPrice()+"" +
                    ", "+ cartItem.getTotalPrice()+",'"+cart.getUniqueId()+"')";
            jdbcTemplate.update(query);
        }


    }


}
