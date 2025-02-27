/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.entity;

/**
 *
 * @author SUMAN
 */
public class User {

private int studentId;
private String userName;
private String email;
private String password;

    @Override
    public String toString() {
        return "Students{" + "id=" + studentId + ", userName=" + userName + ", email=" + email + ", password=" + password + '}';
    }

    public User() {
    }

    public User(int studentId, String userName, String email, String password) {
        this.studentId = studentId;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public void setId(int studentId) {
        this.studentId = studentId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return studentId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}

