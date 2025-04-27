/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.service;

import com.bankingapplication.bankingapplication.connection.DbConnection;
import com.bankingapplication.bankingapplication.emails.Emails;
import com.bankingapplication.bankingapplication.entity.LoginData;
import com.bankingapplication.bankingapplication.repository.LoginDataRepository;

/**
 *
 * @author SUMAN
 */
import java.sql.*;
import java.util.Random;
import java.util.logging.Logger;
public class LoginDataService implements LoginDataRepository{
boolean status = false;
    DbConnection dbConnection = new DbConnection();
    int z=0;
    Connection conn;
    private static final Logger LOG = Logger.getLogger(LoginDataService.class.getName());
    LoginData loginData = new LoginData();
    private final String INSERT_SQL="INSERT INTO `banking`.`login_data` (`id`, `email`, `name`, `password`, `role`) VALUES ('?', '?', '?', '?', '?');";
    
    private final String CHECK_SQL="SELECT * FROM `banking`.`login_data` WHERE EMAIL=? AND PASSWORD=?;";
    private final String UPDATE_OTP="UPDATE `banking`.`login_data` SET `otp` = ? WHERE (`id` = '?');";
    private final String VERIFY_OTP="SELECT * FROM `banking`.`login_data` WHERE EMAIL=? AND OTP=?;";
    private final String UPDATE_PASSWORD = "UPDATE `banking`.`login_data` SET `password` = ? WHERE (`email` = '?');";
    private final String UPDATE_PROFILE="UPDATE `banking`.`login_data` SET `username` = ? WHERE (`email` = '?');";

    public LoginDataService() throws Exception {
        this.conn = DbConnection.getConnection();
    }
    @Override
    public boolean registerUser(LoginData loginData) {
        try {
            
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
            ps.setInt(1, loginData.getId());
            ps.setString(2, loginData.getEmail());
            ps.setString(3,loginData.getUserName());
            ps.setString(4, loginData.getPassword());
            ps.setString(5,loginData.getRole());
            ps.setString(6, loginData.getOtp());
            z=ps.executeUpdate();
            if(z>0){
                status=true;
                LOG.info("Login Details successfully inserted");
                return status;
            }else{
                LOG.info("Login Details not successfully inserted");
                return status;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return status;
    }

    @Override
    public LoginData verifyLoginUser(String email, String password) {
     
        try {
            conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(CHECK_SQL);
            ps.setString(1, email);
            ps.setString(z, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                {                
                loginData = new LoginData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
            if(loginData!=null){
                Random random = new Random();
                int otp = random.nextInt(1000000);
                String message="Dear "+loginData.getUserName()+"/n"+"Your otp for verification is "+otp+" This otp is valid upto 10 minutes /n"+"Regrds /n ABC BANK";
                Emails emails = new Emails();
                emails.sendEmail(message, "OTP Verification", email,"suman.talukdar53@gmail.com");
                boolean temp=updateOtp(email,otp);
                if(temp)
                    LOG.info("Otp has been updated successfully and email has been sent");
                LOG.info("Login details sucessfully verified");
                return loginData;
            }else{
                LOG.info("Invalid Login Credentials");
                return loginData;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return loginData;
    }

    @Override
    public LoginData verifyOtp(String email, String otp) {
        try {
             conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(VERIFY_OTP);
            ps.setString(1, email);
            ps.setString(2, otp);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                loginData = new LoginData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                
            }
            if(loginData!=null){
                LOG.info("Verify Otp code is executed");
                return loginData;
            }else{
                LOG.info("Verification Otp is not executed due to invalid credentials");
                return loginData;
            }
        } catch (Exception e) {
        }
  
        return loginData;
    }

    @Override
    public boolean updatePassword(String email, String password) {
        try {
             conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_PASSWORD);
            ps.setString(1, password);
            ps.setString(2, email);
            z= ps.executeUpdate();
            if(z>0){
                LOG.info("Password updation successfully executed");
                status = true;
                return status;
            }else{
                LOG.info("Password updation is not executed successfully");
                return status;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        
        return status;
    }

    @Override
    public boolean updateProfile(LoginData loginData) {
         try {
            
            conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_PROFILE);
            ps.setString(1, loginData.getUserName());
            ps.setString(2, loginData.getEmail());
            z = ps.executeUpdate();
            if(z==1){
                LOG.info("Update profile is executed successfully");
                status= true;
                return status;
            }else{
                LOG.info("Updation profile is not executed due to some errors");
                status =false;
                return status;
            }
        } catch (Exception e) {
             System.err.println(e);
        }
        
        return status;
    }

    private boolean updateOtp(String email, int otp) {
      status = false;
        try {
            conn = dbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_OTP);
            
            ps.setString(1, String.valueOf(otp));
            ps.setString(2, email);
            z= ps.executeUpdate();
            if(z==1){
                status=true;
                LOG.info("Update otp has been executed");
                return status;
            }else{
                status =false;
                LOG.info("Update otp has not been executed due to some error");
                return status;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
      return status;
    }
    
}
