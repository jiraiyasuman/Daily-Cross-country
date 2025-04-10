/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.serviceimpl;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.AdminLogin;
import com.mycompany.practice.spring.movieticketbookingsystem.repository.AdminLoginRepository;
import com.mycompany.practice.spring.movieticketbookingsystem.service.AdminLoginService;
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
public class AdminLoginServiceImpl implements AdminLoginService {

    private AdminLoginRepository adminLoginRepository= new AdminLoginRepository();
    private Logger LOGGER = Logger.getLogger(getClass().getName());
    @Override
    public boolean registerUser(AdminLogin userLogin) {
        boolean status=false;
        try{
            boolean temp = adminLoginRepository.registerAdmin(userLogin);
            if(temp==true){
                System.out.println("Admin Register is successful");
                LOGGER.info("AdminLoginService register is being executed");
                status =true;
                return status;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean loginUser(String email, String password) {
        boolean status =false;
        try {
            boolean temp = adminLoginRepository.loginAdmin(email, password);
            if (temp==true) {
                System.out.println("Admin login is successful");
                LOGGER.info("AdminLoginService login is being executed");
                status =true;
                return status;
            }else{
                System.out.println("Admin Login is unsuccessful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updatePassword(String email, String password) {
    boolean status =false;
        try {
            boolean temp = adminLoginRepository.updatePassword(email, password);
            if (temp==true) {
                System.out.println("Password has been successfully updated");
            LOGGER.info("AdminLoginService login is being executed");
                status =true;
                return status;
            }else{
               return status; 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
}
