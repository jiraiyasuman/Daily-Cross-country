/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.controller;

import com.bankingapplication.bankingapplication.entity.LoginData;
import com.bankingapplication.bankingapplication.repository.LoginDataRepository;
import com.bankingapplication.bankingapplication.securityconfig.PasswordHashing;
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
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
@WebServlet("/loginDataController")
public class LoginDataController extends HttpServlet{

    private static final Logger LOG = Logger.getLogger(LoginDataController.class.getName());
    LoginData loginData = new LoginData();
    private LoginDataRepository loginDataRepository;
    String email ="", password="",role="",userName="",otp="",value="",passwordHashin="";
    boolean status=false;
    RequestDispatcher requestDispatcher;
    
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PasswordHashing passwordHashing = new PasswordHashing();
        value=req.getParameter("action");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        switch (value) {
            case "register":
                
                userName=req.getParameter("userName");
                email = req.getParameter("email");
                password = req.getParameter("password");
                role=req.getParameter("role");
                passwordHashin = passwordHashing.passwordHashing(password);
                
                loginData= new LoginData(email, password, role, userName);
                status=loginDataRepository.registerUser(loginData);
                if(status){
                    session.setAttribute("Success", "Registration is done successfully");
                    LOG.info("Login Controller register module is being successfully");
                    resp.sendRedirect("views/register.jsp");
                }else{
                    LOG.info("Oops some error has happened");
                    pw.println("<h1 style=`color:red;`>Some error has occurred</h1>");
                    resp.sendRedirect("views/register.jsp");
                }
                break;
            case "login":
                email = req.getParameter("email");
                password = req.getParameter("password");
                passwordHashin = passwordHashing.passwordHashing(password);
                loginData = loginDataRepository.verifyLoginUser(email, passwordHashin);
                if(loginData!=null){
                    session.setAttribute("User", loginData);
                    LOG.info("Login Controller login module is being executed");
                     requestDispatcher= req.getRequestDispatcher("views/otp.jsp");
                    requestDispatcher.forward(req, resp);
                }else{
                    LOG.info("Oops some error has happened");
                    pw.println("<h1 style=`color:red;`>Invalid credentials</h1>");
                    requestDispatcher = req.getRequestDispatcher("views/login.jsp");
                    requestDispatcher.include(req, resp);
                }
                break;
            case "verify otp":
                email =req.getParameter("email");
                otp = req.getParameter("otp");
                loginData = loginDataRepository.verifyOtp(email, otp);
                if(loginData!=null){
                    session.setAttribute("User", loginData);
                    LOG.info("Login Controller verify otp has been successfully executed");
                    requestDispatcher=req.getRequestDispatcher("views/home.jsp");
                    requestDispatcher.forward(req, resp);
                }else{
                    LOG.info("Oops some error has happened");
                    pw.println("<h1 style=`color:red;`>Otp validation has failed</h1>");
                    requestDispatcher= req.getRequestDispatcher("views/login.jsp");
                    requestDispatcher.include(req, resp);
                }
                break;
            case "update password":
                 email=req.getParameter("email");
                 password=req.getParameter("password");
                 passwordHashin = passwordHashing.passwordHashing(password);
                 status = loginDataRepository.updatePassword(email, password);
                 if(status){
                     LOG.info("Login Controller update password has been executed");
                     session.setAttribute("Success", "Password updated successfully");
                     resp.sendRedirect("views/updatePassword.jsp");
                 }else{
                     LOG.info("Oops some error has happened");
                     pw.println("<h1 style=`color:red;`>Password updation has failed</h1>");
                     resp.sendRedirect("views/updatePassword.jsp");
                 }
                         
                break;
            case "update profile":
                email=req.getParameter("email");
                userName = req.getParameter("userName");
                loginData=new LoginData(email, "", "", userName);
                status= loginDataRepository.updateProfile(loginData);
                if(status){
                    LOG.info("Update profile has been executed successfully");
                    session.setAttribute("Success", "Update profile is successfully done");
                    resp.sendRedirect("views/updateProfile.jsp");
                }else{
                    LOG.info("Oops some error has happened");
                    pw.println("<h1 style=`color:red;`>Profile updation has failed</h1>");
                    resp.sendRedirect("views/updateProfile.jsp");
                }
                break;
            default: 
                System.out.println("Wrong choice");
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
