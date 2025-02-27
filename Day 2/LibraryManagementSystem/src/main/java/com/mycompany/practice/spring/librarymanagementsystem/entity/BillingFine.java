/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.entity;

import java.time.LocalDate;
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
public class BillingFine {
    
    private int fineId;
    private String studentName;
    private int studentId;
    private int issueId;
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private double fine;
    private int days;

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public BillingFine(int fineId, String studentName, int studentId, int issueId, int bookId, String bookName, String bookAuthor, LocalDate issueDate, LocalDate returnDate, double fine, int days) {
        this.fineId = fineId;
        this.studentName = studentName;
        this.studentId = studentId;
        this.issueId = issueId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.fine = fine;
        this.days = days;
    }
    private static final Logger LOG = Logger.getLogger(BillingFine.class.getName());

   

    public BillingFine() {
    }

    @Override
    public String toString() {
        return "BillingFine{" + "fineId=" + fineId + ", studentName=" + studentName + ", studentId=" + studentId + ", bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", fine=" + fine + ", days=" + days + '}';
    }
    

    

    
    public void setFineId(int fineId) {
        this.fineId = fineId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    
    public int getFineId() {
        return fineId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public double getFine() {
        return fine;
    }
    
}
