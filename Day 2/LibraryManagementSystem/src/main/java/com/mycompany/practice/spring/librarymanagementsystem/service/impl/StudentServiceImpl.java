/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.service.impl;

import com.mycompany.practice.spring.librarymanagementsystem.entity.Student;
import com.mycompany.practice.spring.librarymanagementsystem.exception.ErrorException;
import com.mycompany.practice.spring.librarymanagementsystem.exception.StudentNotException;
import com.mycompany.practice.spring.librarymanagementsystem.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author SUMAN
 */
public class StudentServiceImpl implements StudentService{

    List<Student> listOfStudents = new ArrayList<>();
    @Override
    public Student addStudnet(String firstName, String lastName, String email, String course) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Student student = new Student();
        try {
            Random random =new Random();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setCourse(course);
            student.setEmail(email);
            int id = random.nextInt(10000);
            student.setStudentId(id);
            listOfStudents.add(student);
            if(student!=null){
                System.out.println("Student details have been successfully added");
                return student;
            }else{
                throw new ErrorException("Student Details could not be added");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }

    @Override
    public List<Student> getAllLists() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return listOfStudents;
    }

    @Override
    public Student getByStudent(int id) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Student student = new Student();
        try {
            for(int i=0;i<listOfStudents.size();i++){
        student = listOfStudents.get(i);
        if(student.getStudentId()==id){
            System.out.println("Student details are found");
            return student;
        }else{
            throw new StudentNotException("Student details are not found.");
        }
    }
        } catch (Exception e) {
     e.printStackTrace();
        }
    return null;
    }

    @Override
    public Student updateStudent(int id, Student student) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Student students = new Student();
        try {
            for(int i=0;i<listOfStudents.size();i++){
        students = listOfStudents.get(i);
        if(students.getStudentId()==id){
            System.out.println("Student details are found");
            students.setStudentId(id);
            students.setFirstName(student.getFirstName());
            students.setLastName(student.getLastName());
            students.setEmail(student.getEmail());
            students.setCourse(student.getCourse());
            listOfStudents.set(id, students);
            System.out.println("Students records are updated successfully");
            return students;
        }else{
            throw new StudentNotException("Student details are not found.");
        }
    }
        } catch (Exception e) {
     e.printStackTrace();
        }
    return null;
    }

    @Override
    public void deleteStudent(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Student student = new Student();
        try {
            for(int i=0;i<listOfStudents.size();i++){
        student = listOfStudents.get(i);
        if(student.getStudentId()==id){
            System.out.println("Student details are found");
            listOfStudents.remove(i);
            System.out.println("Students details are removed successfully");
        }else{
            throw new StudentNotException("Student details are not found.");
        }
    }
        } catch (Exception e) {
     e.printStackTrace();
        }
    }
    
}
