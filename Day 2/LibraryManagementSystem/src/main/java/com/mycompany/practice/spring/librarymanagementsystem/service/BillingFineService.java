/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.service;

import com.mycompany.practice.spring.librarymanagementsystem.entity.BillingFine;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author SUMAN
 */
public interface BillingFineService {
    
    BillingFine addBill(String studentName, int studentId, int bookId, String bookName, String bookAuthor, LocalDate issueDate, LocalDate returnDate, double fine, int days);
    List<BillingFine> getAllList();
}
