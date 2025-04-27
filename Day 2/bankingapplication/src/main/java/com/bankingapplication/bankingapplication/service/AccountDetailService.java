/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.service;

import com.bankingapplication.bankingapplication.connection.DbConnection;
import com.bankingapplication.bankingapplication.entity.AccountDetails;
import com.bankingapplication.bankingapplication.repository.AccountDetailsRepository;
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AccountDetailService implements AccountDetailsRepository{

    private static final Logger LOG = Logger.getLogger(AccountDetailService.class.getName());

    public AccountDetailService() {
    }
 
    
    private static final String ADD_ACCOUNT_DETAILS="INSERT INTO `banking`.`account_details`(`id`, `account_holder`, `email`, `mobile`,`adhaar_card_number`,`balance`,`account_number`, `sol_id`,`ifsc_code`,`is_active`,`is_closed`) VALUES ('?', '?', '?', '?', '?','?','?','?','?','?');";;
    private static final String UPDATE_ACCOUNT_HOLDER_NAME="UPDATE `banking`.`account_details` SET ACCOUNT_HOLDER WHERE ACCOUNT_NUMBER=?;";
    private static final String DELETE_ACCOUNT_DETAILS="UPDATE `banking`.`account_details` SET IS_CLOSED WHERE ACCOUNT_NUMBER=?;";
    private static final String UPDATE_ACCOUNT_EMAIL="UPDATE `banking`.`account_details` SET EMAIL WHERE ACCOUNT_NUMBER=?;";
    private static final String UPDATE_ACCOUNT_MOBILE="UPDATE `banking`.`account_details` SET MOBILE WHERE ACCOUNT_NUMBER=?;";
    private static final String UPDATE_ACCOUNT_IS_ACTIVE="UPDATE `banking`.`account_details` SET IS_ACTIVE WHERE ACCOUNT_NUMBER=?;";
    private static final String UPDATE_ACCOUNT_IS_CLOSED="UPDATE `banking`.`account_details` SET ACCOUNT_HOLDER WHERE ACCOUNT_NUMBER=?;";
    private static final String UPDATE_ACCOUNT_BASE_BRANCH="UPDATE `banking`.`account_details` SET SOL_ID,IFSC_CODE WHERE ACCOUNT_NUMBER=?;";
    private Connection conn;

    private boolean status=false;
    
    private List<AccountDetails> list = new ArrayList<>();
    public AccountDetailService(Connection conn) throws Exception {
        this.conn = DbConnection.getConnection();
    }
    
    int z=0;
    @Override
    public boolean addAccountDetails(AccountDetails accountDetails) {
        try {
            PreparedStatement ps = conn.prepareStatement(ADD_ACCOUNT_DETAILS);
            ps.setInt(1, accountDetails.getId());
            ps.setString(2, accountDetails.getAccountHolder());
            ps.setString(3, accountDetails.getEmail());
            ps.setString(4, accountDetails.getMobile());
            ps.setString(5, accountDetails.getAdhaarCardNumber());
            ps.setString(6, Double.toString(accountDetails.getBalance()));
            ps.setString(7, accountDetails.getAccountNumber());
            ps.setString(8, accountDetails.getSolId());
            ps.setString(9, accountDetails.getIfscCode());
            ps.setBoolean(10, true);
            ps.setBoolean(11, false);
            z=ps.executeUpdate();
            if(z>0){
                LOG.info("Add Account Details have been successfully inserted");
                status=true;
                return status;
            }else{
                LOG.info("Oops some error has occured");
                return status;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        return status;
    }

    @Override
    public boolean deleteAccountDetails(String accountNumber, boolean isClosed) {
        try {
            PreparedStatement ps=conn.prepareStatement(DELETE_ACCOUNT_DETAILS);
            ps.setBoolean(1, true);
            ps.setString(2, accountNumber);
            z=ps.executeUpdate();
            if(z>0){
                LOG.info("Delete Account Details have been successfully inserted");
                status=true;
                return status;
            }else{
                LOG.info("Oops some error has occured");
                return status;
            }
        } catch (Exception e) {
        }
   return status;
    }

    @Override
    public boolean updateAccountDetails(String accountNumber, String accountholderName) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_ACCOUNT_HOLDER_NAME);
            ps.setString(1, accountholderName);
            ps.setString(2, accountNumber);
            z=ps.executeUpdate();
            if(z>0){
                LOG.info("Update Account Details have been successfully inserted");
                status=true;
                return status;
            }else{
                LOG.info("Oops some error has occured");
                return status;
            }
        } catch (Exception e) {
        }
     return status;
    }
 
    @Override
    public boolean updateAccountDetailsEmail(String accountNumber, String email) {
        try {
            PreparedStatement ps =conn.prepareStatement(UPDATE_ACCOUNT_EMAIL);
            ps.setString(1, email);
            ps.setString(2, accountNumber);
            z=ps.executeUpdate();
            if(z>0){
                LOG.info("Update Account Details have been successfully inserted");
                status=true;
                return status;
            }else{
                LOG.info("Oops some error has occured");
                return status;
            }       
        } catch (Exception e) {
        }
        return status;
    }

    @Override
    public boolean updateAccountDetailsMobile(String accountHolder, String mobile) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_ACCOUNT_MOBILE);
            ps.setString(1, mobile);
            ps.setString(2, accountHolder);
            z=ps.executeUpdate();
            if(z>0){
                LOG.info("Update Account Details have been successfully inserted");
                status=true;
                return status;
            }else{
                LOG.info("Oops some error has occured");
                return status;
            }
        } catch (Exception e) {
        }
     return status;
    }
    @Override
    public boolean updateAccoutDetailsActive(String accountHolder, boolean isActive) {
     
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_ACCOUNT_IS_ACTIVE);
            ps.setBoolean(1, isActive);
            ps.setString(2, accountHolder);
            z=ps.executeUpdate();
            if(z>0){
                LOG.info("Update Account Details have been successfully inserted");
                status=true;
                return status;
            }else{
                LOG.info("Oops some error has occured");
                return status;
            }
        } catch (Exception e) {
        }
    return status;
    }

    @Override
    public boolean updateAccountDetailsClosed(String accountHolder, boolean isClosed) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_ACCOUNT_IS_CLOSED);
            ps.setBoolean(1, isClosed);
            ps.setString(2, accountHolder);
            z=ps.executeUpdate();
            if(z>0){
                LOG.info("Update Account Details have been successfully inserted");
                status=true;
                return status;
            }else{
                LOG.info("Oops some error has occured");
                return status;
            }
        } catch (Exception e) {
        }
   
        return status;
    }

    @Override
    public boolean updateAccountDetailsBaseBranch(String accountHolder, String solId, String ifscCode) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_ACCOUNT_BASE_BRANCH);
            ps.setString(1, solId);
            ps.setString(2, ifscCode);
            ps.setString(3, accountHolder);
            z=ps.executeUpdate();
            if(z>0){
                LOG.info("Update Account Details have been successfully inserted");
                status=true;
                return status;
            }else{
                LOG.info("Oops some error has occured");
                return status;
            }
        } catch (Exception e) {
        }
        return status;
                
    }
    
}
