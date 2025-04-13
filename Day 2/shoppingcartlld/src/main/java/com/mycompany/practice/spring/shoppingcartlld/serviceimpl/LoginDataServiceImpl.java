/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.shoppingcartlld.serviceimpl;

import com.mycompany.practice.spring.shoppingcartlld.entity.LoginData;
import com.mycompany.practice.spring.shoppingcartlld.repository.LoginDataRepository;
import com.mycompany.practice.spring.shoppingcartlld.service.LoginDataService;
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
public class LoginDataServiceImpl implements LoginDataService{

    Logger LOGGER = Logger.getLogger(getClass().getName());
    LoginDataRepository loginDataRepository = new LoginDataRepository();
    @Override
    public void RegisterLoginData(LoginData loginData) {
        loginDataRepository.RegisterLoginData(loginData);
        LOGGER.info("LoginServiceImpl registration is being added successfully");
    }

    @Override
    public boolean loginLoginData(String email, String password) {
       boolean status= false;
       status =loginDataRepository.loginLoginData(email, password);
       if(status)
           return status;
       else
           return status;
    }
    
}
