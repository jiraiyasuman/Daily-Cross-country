/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.shoppingcartlld.controller;

import com.mycompany.practice.spring.movieticketbookingsystem.main.PasswordHashing;
import com.mycompany.practice.spring.shoppingcartlld.entity.CartItems;
import com.mycompany.practice.spring.shoppingcartlld.entity.LoginData;
import com.mycompany.practice.spring.shoppingcartlld.entity.Product;
import com.mycompany.practice.spring.shoppingcartlld.exception.OutOfStockException;
import com.mycompany.practice.spring.shoppingcartlld.repository.CartRepository;
import com.mycompany.practice.spring.shoppingcartlld.repository.LoginDataRepository;
import com.mycompany.practice.spring.shoppingcartlld.repository.ProductRepository;
import com.mycompany.practice.spring.shoppingcartlld.serviceimpl.CartServiceImpl;
import com.mycompany.practice.spring.shoppingcartlld.serviceimpl.LoginDataServiceImpl;
import com.mycompany.practice.spring.shoppingcartlld.serviceimpl.ProductServiceImpl;
import java.io.InputStreamReader;

/**
 *
 * @author SUMAN
 */
import java.io.*;
import java.util.Random;
public class ShoppingCartMain {
    
     LoginData loginData = new LoginData();
     LoginDataServiceImpl loginDataServiceImpl = new LoginDataServiceImpl();
     LoginDataRepository loginDataRepository = new LoginDataRepository();
     PasswordHashing passwordHashing = new PasswordHashing();
     Product product = new Product();
     ProductServiceImpl productServiceImpl = new ProductServiceImpl();
    static BufferedReader BR= new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException, Exception {
        ShoppingCartMain shoppingCartMain = new ShoppingCartMain();
        shoppingCartMain.operation();
    }
    public void operation()throws Exception{
        while(true){
            System.out.println("Welcome to E-Commerce Shopping Cart LLD");
        System.out.println("Please press 1 to register to the E-Commmerce Shopping Cart");
        System.out.println("Please press 2 to login to the E-Commerce Shopping Cart");
        System.out.println("Please press 3 to return to the main menu");
        System.out.println("Please enter the choice");
        int choice= Integer.parseInt(BR.readLine());
        String userName="",email="",password="",role="",hashedPassword="";
        switch (choice) {
            case 1:
                System.out.println("Please enter the username");
                userName=BR.readLine();
                System.out.println("Please enter the email");
                email=BR.readLine();
                System.out.println("Please enter the password");
                password = BR.readLine();
                hashedPassword = passwordHashing.passwordHashing(password);
                System.out.println("Please enter the role");
                role=BR.readLine();
                loginDataServiceImpl.RegisterLoginData(loginData);
                System.out.println("Login Data is registered successfully");
                break;
            case 2:
                System.out.println("Please enter the email");
                email = BR.readLine();
                System.out.println("Please enter the password");
                password = BR.readLine();
                hashedPassword = passwordHashing.passwordHashing(password);
                role= loginDataRepository.getRole(email, password);
                boolean status = loginDataServiceImpl.loginLoginData(email, hashedPassword);
                if(status){
                    if(role.equalsIgnoreCase("ADMIN"))
                    {
                        adminOperations();
                    }else{
                        userOperations();
                    }
                }
                break;
            case 3:
                String a[]={};
                main(a);
            default:
                System.out.println("Wrong choice");
        }
        }
    }

    private void adminOperations()throws Exception{
        while(true){
             System.out.println("Welcome to the E-Commerce Admin Panel");
         System.out.println("Please press 1 to add a product");
         System.out.println("Please press 2 to display all the products");
         System.out.println("Please press 3 to update the products");
         System.out.println("Please press 4 to delete the product");
         System.out.println("Please press 5 to approve the refund");
         System.out.println("Please press 6 to logout and return back to main menu");
             System.out.println("Please enter your choice");
             int choice= Integer.parseInt(BR.readLine());
             String productName="",category="";
             int stock=0;
             double price=0.0d;
             boolean status=false;
             switch (choice) {
                case 1:
                    System.out.println("Please enter the product name");
                    productName=BR.readLine();
                    System.out.println("Please enter the category of the product name");
                    category=BR.readLine();
                    System.out.println("Please enter the price");
                    price=Double.parseDouble(BR.readLine());
                    System.out.println("Please enter the stock");
                    stock=Integer.parseInt(BR.readLine());
                    product.setProductName(productName);
                    product.setPrice(price);
                    product.setStock(stock);
                    product.setCategory(category);
                    status=productServiceImpl.addProduct(product);
                    break;
                case 2:
                    productServiceImpl.getAllList();
                    break;
                case 3:
                    System.out.println("Please enter the product name");
                    productName=BR.readLine();
                    System.out.println("Please enter the category of the product name");
                    category=BR.readLine();
                    System.out.println("Please enter the price");
                    price=Double.parseDouble(BR.readLine());
                    System.out.println("Please enter the stock");
                    stock=Integer.parseInt(BR.readLine());
                    product.setProductName(productName);
                    product.setPrice(price);
                    product.setStock(stock);
                    product.setCategory(category);
                    status=productServiceImpl.addProduct(product);
                    break;
                case 4:
                    System.out.println("Please enter the product name");
                    productName=BR.readLine();
                    break;
                case 5:
                    break;
                case 6:
                    String a[]={};
                    main(a);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
         }
    }

    private void userOperations()throws Exception {
        System.out.println("Welcome to User Module in E-Commerce Portal");
        System.out.println("Please press 1 to view all the produts");
        System.out.println("PLease press 2 to view all the products in sorted order in price");
        System.out.println("Please press 3 to add items to my cart");
        System.out.println("PLease press 4 to view items in my cart");
        System.out.println("Please press 5 to place order for my cart");
        System.out.println("Please press 6 to cancel my order");
        System.out.println("Please press 7 to return an order");
        System.out.println("Please press 8 to return to the main menu");
        System.out.println("Please enter your choice");
        int choice= Integer.parseInt(BR.readLine());
        switch (choice) {
            case 1:
                productServiceImpl.getAllList();
                break;
            case 2:
                productServiceImpl.getOrdersSorted();
                break;
            case 3:
                addCart();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:
                throw new AssertionError();
        }
    }

    ProductRepository productRepository= new ProductRepository();
    CartServiceImpl cartServiceImpl = new CartServiceImpl();
    CartItems cartItems = new CartItems();
    private void addCart() throws IOException, OutOfStockException {
      
        while(true){
            Random random = new Random();
        int id= 1000+random.nextInt(9000);
        System.out.println("Please enter the name of the product");
        String productName=BR.readLine();
        System.out.println("Please enter the email");
        String email= BR.readLine();
        System.out.println("PLease enter the user name");
        String userName=BR.readLine();
        System.out.println("Please enter the quantity of product");
        int quantiy = Integer.parseInt(BR.readLine());
        int stock= productRepository.getStock(productName);
        if(stock == 0)
            throw new OutOfStockException("Product is out of stock");
        else if(stock<quantiy)
                throw new OutOfStockException("Product is out of stock");
               else
        {
            double price=productRepository.getPrice(productName);
            double totalPrice= price*quantiy;
            cartItems.setId(id);
            cartItems.setEmail(email);
            cartItems.setPaymentStatus(false);
            cartItems.setProductName(productName);
            cartItems.setQuantity(quantiy);
            cartItems.setTotalPrice(totalPrice);
            cartItems.setUserName(userName);
            boolean status = cartServiceImpl.addCart(cartItems);
            System.out.println("Please press 'y' to continue adding products to the cart");
            System.out.println("Please press 'n' to go the payment portal");
            System.out.println("Please enter your choice");
            char c = (char) BR.read();
            if(c=='y'||c=='Y'){
                continue;
            }
                    
        }
        
        
        }
    }
}
