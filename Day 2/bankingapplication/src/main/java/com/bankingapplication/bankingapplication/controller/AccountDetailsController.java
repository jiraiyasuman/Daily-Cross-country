/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.controller;

import com.bankingapplication.bankingapplication.entity.AccountDetails;
import com.bankingapplication.bankingapplication.service.AccountDetailService;
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
import java.util.Random;

/**
 *
 * @author SUMAN
 */
@WebServlet("/AccountDetailsController")
public class AccountDetailsController extends HttpServlet{

    private String temp="";
    private String typeOfAccount="",accountHolder="",action="",email="",mobile="",adhaarCardNumber="",balance="",accountNumber="",solId="",ifscCode="";
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
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

    AccountDetails accountDetails = new AccountDetails();
    AccountDetailService accountDetailService = new AccountDetailService();
    boolean status= false;
    Random random = new Random();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter pw = resp.getWriter();
        action=req.getParameter("action");
        switch(action){
            case "add-account":
               accountHolder = req.getParameter("accountHolder");
               email = req.getParameter("email");
               mobile = req.getParameter("mobile");
               adhaarCardNumber = req.getParameter("adhaarCardNumber");
               balance=req.getParameter("balance");
               solId=req.getParameter("solId");
               ifscCode=req.getParameter("ifscCode");
               typeOfAccount=req.getParameter("typeOfAccount");
               if(typeOfAccount.equalsIgnoreCase("Saving Account")){
                   
                   int z = random.nextInt(4);
                   temp=temp+solId+"0150"+Integer.toString(z);
                   accountNumber=temp;
               }else{
                   int z = random.nextInt(4);
                   temp=temp+solId+"0150"+Integer.toString(z);
                   accountNumber=temp;
               }
               accountDetails = new AccountDetails(accountHolder, email, mobile, adhaarCardNumber, Double.parseDouble(balance), accountNumber, solId, ifscCode, true, false);
               status=accountDetailService.addAccountDetails(accountDetails);
               resp.setContentType("text/html");
                
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
            case "delete-account":
                accountNumber=req.getParameter("accountNumber");
                status = accountDetailService.deleteAccountDetails(accountNumber, true);
                resp.setContentType("text/html");
               
               if(status){
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:green;'>Acount deleted successfully</h1>");
                   requestDispatcher.forward(req, resp);
                   
               }else{
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:red;'>Oops error</h1>");
                   requestDispatcher.include(req, resp);
               }
                break;
            case "update-accountHolderName":
                accountNumber=req.getParameter("accountNumber");
                accountHolder= req.getParameter("accountHolder");
                status=accountDetailService.updateAccountDetails(accountNumber, accountHolder);
                if(status){
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:green;'>Acount Updated successfully</h1>");
                   requestDispatcher.forward(req, resp);
                   
               }else{
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:red;'>Oops error</h1>");
                   requestDispatcher.include(req, resp);
               }        
                break;
            case "update-email":
                email=req.getParameter("email");
                accountNumber=req.getParameter("accountNumber");
                status=accountDetailService.updateAccountDetailsEmail(accountNumber, email);
                if(status){
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:green;'>Acount Updated successfully</h1>");
                   requestDispatcher.forward(req, resp);
                   
               }else{
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:red;'>Oops error</h1>");
                   requestDispatcher.include(req, resp);
               }
                break;
            case "update-mobile":
                mobile=req.getParameter("mobile");
                accountNumber=req.getParameter("accountNumber");
                status=accountDetailService.updateAccountDetailsMobile(accountHolder, mobile);
                if(status){
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:green;'>Acount Updated successfully</h1>");
                   requestDispatcher.forward(req, resp);
                   
               }else{
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:red;'>Oops error</h1>");
                   requestDispatcher.include(req, resp);
               }
                
                break;
            case "update-isActive":
                accountNumber = req.getParameter("accountNumber");
                status=accountDetailService.updateAccoutDetailsActive(accountHolder, false);
                if(status){
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:green;'>Acount Updated successfully</h1>");
                   requestDispatcher.forward(req, resp);
                   
               }else{
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                   pw.println("<h1 style='color:red;'>Oops error</h1>");
                   requestDispatcher.include(req, resp);
               }
                break;
                default:
                    System.err.println("Wrong choice");
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
