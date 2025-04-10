/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.serviceimpl;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.UserLogin;
import com.mycompany.practice.spring.movieticketbookingsystem.repository.UserLoginRepository;
import com.mycompany.practice.spring.movieticketbookingsystem.service.LoginUserService;
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
public class UserLoginServiceImpl implements LoginUserService{

    private UserLoginRepository userLoginRepository;
    private Logger LOGGER = Logger.getLogger(getClass().getName());
    @Override
    public boolean registerUser(UserLogin userLogin) {
    boolean status = false;
        try {
            boolean temp = userLoginRepository.registerUser(userLogin);
            if(temp==true){
                System.out.println("Admin Register is successful");
                LOGGER.info("UserLoginService register is being executed");
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

    @Override
    public boolean loginUser(String email, String password) {
     boolean status = false;
        try {
            boolean temp = userLoginRepository.loginUser(email, password);
            if (temp==true) {
                LOGGER.info("UserLoginService login is being executed");
            status = true;
            return status;
            }else{
                return status;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updatePassword(String email, String password) {
    boolean status = false;
        try {
            boolean temp = userLoginRepository.updatePassword(email, password);
            if(temp==true){
                LOGGER.info("UserLoginService login is being executed");
            status = true;
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
