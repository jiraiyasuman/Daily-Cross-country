/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.shoppingcartlld.serviceimpl;

import com.mycompany.practice.spring.shoppingcartlld.entity.Product;
import com.mycompany.practice.spring.shoppingcartlld.repository.ProductRepository;
import com.mycompany.practice.spring.shoppingcartlld.service.ProductService;
import java.util.Collections;

/**
 *
 * @author SUMAN
 */
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    @Override
    public boolean addProduct(Product product) {
      
        boolean status= false;
        status = productRepository.addProduct(product);
        if(status){
            return status;
        }else{
            return status;
        }
    }

    public void getOrdersSorted(){
         productRepository.getProductsSorted();
    }
    @Override
    public void getAllList() {
     productRepository.displayAllProduct();
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean status= false;
        status = productRepository.updateProduct(product);
        if(status){
            return status;
        }else{
            return status;
        }
    }

    @Override
    public void getProductByCategory(String category) {
    productRepository.getProductByCategory(category);
    }

    @Override
    public void getProductByName(String name) {
     productRepository.getProductByName(name);
    }

    @Override
    public void deleteProductByName(String name) {
     productRepository.deleteProductByName(name);
    }
    
}
