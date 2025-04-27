/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.repository;

import com.bankingapplication.bankingapplication.entity.AccountTransaction;
import java.util.List;

/**
 *
 * @author SUMAN
 */
public interface AccountTransactionRepository {
    
    public boolean fundTransferTransaction(String fromAccountNumber,String toAccountNumber,double amount,String date);
    
    public boolean cashDeposit(String fromAccountNumber,double amount,String date);
    
    public boolean cashWithDrawal(String toAccountNumber,double amount,String date);
    
    public List<AccountTransaction> displayAllStatements(String acountNumber,String fromDate,String toDate,int offset, int noOfRecords);
}
