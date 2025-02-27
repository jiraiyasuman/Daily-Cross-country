/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.service;

import com.mycompany.practice.spring.librarymanagementsystem.entity.Books;
import java.awt.print.Book;
import java.util.List;

/**
 *
 * @author SUMAN
 */
public interface BookService {
    
    Books addBook(String bookName,String bookAuthor,String bookPublisher,String bookDescription,double bookPrice,int bookQuantity);
    List<Books> getAllBooks();
    Books getBookById(int bookId );
    Books updateBooksByQuantity(int id,int quantity);
    Books updateBooksByPrice(int id,double bookPrice);
    void deleteBooksById(int bookId);
    int getQuantity(int bookId);
}
