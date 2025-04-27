/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.controller;

import com.bankingapplication.bankingapplication.entity.AccountTransaction;
import com.bankingapplication.bankingapplication.service.AccountTransactionService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SUMAN
 */
@WebServlet("/AccountTransactionController")
public class AccountTransactionController extends HttpServlet{

    private AccountTransaction accountTransaction= new AccountTransaction();
    private AccountTransactionService accountTransactionService = new AccountTransactionService();
    boolean status=false;
    List<AccountTransaction> list = new ArrayList<>();
    String fromAccountNumber="",typeOfTransaction="",actions="",toAccountNumber="",balance="",creditAmount="",debitBalance="",transactionDate="";
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doTrace(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    private static final int RECORDS_PER_PAGE = 20;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
         HttpSession session = req.getSession();
         PrintWriter pw = resp.getWriter();
         resp.setContentType("text/html");
         actions=req.getParameter("actions");
         switch(actions){
             case "fund-transfer":
                 fromAccountNumber=req.getParameter("fromAccountNumber");
                 toAccountNumber=req.getParameter("toAccountNumber");
                 balance=req.getParameter("balance");
                 creditAmount="-";
                 debitBalance="-";
                 transactionDate=req.getParameter("transactionalDate");
                 typeOfTransaction = "FUND_TRANSFER";
                 accountTransaction=new AccountTransaction(fromAccountNumber, toAccountNumber, Double.parseDouble(balance), 0.0d, 0.0d, transactionDate, typeOfTransaction);
                 status = accountTransactionService.fundTransferTransaction(fromAccountNumber, toAccountNumber,Double.parseDouble(balance), transactionDate);
                 if(status){
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:green;'>Acount added successfully</h1>");
                   requestDispatcher.forward(req, resp);
                   
               }else{
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:red;'>Oops added successfuly</h1>");
                   requestDispatcher.include(req, resp);
               }
                 
                 break;
             case "cash-deposit":
                 fromAccountNumber=req.getParameter("fromAccountNumber");
                 balance=req.getParameter("balance");
                 transactionDate=req.getParameter("transactionDate");
                 status= accountTransactionService.cashDeposit(fromAccountNumber, Double.parseDouble(balance),transactionDate );
                 if(status){
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:green;'>Acount added successfully</h1>");
                   requestDispatcher.forward(req, resp);
                   
               }else{
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:red;'>Oops added successfuly</h1>");
                   requestDispatcher.include(req, resp);
               }
             break;
             case "cash-withdrawal":
                 fromAccountNumber=req.getParameter("fromAccountNumber");
                 balance=req.getParameter("balance");
                 transactionDate=req.getParameter("transactionDate");
                 status= accountTransactionService.cashWithDrawal(fromAccountNumber, Double.parseDouble(balance),transactionDate );
                 if(status){
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:green;'>Acount added successfully</h1>");
                   requestDispatcher.forward(req, resp);
                   
               }else{
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:red;'>Oops added successfuly</h1>");
                   requestDispatcher.include(req, resp);
               }
                 break;
             case "display-transactions":
                 String fromDate="",toDate="";
                 fromAccountNumber =req.getParameter("fromAccountNumber");
                 fromDate=req.getParameter("fromDate");
                 toDate=req.getParameter("toDate");
                 int page=1;
                 if(req.getParameter("page")!=null){
                     page=Integer.parseInt(req.getParameter("page"));
                 }
                 list = accountTransactionService.displayAllStatements(toAccountNumber, fromDate, toDate, (page - 1) * RECORDS_PER_PAGE, RECORDS_PER_PAGE);
                 int totalRecords = accountTransactionService.getTotalRecords();
                 int totalPages = (int) Math.ceil(totalRecords * 1.0 / RECORDS_PER_PAGE);
                 req.setAttribute("Transaction-List", list);
        req.setAttribute("currentPage", page);
        req.setAttribute("totalPages", totalPages);

        RequestDispatcher dispatcher = req.getRequestDispatcher("views/home.jsp");
        dispatcher.forward(req, resp);
                 break;
         }
         
        
        
        
        
        
        
        
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        return super.getLastModified(req); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
