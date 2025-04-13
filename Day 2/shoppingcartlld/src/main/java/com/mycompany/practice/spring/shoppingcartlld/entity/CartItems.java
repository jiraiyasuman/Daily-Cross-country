/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.shoppingcartlld.entity;

/**
 *
 * @author SUMAN
 */
public class CartItems {
    
    private int id;
    private String productName;
    private String email;
    private String userName;
    private double totalPrice;
    private int quantity;
    private boolean paymentStatus;
    @Override
    public String toString() {
        return "CartItems{" + "id=" + id + ", productName=" + productName + ", email=" + email + ", userName=" + userName + ", totalPrice=" + totalPrice + ", quantity=" + quantity + ", paymentStatus=" + paymentStatus + '}';
    }
    public boolean isPaymentStatus() {
        return paymentStatus;
    }
    
    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public CartItems(int id, String productName, String email, String userName, double totalPrice, int quantity, boolean paymentStatus) {
        this.id = id;
        this.productName = productName;
        this.email = email;
        this.userName = userName;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.paymentStatus = paymentStatus;
    }

    

    public CartItems() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
