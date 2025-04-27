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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;

/**
 *
 * @author SUMAN
 */
@Entity(name="account_details")
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="account_holder")
    @NotEmpty
    private String accountHolder;
    @NotEmpty
    @Column(name="email",unique = true)
    private String email;
    @Column(name="mobile")
    @NotEmpty
    private String mobile;
    @Column(name="adhaar_card_number")
    @NotEmpty
    private String adhaarCardNumber;
    @Column(name="balance")
    @NotEmpty
    private double balance;
    @Column(name="account_number",unique = true)
    private String accountNumber;
    @Column(name = "sol_id")
    @NotEmpty
    private String solId;
    @Column(name="ifsc_code")
    private String ifscCode;
    @Column(name="is_active")
    private boolean isActive;
    @Column(name="is_closed")
    private boolean isClosed;

    @JoinTable(name="account_details_account_transaction",
            joinColumns = @JoinColumn(name="details_id"),
            inverseJoinColumns = @JoinColumn(name="transaction_id"))
    @OneToOne
    private AccountTransaction accountTransacion;
    
    

    
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSolId() {
        return solId;
    }

    public void setSolId(String solId) {
        this.solId = solId;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAdhaarCardNumber() {
        return adhaarCardNumber;
    }

    public void setAdhaarCardNumber(String adhaarCardNumber) {
        this.adhaarCardNumber = adhaarCardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public AccountDetails(String accountHolder, String email, String mobile, String adhaarCardNumber, double balance, String accountNumber, String solId, String ifscCode, boolean isActive, boolean isClosed) {
        this.accountHolder = accountHolder;
        this.email = email;
        this.mobile = mobile;
        this.adhaarCardNumber = adhaarCardNumber;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.solId = solId;
        this.ifscCode = ifscCode;
        this.isActive = isActive;
        this.isClosed = isClosed;
        
    }

    

    public AccountDetails() {
    }

    @Override
    public String toString() {
        return "AccountDetails{" + "id=" + id + ", accountHolder=" + accountHolder + ", email=" + email + ", mobile=" + mobile + ", adhaarCardNumber=" + adhaarCardNumber + ", balance=" + balance + ", accountNumber=" + accountNumber + ", solId=" + solId + ", ifscCode=" + ifscCode + ", isActive=" + isActive + ", isClosed=" + isClosed + '}';
    }
    
}
