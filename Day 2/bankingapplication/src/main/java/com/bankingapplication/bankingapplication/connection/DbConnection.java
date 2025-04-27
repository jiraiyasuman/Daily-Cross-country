/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.connection;

/**
 *
 * @author SUMAN
 */
import java.sql.*;
import java.util.logging.Logger;
public class DbConnection {

    private static final Logger LOG = Logger.getLogger(DbConnection.class.getName());
    
    
    public static void main(String[] args)throws Exception {
        DbConnection dbConnection = new DbConnection();
        dbConnection.getConnection();
    }

    public static Connection getConnection() throws Exception{
        Connection conn=null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking?useSSL=false","root","12345");
         if(conn!=null){
            LOG.info("Connection is successfull");
            return conn;
         }else{
             LOG.info("Oops! Some error has occured");
             return conn;
         }
        } catch (Exception e) {
            System.err.println(e);
        }
        return conn;
    }
}
