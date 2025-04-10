/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.entity;

/**
 *
 * @author SUMAN
 */
public class AdminLogin {
    
    private String userName;
    private String password;
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AdminLogin(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public AdminLogin() {
    }

    @Override
    public String toString() {
        return "AdminLogin{" + "userName=" + userName + ", password=" + password + ", email=" + email + '}';
    }
    
}
