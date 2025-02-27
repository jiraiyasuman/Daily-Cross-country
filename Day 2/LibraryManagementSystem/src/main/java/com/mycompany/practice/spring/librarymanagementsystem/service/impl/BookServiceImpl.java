/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.service.impl;

import com.mycompany.practice.spring.librarymanagementsystem.entity.Books;
import com.mycompany.practice.spring.librarymanagementsystem.exception.*;
import com.mycompany.practice.spring.librarymanagementsystem.service.BookService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author SUMAN
 */
public class BookServiceImpl implements BookService{
    List<Books> books = new ArrayList<>();
    @Override
    public Books addBook(String bookName, String bookAuthor, String bookPublisher, String bookDescription, double bookPrice, int bookQuantity) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            Books book = new Books();
    Random rand = new Random();
    int bookId=rand.nextInt(10000);
    book.setBookName(bookName);
    book.setBookDescription(bookDescription);
    book.setBookAuthor(bookAuthor);
    book.setBookPrice(bookPrice);
    book.setBookQuantity(bookQuantity);
    book.setId(bookId);
    book.setBookPublisher(bookPublisher);
    if(book!=null){
        System.out.println("Book is added successfully");
        books.add(book);
        return book;
    }else{
        throw new ErrorException("Some error occured. Book could not be added");
    }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }

    @Override
    public List<Books> getAllBooks() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return books;
    }

    @Override
    public Books getBookById(int bookId) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Books book =new Books();
        try {
            for (int i=0;i<books.size();i++){
        book = books.get(i);
        if(book.getId()==bookId){
            System.out.println("Book is found");
            return book;
        }else{
            throw new BookNotFoundException("Book is not found");
        }
      }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Books updateBooksByQuantity(int id,int quantity) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Books book =new Books();
        try {
            for (int i=0;i<books.size();i++){
        book = books.get(i);
        if(book.getId()==id){
            System.out.println("Book is found");
            book.setBookQuantity(quantity);
            System.out.println("Book details are successfully updated");
            return book;
        }else{
            throw new BookNotFoundException("Book is not found");
        }
      }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    
    }

    @Override
    public Books updateBooksByPrice(int id,double bookPrice) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Books book =new Books();
        try {
            for (int i=0;i<books.size();i++){
        book = books.get(i);
        if(book.getId()==id){
            System.out.println("Book is found");
            book.setBookPrice(bookPrice);
            System.out.println("Book details are successfully updated");
            return book;
        }else{
            throw new BookNotFoundException("Book is not found");
        }
      }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteBooksById(int bookId) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Books book =new Books();
        try {
            for (int i=0;i<books.size();i++){
        book = books.get(i);
        if(book.getId()==bookId){
            System.out.println("Book is found");
            books.remove(i);
            System.out.println("Book with id "+bookId+" is deleted successfully. ");
        }else{
            throw new BookNotFoundException("Book is not found");
        }
      }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getQuantity(int bookId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Books book =new Books();
        try {
           for(int i=0;i<books.size();i++){
               book = books.get(i);
               if(book.getId()==bookId){
                   System.out.println("Book is found");
                   return book.getBookQuantity();
               }else{
                    throw new BookNotFoundException("Book is not found");
               }
           } 
        } catch (Exception e) {
        }
        return 0;
    }
    
}
