/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.shoppingcartlld.repository;

import com.mycompany.practice.spring.shoppingcartlld.entity.LoginData;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
public class LoginDataRepository {
    
    Logger LOGGER = Logger.getLogger(getClass().getName());
    LoginData loginDatas = new LoginData();
    List<LoginData> login = new ArrayList<>();
    public void RegisterLoginData(LoginData loginData){
        login.add(loginData);
        LOGGER.info("Login Data is registered successfully");
    }
    public boolean loginLoginData(String email,String password){
        boolean status= false;
        for(int i=0;i<login.size();i++){
            loginDatas =  login.get(i);
            LOGGER.info("LoginData Repository Login component is being executed");
            if(email.equals(loginDatas.getEmail())&&email.equals(loginDatas.getPassword())){
                status =true;
                return status;
            }else{
                return status;
            }
        }
        return status;
    }
    public String getRole(String email,String password){
        String role="";
        for(int i=0;i<login.size();i++){
            loginDatas =  login.get(i);
            LOGGER.info("LoginData Repository getRole component is being executed");
            if(email.equals(loginDatas.getEmail())&&email.equals(loginDatas.getPassword())){
                role = loginDatas.getRole();
                return role;
            }else{
                return role;
            }
        }
        return role;
    }
    
}
