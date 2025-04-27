/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.securityconfig;

/**
 *
 * @author SUMAN
 */
public class AdhaarCardHashing {
    
    
    int length=0;
    String splice="",temp="",result="",finalResult="";char ch;
    public String recieve(String adhaarCard){
        splice = adhaarCard.substring(0, 8);
        for(int j=0;j<5;j++){
            result=operation(splice);
        }
        finalResult = result+adhaarCard.substring(8);
        return finalResult;
    }
    
    public String operation(String recieve){
        int n=0;temp="";
        for(int i=0;i<recieve.length();i++){
            ch=splice.charAt(i);
            n=(int)ch;
            n=n+15;
            ch=(char)n;
            temp=temp+ch;
        }
        return temp;
    }
}
