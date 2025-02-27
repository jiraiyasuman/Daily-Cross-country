/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.service.impl;

import com.mycompany.practice.spring.librarymanagementsystem.entity.IssueBooks;
import com.mycompany.practice.spring.librarymanagementsystem.exception.BookNotFoundException;
import com.mycompany.practice.spring.librarymanagementsystem.exception.ErrorException;
import com.mycompany.practice.spring.librarymanagementsystem.service.IssueBookService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author SUMAN
 */
public class IssueBookServiceImpl implements IssueBookService{

    List<IssueBooks> issueBooks= new ArrayList<>();
    @Override
    public IssueBooks addIssueBook(String bookName, String bookAuthor, LocalDate issueDate, int quantity, boolean statusBooks, int studentId, int bookId) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            IssueBooks iBooks = new IssueBooks();
        Random random = new Random();
        int issueId = random.nextInt(10000);
        iBooks.setBookId(bookId);
        iBooks.setBookName(bookName);
        iBooks.setBookAuthor(bookAuthor);
        iBooks.setIssueDate(issueDate);
        iBooks.setQuantity(quantity);
        iBooks.setStatusBooks(statusBooks);
        iBooks.setStudentId(studentId);
        iBooks.setId(issueId);
        if(iBooks != null){
            issueBooks.add(iBooks);
            System.out.println("Issue Books is added successfully");
        }else{
            throw new ErrorException("There is some exception in adding IssueBooks");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<IssueBooks> getAllList() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return issueBooks;
    }

    @Override
    public List<IssueBooks> getDetailsById(int issueId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    List<IssueBooks> books = new ArrayList<>();
    IssueBooks iBook = new IssueBooks();
        try {
            for(int i=0;i<issueBooks.size();i++){
                iBook = issueBooks.get(i);
                if(iBook.getId()== issueId){
                     books.add(iBook);
                     System.out.println("Book details found");
                }else{
                    throw new BookNotFoundException("Book is not found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return books;
    } 
}
