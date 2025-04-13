/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.shoppingcartlld.entity;

import java.util.List;

/**
 *
 * @author SUMAN
 */
public class Cart {
    
    private List<List<CartItems>> cartItems;

    public List<List<CartItems>> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<List<CartItems>> cartItems) {
        this.cartItems = cartItems;
    }

    public Cart(List<List<CartItems>> cartItems) {
        this.cartItems = cartItems;
    }

    

    @Override
    public String toString() {
        return "Cart{" + "cartItems=" + cartItems + '}';
    }
    
}
