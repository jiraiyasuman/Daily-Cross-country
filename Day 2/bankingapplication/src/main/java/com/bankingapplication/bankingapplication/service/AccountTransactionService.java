/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.service;

import com.bankingapplication.bankingapplication.connection.DbConnection;
import com.bankingapplication.bankingapplication.entity.AccountDetails;
import com.bankingapplication.bankingapplication.entity.AccountTransaction;
import com.bankingapplication.bankingapplication.repository.AccountTransactionRepository;
import java.util.List;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
/**
 *
 * @author SUMAN
 */
public class AccountTransactionService implements AccountTransactionRepository{

    private static final Logger LOG = Logger.getLogger(AccountTransactionService.class.getName());

    private boolean status=false;
    private Connection conn;

    public AccountTransactionService(Connection conn) throws Exception {
        this.conn = DbConnection.getConnection();
    }

    public AccountTransactionService() {
    }
  
    
    private List<AccountTransaction> list= new ArrayList<>();
    private static final String QUERY_ADD_FUND_TRANSACTIONS ="INSERT INTO `banking`.`account_transaction` (`id`, `from_account_number`, `to_account_number`, `balance`,`credit_amount`,`debit_balance`,`type_of_transaction`, `tranaction_date`) VALUES ('?', '?', '?', '?', '?','?','?','?');";
    private static final String ADD_CASH_DEPOSIT="`id`, `from_account_number`, `to_account_number`, `balance`,`credit_amount`,`debit_balance`,`type_of_transaction`, `tranaction_date`) VALUES ('?', '?', '?', '?', '?','?','?','?');";
    private static final String ADD_CASH_WITHDRAWAL ="INSERT INTO `banking`.`account_transaction` (`id`, `from_account_number`, `to_account_number`, `balance`,`credit_amount`,`debit_balance`,`type_of_transaction`, `tranaction_date`) VALUES ('?', '?', '?', '?', '?','?','?','?');";
    private static final String FIND_ALL_STATEMENTS="SELECT * FROM `banking`.`account_transaction` WHERE FROM_ACCOUNT_NUMBER =? AND TRANACTION_DATE BETWEEN  ";
    private AccountTransaction accountTransaction = new AccountTransaction();
    private AccountDetails accountDetails= new AccountDetails();
    boolean temp1=false,temp2=false;
    int result=0;
    private static final String FIND_ACCOUNT_NUMBERS="SELECT * FROM `banking`.`account_details` WHERE FROM_ACCOUNT_NUMBER =?;";  
    @Override
    public boolean fundTransferTransaction(String fromAccountNumber, String toAccountNumber, double amount, String date) {
        temp1=findAccountDetails(fromAccountNumber);
        temp2=findAccountDetails(toAccountNumber);
        if(temp1==true&&temp2==true){
            double balance1=0.0d,balance2=0.0d;
            double updatedBalance1=0.0d,updatedBalance2=0.0d;
            try{
                balance1 = getBalance(fromAccountNumber);
                balance2 = getBalance(toAccountNumber);
                updatedBalance1=balance1-amount;
                updatedBalance2=balance2+amount;
                updateBalance(toAccountNumber, updatedBalance2);
                updateBalance(fromAccountNumber, updatedBalance2);
                if(balance1>amount){
                boolean isActive1=getAccountIsActive(toAccountNumber);
                boolean isActive2=getAccountIsActive(fromAccountNumber);
                boolean isClosed1=getAccountISClosed(toAccountNumber);
                boolean isClosed2=getAccountISClosed(fromAccountNumber);
                if(isActive1==true&&isActive2==true){ 
                    if(isClosed1!=false||isClosed2!=false){
                        try {
            PreparedStatement ps = conn.prepareStatement(QUERY_ADD_FUND_TRANSACTIONS);
            ps.setInt(1,accountTransaction.getId());
            ps.setString(2, fromAccountNumber);
            ps.setString(3, toAccountNumber);
            ps.setString(4, Double.toString(amount));
            ps.setString(5, "-");
            ps.setString(6, "-");
            ps.setString(7, "FUND TRANSFER");
            ps.setString(8, date);
            result=ps.executeUpdate();
            if(result>0){
            LOG.info("Fund Tansfer component in the account transation is being executed");
            status=true;
            return status;
            }else{
                LOG.info("Fund Tansfer component in the account transation is not being executed");
                return status;
            }
            
            
        } catch (Exception e) {
            System.err.println(e);
        }       
                    }
                }
                 }
              }catch(Exception e){
                 System.err.println(e);       
            }
        }
        return status;
    }
   
    @Override
    public boolean cashDeposit(String fromAccountNumber, double amount,String date) {
     temp1=findAccountDetails(fromAccountNumber);
       
        if(temp1==true&&temp2==true){
            double balance1=0.0d,balance2=0.0d;
            double updatedBalance1=0.0d,updatedBalance2=0.0d;
            try{
                balance1 = getBalance(fromAccountNumber);
                
                //updatedBalance1=balance1-amount;
                updatedBalance2=balance2+amount;
                
                updateBalance(fromAccountNumber, updatedBalance2);
                if(balance1>amount){
                //boolean isActive1=getAccountIsActive(toAccountNumber);
                boolean isActive2=getAccountIsActive(fromAccountNumber);
                //boolean isClosed1=getAccountISClosed(toAccountNumber);
                boolean isClosed2=getAccountISClosed(fromAccountNumber);
                if(isActive2==true){ 
                    if(isClosed2!=false){
                        try {
            PreparedStatement ps = conn.prepareStatement(ADD_CASH_DEPOSIT);
            ps.setInt(1,accountTransaction.getId());
            ps.setString(2, fromAccountNumber);
            ps.setString(3, "-");
            ps.setString(4, Double.toString(updatedBalance2));
            ps.setString(5, Double.toString(amount));
            ps.setString(6, "-");
            ps.setString(7, "CASH DEPOSIT");
            ps.setString(8, date);
            result=ps.executeUpdate();
            if(result>0){
            LOG.info("Cash Deposit component in the account transation is being executed");
            status=true;
            return status;
            }else{
                LOG.info("Cash Deposit component in the account transation is not being executed");
                return status;
            }
            
            
        } catch (Exception e) {
            System.err.println(e);
        }       
                    }
                }
                 }
              }catch(Exception e){
                 System.err.println(e);       
            }
        }
        return status;  
    }

    @Override
    public boolean cashWithDrawal(String toAccountNumber, double amount,String date) {
    temp1=findAccountDetails(toAccountNumber);
       
        if(temp1==true&&temp2==true){
            double balance1=0.0d,balance2=0.0d;
            double updatedBalance1=0.0d,updatedBalance2=0.0d;
            try{
                balance1 = getBalance(toAccountNumber);
                
                updatedBalance1=balance1-amount;
               // updatedBalance2=balance2+amount;
                
                updateBalance(toAccountNumber, updatedBalance2);
                if(balance1>amount){
                //boolean isActive1=getAccountIsActive(toAccountNumber);
                boolean isActive2=getAccountIsActive(toAccountNumber);
                //boolean isClosed1=getAccountISClosed(toAccountNumber);
                boolean isClosed2=getAccountISClosed(toAccountNumber);
                if(isActive2==true){ 
                    if(isClosed2!=false){
                        try {
            PreparedStatement ps = conn.prepareStatement(ADD_CASH_DEPOSIT);
            ps.setInt(1,accountTransaction.getId());
            ps.setString(2, toAccountNumber);
            ps.setString(3, "-");
            ps.setString(4, Double.toString(updatedBalance1));
            ps.setString(5, "-");
            ps.setString(6, Double.toString(amount));
            ps.setString(7, "CASH WITHDRAWAL");
            ps.setString(8, date);
            result=ps.executeUpdate();
            if(result>0){
            LOG.info("Cash Withdrawal component in the account transation is being executed");
            status=true;
            return status;
            }else{
                LOG.info("Cash Withdrawal component in the account transation is not being executed");
                return status;
            }
            
            
        } catch (Exception e) {
            System.err.println(e);
        }       
                    }
                }
                 }
              }catch(Exception e){
                 System.err.println(e);       
            }
        }
        return status;      
    }

    @Override
    public List<AccountTransaction> displayAllStatements(String acountNumber, String fromDate, String toDate,int offset, int noOfRecords) {
        try {
            PreparedStatement ps = conn.prepareStatement(FIND_ALL_STATEMENTS+"AND TRANSACTION_DATE BETWEEN "+fromDate+" AND"+toDate+" AND LIMIT ?,?;");
            ps.setString(1, acountNumber);
            ps.setInt(2, offset);
            ps.setInt(3, noOfRecords);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                accountTransaction = new AccountTransaction(rs.getInt(1), rs.getString(2), rs.getString(3), Double.parseDouble(rs.getString(4)), Double.parseDouble(rs.getString(5)), Double.parseDouble(rs.getString(6)), rs.getString(7), rs.getString(8));
                list.add(accountTransaction);
            }
            if(list!=null){
                LOG.info("display all statements is being executed");
                return list;
            }else{
                LOG.info("Oops some error occurred");
                return list;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return list;
    }
    public  int getTotalRecords() {
        int count = 0;
        try {
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM `banking`.`account_details`");
             ResultSet rs = stmt.executeQuery(); 

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    
    public boolean findAccountDetails(String accountNumber){
        try {
            PreparedStatement ps = conn.prepareStatement(FIND_ACCOUNT_NUMBERS);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               accountDetails=new AccountDetails( rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9), rs.getBoolean(10));
            }
            if (accountDetails!=null) {
                status= true;
                LOG.info(" Find Account Details Service is being executed ");
                return status;
            }else{
                LOG.info(" Find Account Details Service is not being executed due to some error");
                return status;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return status;
    }
    public double getBalance(String accountNumber) throws SQLException{
        String queryBalance="SELECT BALANCE FROM `banking`.`account_details` WHERE FROM_ACCOUNT_NUMBER =?;";
        double balance=0.0d;
        try {
            PreparedStatement ps = conn.prepareStatement(queryBalance);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                balance=rs.getDouble(1);
            }
            if(balance!=0.0d){
                LOG.info(" Get Account Balance Details Service is being executed ");
                return balance;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        return balance;
        
    }
    
    public boolean getAccountIsActive(String accountNumber)throws Exception
    {
        String queryIsActive="SELECT IS_ACTIVE FROM `banking`.`account_details` WHERE FROM_ACCOUNT_NUMBER =?;";
        boolean isActive=false;
        try {
            PreparedStatement ps = conn.prepareStatement(queryIsActive);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                isActive=rs.getBoolean(1);
            }
            if(isActive==true){
                LOG.info(" Get Account Is active Service is being executed ");
                return isActive;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return isActive;
    }
    
    public boolean getAccountISClosed(String accountNumber)throws Exception{
        String queryIsActive="SELECT IS_CLOSED FROM `banking`.`account_details` WHERE FROM_ACCOUNT_NUMBER =?;";
        boolean isClosed=false;
        try {
            PreparedStatement ps = conn.prepareStatement(queryIsActive);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                isClosed=rs.getBoolean(1);
            }
            if(isClosed==true){
                LOG.info(" Get Account is Closed Service is being executed ");
                return isClosed;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return isClosed;
    }
    public void updateBalance(String accountNumber,double balance){
        String updateBalance="UPDATE `banking`.`account_details` SET BALANCE WHERE ACCOUNT_NUMBER=?;";
        try {
            PreparedStatement ps = conn.prepareStatement(updateBalance);
            ps.setDouble(1, balance);
            ps.setString(2, accountNumber);
            int z = ps.executeUpdate();
            if(z>0){
                LOG.info("Update Balance Service is being exceuted");
            }else{
                LOG.info(" Update Balance Service is not being executed due to some error");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
