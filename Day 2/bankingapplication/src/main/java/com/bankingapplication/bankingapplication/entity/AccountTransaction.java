/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 *
 * @author SUMAN
 */
@Entity(name="account_transaction")
public class AccountTransaction {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="from_account_number")
    @NotEmpty
    private String fromAccountNumber;
    @Column(name="to_account_number")
    @NotEmpty
    private String toAccountNumber;
    @Column(name="balance")
    @NotEmpty
    private double balance;
    @Column(name="credit_amount")
    private double creditAmount;
    @Column(name="debit_balance")
    private double debitBalance;
    @Column(name="tranaction_date")
    private String transactionDate;
    @Column(name="type_of_transaction")
    private String typeOfTransaction;
    @OneToOne(mappedBy = "account_transaction")
    private AccountDetails accountDetails;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(String fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public double getDebitBalance() {
        return debitBalance;
    }

    public void setDebitBalance(double debitBalance) {
        this.debitBalance = debitBalance;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    @Override
    public String toString() {
        return "AccountTransaction{" + "id=" + id + ", fromAccountNumber=" + fromAccountNumber + ", toAccountNumber=" + toAccountNumber + ", balance=" + balance + ", creditAmount=" + creditAmount + ", debitBalance=" + debitBalance + ", transactionDate=" + transactionDate + ", typeOfTransaction=" + typeOfTransaction + ", accountDetails=" + accountDetails + '}';
    }

    
    public AccountTransaction() {
    }

    public AccountTransaction(int id, String fromAccountNumber, String toAccountNumber, double balance, double creditAmount, double debitBalance, String transactionDate, String typeOfTransaction) {
        this.id = id;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.balance = balance;
        this.creditAmount = creditAmount;
        this.debitBalance = debitBalance;
        this.transactionDate = transactionDate;
        this.typeOfTransaction = typeOfTransaction;
    }

    
    public AccountTransaction( String fromAccountNumber, String toAccountNumber, double balance, double creditAmount, double debitBalance, String transactionDate, String typeOfTransaction) {
        
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.balance = balance;
        this.creditAmount = creditAmount;
        this.debitBalance = debitBalance;
        this.transactionDate = transactionDate;
        this.typeOfTransaction = typeOfTransaction;
    }

    
    
}
