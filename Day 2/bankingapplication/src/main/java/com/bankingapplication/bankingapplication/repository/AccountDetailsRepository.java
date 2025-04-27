/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.repository;

import com.bankingapplication.bankingapplication.entity.AccountDetails;

/**
 *
 * @author SUMAN
 */
public interface AccountDetailsRepository {
    public boolean addAccountDetails(AccountDetails accountDetails);
    
    public boolean deleteAccountDetails(String accountNumber,boolean isClosed);
    
    public boolean updateAccountDetails(String accountNumber,String accountholderName);
    
    public boolean updateAccountDetailsEmail(String accountNumber,String email);
    
    public boolean updateAccountDetailsMobile(String accountNumber,String mobile);
    
   
    
    public boolean updateAccoutDetailsActive(String accountNumber,boolean isActive);
    
    public boolean updateAccountDetailsClosed(String accountNumber,boolean isClosed);
    
    public boolean updateAccountDetailsBaseBranch(String accountNumber,String solId,String ifscCode);
    
    
}
