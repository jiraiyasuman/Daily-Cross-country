 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.entity;
import java.time.LocalDate;
import java.util.*;
/**
 *
 * @author SUMAN
 */
public class IssueBooks {
    private int id;
    private String bookName;
    private String bookAuthor;
    private LocalDate issueDate;
    private int quantity;
    private boolean statusBooks;
    private int studentId;
    private int bookId;
    
    public int getStudentId() {
        return studentId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public IssueBooks() {
    }

    @Override
    public String toString() {
        return "IssueBooks{" + "id=" + id + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", issueDate=" + issueDate + ", quantity=" + quantity + ", statusBooks=" + statusBooks + ", studentId=" + studentId + ", bookId=" + bookId + '}';
    }

    public IssueBooks(int id, String bookName, String bookAuthor, LocalDate issueDate, int quantity, boolean statusBooks, int studentId, int bookId) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.issueDate = issueDate;
        this.quantity = quantity;
        this.statusBooks = statusBooks;
        this.studentId = studentId;
        this.bookId = bookId;
    } 
    public boolean isStatusBooks() {
        return statusBooks;
    }

    public void setStatusBooks(boolean statusBooks) {
        this.statusBooks = statusBooks;
    }

    
    
    public int getId() {
        return id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
