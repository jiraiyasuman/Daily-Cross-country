/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.shoppingcartlld.service;

import com.mycompany.practice.spring.shoppingcartlld.entity.Product;

/**
 *
 * @author SUMAN
 */
public interface ProductService {
    
    public boolean addProduct(Product product);
    public void getAllList();
    public boolean updateProduct(Product product);
    public void getProductByCategory(String category);
    public void getProductByName(String name);
    public void deleteProductByName(String name);
}
