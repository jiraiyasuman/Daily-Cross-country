/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.entity;

/**
 *
 * @author SUMAN
 */
public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String course;

    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Student() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", course=" + course + '}';
    }

    public Student(int studentId, String firstName, String lastName, String email, String course) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.course = course;
    }
    
}
