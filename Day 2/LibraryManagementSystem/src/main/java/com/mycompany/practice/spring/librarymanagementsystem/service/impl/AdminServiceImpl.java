/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.service.impl;

import com.mycompany.practice.spring.librarymanagementsystem.entity.Admin;
import com.mycompany.practice.spring.librarymanagementsystem.entity.User;
import com.mycompany.practice.spring.librarymanagementsystem.exception.ErrorException;
//import com.mycompany.practice.spring.librarymanagementsystem.entity.User;
import com.mycompany.practice.spring.librarymanagementsystem.service.AdminService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author SUMAN
 */
public class AdminServiceImpl implements AdminService{

     List<Admin> admin =new ArrayList<>();
    @Override
    public Admin registerAdmin(String userName,String email,String password) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     try {
            Random rand = new Random();
            int id = rand.nextInt(10000);
            Admin admins = new Admin();
            admins.setId(id);
            admins.setUserName(userName);
            admins.setEmail(email);
            admins.setPassword(password);
            if(admins!=null){
                System.out.println("User Registration is successfull");
                admin.add(admins);
                return admins;
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
    public boolean loginAdmin(String email, String password) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Admin admins=null;   
        try {
            for(int i=0;i<admin.size();i++){
               admins=admin.get(i);
               if(admins.getEmail().equals(email)&&admins.getPassword().equals(password)){
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
