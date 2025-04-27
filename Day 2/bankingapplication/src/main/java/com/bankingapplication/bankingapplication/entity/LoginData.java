/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

/**
 *
 * @author SUMAN TALUKDAR
 */
@Entity(name="login_data")
public class LoginData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private int id;
    @Column(name="email",unique = true)
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Min(8)@Max(15)
    @Column(name="password", nullable = false)
    private String password;
    @NotEmpty
    @Column(name="role",nullable = false)
    private String role;
    @NotEmpty
    @Column(name="user_name",nullable = false)
    private String userName;
    @Column(name = "otp",nullable = true)
    private String otp;
    

    public LoginData(String email, String password, String role, String userName,String otp) {
        
        this.email = email;
        this.password = password;
        this.role = role;
        this.userName = userName;
        this.otp=otp;
    }

    public LoginData(String email, String password, String role, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LoginData(int id, String email, String password, String role, String userName, String otp) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.userName = userName;
        this.otp = otp;
    }

    
    
    public LoginData() {
    }

    @Override
    public String toString() {
        return "LoginData{" + "id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + ", userName=" + userName + ", otp=" + otp + '}';
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
