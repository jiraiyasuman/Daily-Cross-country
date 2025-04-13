/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.shoppingcartlld.repository;

import com.mycompany.practice.spring.shoppingcartlld.entity.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.*;
/**
 *
 * @author SUMAN
 */
public class ProductRepository {
    private List<Product> productList = new ArrayList<>();
    private Logger LOGGER = Logger.getLogger(getClass().getName());
    public boolean addProduct(Product product){
        boolean status= false;
        try {
            productList.add(product);
            status =true;
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public void displayAllProduct(){
        Product product=new Product();
        for(int i=0;i<productList.size();i++){
            product=productList.get(i);
            System.out.println(product.toString());
        }
    }
    
    public boolean updateProduct(Product product){
        boolean status=false;
        Product getProduct= new Product();
        String name= product.getProductName();
        try {
            for(int i=0;i<productList.size();i++){
                getProduct = productList.get(i);
                if(getProduct.getProductName().equalsIgnoreCase(name)){
                    getProduct.setProductName(product.getProductName());
                    getProduct.setCategory(product.getCategory());
                    getProduct.setStock(product.getStock());
                    getProduct.setPrice(product.getPrice());
                    productList.set(i,getProduct);
                    LOGGER.info("Product Respository update component is being executed");
                    status=true;
                    return status;
                }
                
            }
        } catch (Exception e) {    
        e.printStackTrace();
        }
        return status;
    }
    public void getProductByCategory(String category){
        List<Product> list= new ArrayList<>();
        Product product = new Product();
        for(int i=0; i<productList.size();i++){
            product = productList.get(i);
            if(product.getCategory().equalsIgnoreCase(category)){
                list.add(product);
            }
        }
        // displlays the list 
        for(int i=0;i<list.size();i++){
            product=list.get(i);
            System.out.println(product.toString());
        }
        LOGGER.info("Product Respository getProductByCategory component is being executed");
    }
    public void getProductByName(String productName){
        List<Product> list= new ArrayList<>();
        Product product = new Product();
        for(int i=0; i<productList.size();i++){
            product = productList.get(i);
            if(product.getProductName().equalsIgnoreCase(productName)){
                list.add(product);
            }
        }
        // displlays the list 
        for(int i=0;i<list.size();i++){
            product=list.get(i);
            System.out.println(product.toString());
        }
        LOGGER.info("Product Respository getProductByName component is being executed");
    }
    
    public void deleteProductByName(String productName){
        Product product = new Product();
        for(int i=0; i<productList.size();i++){
            product = productList.get(i);
            if(product.getProductName().equalsIgnoreCase(productName)){
                productList.remove(i);
            }
        }
        LOGGER.info("Product Respository delete component is being executed");
    }
    public void getProductsSorted(){
        List<Product> sorted = new ArrayList<>(productList);
        sorted.addAll(productList);
        sorted.sort(Comparator.comparingDouble(Product::getPrice));
        Product product= new Product();
        for (int i=0;i<sorted.size();i++){
            product=sorted.get(i);
            System.out.println(product.toString());
        }
        
    }
    
    public int getStock(String productName){
        Product product= new Product();
        int stock =0;
        for(int i=0; i<productList.size();i++){
            product = productList.get(i);
            if(product.getProductName().equalsIgnoreCase(productName)){
                stock = product.getStock();
                return stock;
            }
        }
        return stock;
    }
    public double getPrice(String productName){
        Product product= new Product();
        double stock =0.0d;
        for(int i=0; i<productList.size();i++){
            product = productList.get(i);
            if(product.getProductName().equalsIgnoreCase(productName)){
                stock = product.getPrice();
                return stock;
            }
        }
        return stock;
    }
}
