/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.service;

import com.mycompany.practice.spring.librarymanagementsystem.entity.Admin;

/**
 *
 * @author SUMAN
 */
public interface AdminService {
    
    Admin registerAdmin(String userName,String email,String password);
    boolean loginAdmin(String email,String password);
}
