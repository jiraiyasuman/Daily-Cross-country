/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.shoppingcartlld.service;

import com.mycompany.practice.spring.shoppingcartlld.entity.CartItems;

/**
 *
 * @author SUMAN
 */
public interface CartService {
    
    public boolean addCart(CartItems cartItems);
    public void displayList(String email);
}
