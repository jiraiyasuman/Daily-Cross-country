/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankingapplication.bankingapplication.emails;

/**
 *
 * @author SUMAN
 */
import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Emails {
    public static void sendEmail(String mes,String sub, String reciever,String sender) {
		
		//Variable for gmail
		String host="smtp.gmail.com";
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//to get the session object..Here I used the concept of inner class
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("suman.talukdar53@gmail.com", "ngscfgxdqhiacqhr"); // here the sender's email id and app password is being passed.
			}
			});
		session.setDebug(true);
		//compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		try {
		
		//The email id of the sender
		m.setFrom(sender);
		
		//The email id of the reciever
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
		
		//Here we are adding subject of the email
		m.setSubject(sub);
	
		
		//Here we are adding the message
		m.setText(mes);
		
		
		
		// send the message using Transport class
		Transport.send(m);
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	/*
	 * public static void main(String ar[])throws Exception{ sendEmail("test","sub",
	 * "suman.talukdar53@gmail.com","suman.talukdar53@gmail.com"); }
	 */
}
