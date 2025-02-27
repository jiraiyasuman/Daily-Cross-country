/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.service.impl;
import com.mycompany.practice.spring.librarymanagementsystem.entity.User;
import com.mycompany.practice.spring.librarymanagementsystem.service.*;
import com.mycompany.practice.spring.librarymanagementsystem.entity.*;
import com.mycompany.practice.spring.librarymanagementsystem.exception.ErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author SUMAN
 */
public class UserServiceImpl implements UserService{

    List<User> users =new ArrayList<>();
    @Override
    public User registerUser(String userName,String email,String password) {
        try {
            Random rand = new Random();
            int id = rand.nextInt(10000);
            User user = new User();
            user.setId(id);
            user.setUserName(userName);
            user.setEmail(email);
            user.setPassword(password);
            if(user!=null){
                System.out.println("User Registration is successfull");
                users.add(user);
                return user;
            }else{
                throw  new ErrorException("Oops due to some exception, user could not be registered!");
            }
        } catch (Exception e) {
            e.printStackTrace();
           // return null;
        }
    return null;
    }
    @Override
    public boolean loginUser(String email, String password) {
        User user=null;   
        try {
            for(int i=0;i<users.size();i++){
               user=users.get(i);
               if(user.getEmail().equals(email)&&user.getPassword().equals(password)){
                   System.out.println("Login is successful");
                   return true;
               }else{
                   throw new ErrorException("Login/Password is incorrect");
               }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
