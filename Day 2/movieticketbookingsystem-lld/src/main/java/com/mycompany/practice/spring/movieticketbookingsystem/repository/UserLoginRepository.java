/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.repository;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.UserLogin;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
public class UserLoginRepository {
    
    private List<UserLogin> loginUserList =new ArrayList<>();
    private Logger LOGGER = Logger.getLogger(getClass().getName());
    public boolean registerUser(UserLogin userLogin){
        boolean status =false;
        try {
            loginUserList.add(userLogin);
            LOGGER.info("User Register Repository is being executed");
            status =true;
            return status;
        } catch (Exception e) {
        e.printStackTrace();
        }
        return status;
    }
    public boolean loginUser(String email,String password){
        boolean status = false;
        try {
              UserLogin loginUser = new UserLogin();
              for(int i = 0;i< loginUserList.size();i++){
                  loginUser = loginUserList.get(i);
                  if(email.equals(loginUser.getEmail())&& password.equals(loginUser.getPassword())){
                      System.out.println("Login is successful");
                      LOGGER.info("User Login repository is being executed");
                      status =true;
                      return status;
                  }else{
                      status=false;
                      return status;
                  }
              }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public boolean updatePassword(String email,String password){
        boolean status = false;
        try {
            UserLogin loginUser = new UserLogin();
            for(int i = 0;i< loginUserList.size();i++){
                  loginUser = loginUserList.get(i);
                  if(email.equals(loginUser.getEmail())&& password.equals(loginUser.getPassword())){
                      loginUser.setPassword(password);
                      loginUserList.set(i, loginUser);
                      System.out.println("Password is updated successfully");
                      LOGGER.info("User Login repository is being executed");
                      status =true;
                      return status;
                  }else{
                      status=false;
                      return status;
                  }
              }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
