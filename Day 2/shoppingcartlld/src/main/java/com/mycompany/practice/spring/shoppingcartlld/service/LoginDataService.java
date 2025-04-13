/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.shoppingcartlld.service;

import com.mycompany.practice.spring.shoppingcartlld.entity.LoginData;

/**
 *
 * @author SUMAN
 */
public interface LoginDataService {
    
    public void RegisterLoginData(LoginData loginData);
    public boolean loginLoginData(String email,String password);
}
