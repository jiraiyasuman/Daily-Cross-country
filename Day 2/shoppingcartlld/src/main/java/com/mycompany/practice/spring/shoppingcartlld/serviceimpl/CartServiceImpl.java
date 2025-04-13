/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.shoppingcartlld.serviceimpl;

import com.mycompany.practice.spring.shoppingcartlld.entity.CartItems;
import com.mycompany.practice.spring.shoppingcartlld.repository.CartRepository;
import com.mycompany.practice.spring.shoppingcartlld.service.CartService;

/**
 *
 * @author SUMAN
 */
public class CartServiceImpl implements CartService{

    private CartRepository cartRepository;
    @Override
    public boolean addCart(CartItems cartItems) {
      boolean status=false;
      status=cartRepository.addItemsCart(cartItems);
      if(status)
      return status;
      else
          return status;
    }

    @Override
    public void displayList(String email) {
      cartRepository.diplayCart(email,false);
    }
    
}
