/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.service;
import com.mycompany.practice.spring.librarymanagementsystem.entity.*;
/**
 *
 * @author SUMAN
 */
public interface UserService {
    
    User registerUser(String userName,String email, String password);
    boolean loginUser(String email,String password);
    
}
