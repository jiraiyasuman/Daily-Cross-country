/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.repository;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.AdminLogin;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
public class AdminLoginRepository {
 
    private ArrayList<AdminLogin> loginAdmin = new ArrayList<>();
    private Logger LOGGER = Logger.getLogger(getClass().getName());
    public boolean registerAdmin(AdminLogin userLogin){
        boolean status= false;
        try {
            loginAdmin.add(userLogin);
            LOGGER.info("AdminLoginService register is being executed");
            status =true;
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public boolean loginAdmin(String email,String password){
        boolean status = false;
        try {
        AdminLogin adminLogin =new AdminLogin();
        for(int i =0; i< loginAdmin.size();i++){
            adminLogin = loginAdmin.get(i);
            if(email.equals(adminLogin.getEmail())&&password.equals(adminLogin.getPassword())){
                System.out.println("Login Successful");
                LOGGER.info("LoginAdmin login is being executed");
                status =true;
                return status;
            }else{
                System.out.println("Login unsuccessful");
                status =false;
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
            AdminLogin adminLogin =new AdminLogin();
            for(int i=0; i<loginAdmin.size();i++){
                adminLogin =loginAdmin.get(i);
                if(email.equals(adminLogin.getEmail())&&password.equals(adminLogin.getPassword())){
                    adminLogin.setPassword(password);
                    System.out.println("The new values are ====>"+adminLogin.toString());
                    loginAdmin.set(i, adminLogin);
                    LOGGER.info("AdminLoginServiceImpl update password is being updated successfully");
                    System.out.println("Password updation is successfull");
                    status =true;
                    return status;
                }else{
                    System.out.println("Email id and password is not found");
                    return status;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
