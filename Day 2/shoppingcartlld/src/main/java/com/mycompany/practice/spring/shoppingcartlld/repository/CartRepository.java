/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.shoppingcartlld.repository;

import com.mycompany.practice.spring.shoppingcartlld.entity.Cart;
import com.mycompany.practice.spring.shoppingcartlld.entity.CartItems;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
public class CartRepository {
    
    List<CartItems> listCartItem = new ArrayList<>();
    List<List<CartItems>> listCart = new ArrayList<>();
    private Logger LOGGER = Logger.getLogger(getClass().getName());
    public boolean addItemsCart(CartItems cartItems){
        boolean status = false;
        listCartItem.add(cartItems);
        status=true;
        return status;
    }
    public void addCart(){
        listCart.add(listCartItem);
        listCartItem.removeAll(listCartItem);
    }
    public void diplayCart(String email,boolean paymentStatus){
       // List<CartItems> temp = new ArrayList<>();
        CartItems items = new CartItems();
        for(int i =0;i<listCart.size();i++){
            
            for(int j=0;j<listCart.get(i).size();j++){
                items = (listCart.get(i)).get(j);
                if(email.equalsIgnoreCase(items.getEmail())&&(items.isPaymentStatus()==paymentStatus))
                    System.out.println(items.toString());
                else
                    continue;
            }
        }
    }
    
}
