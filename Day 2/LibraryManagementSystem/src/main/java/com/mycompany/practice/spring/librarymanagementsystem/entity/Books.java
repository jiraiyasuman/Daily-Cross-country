/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.entity;

/**
 *
 * @author SUMAN
 */
public class Books {
private int bookId;
private String bookName;
private String bookAuthor;
private String bookPublisher;
private String bookDescription;
private double bookPrice;
private int bookQuantity;

    @Override
    public String toString() {
        return "Books{" + "id=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPublisher=" + bookPublisher + ", bookDescription=" + bookDescription + ", bookPrice=" + bookPrice + ", bookQuantity=" + bookQuantity + '}';
    }

    public Books() {
    }

    public Books(int bookId, String bookName, String bookAuthor, String bookPublisher, String bookDescription, double bookPrice, int bookQuantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookDescription = bookDescription;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
    }

   

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public int getId() {
        return bookId;
    }

    public void setId(int bookId) {
        this.bookId = bookId;
    }

    

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

}
