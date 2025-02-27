/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.service.impl;

import com.mycompany.practice.spring.librarymanagementsystem.entity.BillingFine;
import com.mycompany.practice.spring.librarymanagementsystem.service.BillingFineService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
public class BillingFineServiceImpl implements BillingFineService{

    private static final Logger LOG = Logger.getLogger(BillingFineServiceImpl.class.getName());

    
    List<BillingFine> billingForm = new ArrayList<>();
    @Override
    public BillingFine addBill(String studentName, int studentId, int bookId, String bookName, String bookAuthor, LocalDate issueDate, LocalDate returnDate, double fine, int days) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       BillingFine billingFine = new BillingFine(); 
       try {
            Random random = new Random();
            int billId = random.nextInt(10000);
            billingFine.setFineId(billId);
            billingFine.setBookAuthor(bookAuthor);
            billingFine.setBookId(bookId);
            billingFine.setBookName(bookName);
            billingFine.setDays(days);
            billingFine.setReturnDate(returnDate);
            billingFine.setStudentId(studentId);
            billingFine.setStudentName(studentName);
            billingFine.setFine(fine);
            billingForm.add(billingFine);
            System.out.println("Billing details are added succesfully");
            return billingFine;
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public List<BillingFine> getAllList() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return billingForm;
    }
    
}
