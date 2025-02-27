/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.service;
import com.mycompany.practice.spring.librarymanagementsystem.entity.*;
import java.util.List;
/**
 *
 * @author SUMAN
 */
public interface StudentService {
    Student addStudnet(String firstName, String lastName, String email, String course);
    List<Student> getAllLists();
    Student getByStudent(int id);
    Student updateStudent(int id,Student student);
    void deleteStudent(int id);
}
