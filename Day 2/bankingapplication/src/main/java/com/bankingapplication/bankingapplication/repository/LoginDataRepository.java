/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.repository;

import com.bankingapplication.bankingapplication.entity.LoginData;

/**
 *
 * @author SUMAN
 */
public interface LoginDataRepository {
    
    
    public boolean registerUser(LoginData loginData);
    
    public LoginData verifyLoginUser(String email,String password);
    
    public LoginData verifyOtp(String email,String otp);
    
    public boolean updatePassword(String email,String password);
    
    public boolean updateProfile(LoginData loginData);
}
