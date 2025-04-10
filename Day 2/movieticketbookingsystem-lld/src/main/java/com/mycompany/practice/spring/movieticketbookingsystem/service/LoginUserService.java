/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.service;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.UserLogin;

/**
 *
 * @author SUMAN
 */
public interface LoginUserService {
    
    public boolean registerUser(UserLogin userLogin);
    public boolean loginUser(String email,String password);
    public boolean updatePassword(String email,String password);
}
