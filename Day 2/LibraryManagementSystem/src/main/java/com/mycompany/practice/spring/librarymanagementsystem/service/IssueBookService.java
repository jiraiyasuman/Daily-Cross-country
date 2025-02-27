/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.service;

import com.mycompany.practice.spring.librarymanagementsystem.entity.IssueBooks;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author SUMAN TALUKDAR
 */
public interface IssueBookService {
    IssueBooks addIssueBook(String bookName, String bookAuthor, LocalDate issueDate, int quantity, boolean statusBooks, int studentId, int bookId);
    List<IssueBooks> getAllList();
    List<IssueBooks> getDetailsById(int issueId);
}
