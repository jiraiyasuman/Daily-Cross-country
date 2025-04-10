/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.main;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.AdminLogin;
import com.mycompany.practice.spring.movieticketbookingsystem.entity.BookingMovie;
import com.mycompany.practice.spring.movieticketbookingsystem.entity.Movie;
import com.mycompany.practice.spring.movieticketbookingsystem.entity.Review;
import com.mycompany.practice.spring.movieticketbookingsystem.entity.UserLogin;
import com.mycompany.practice.spring.movieticketbookingsystem.repository.ReviewRepository;
import com.mycompany.practice.spring.movieticketbookingsystem.service.AdminLoginService;
import com.mycompany.practice.spring.movieticketbookingsystem.serviceimpl.AdminLoginServiceImpl;
import com.mycompany.practice.spring.movieticketbookingsystem.serviceimpl.MovieServiceImpl;
import com.mycompany.practice.spring.movieticketbookingsystem.serviceimpl.UserLoginServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author SUMAN
 */
public class MovieMain {
    AdminLoginServiceImpl adminLoginServiceImpl = new AdminLoginServiceImpl();
    Movie movie = new Movie();
    UserLogin userLogin = new UserLogin();
    UserLoginServiceImpl userLoginServiceImpl = new UserLoginServiceImpl();
    Scanner scanner = new Scanner(System.in);
    AdminLogin adminLogins = new AdminLogin();
    BookingMovie bookingMovie = new BookingMovie();
    Review review = new Review();
        PasswordHashing passwordHashing = new PasswordHashing();
    static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String a[])throws Exception{
        System.out.println("Welcome to the movie booking ticket");
        MovieMain obj = new MovieMain();
        while(true){
            System.out.println("Please enter 1 for login as an admin");
            System.out.println("Please enter 2 for login as an user");
            System.out.println("Please enter 3 to exit the application");
            System.out.println("Please enter your choice");
            int choice= Integer.parseInt(BR.readLine());
            switch(choice){
                case 1:
                    obj.adminLogin();
                    break;
                case 2:
                    obj.userLogin();
                    break;
                case 3:
                    System.exit(0);
                    default:
                    System.out.println("Wrong choice");
                        
            }
        }
    }
    public void adminLogin() throws Exception{
        System.out.println("Welcome to the Admin Login System");
        MovieMain obj = new MovieMain();
        boolean status =false;
        
        while(true){
            System.out.println("Please press 1 to admin registration");
            System.out.println("Please press 2 to admin login");
            System.out.println("Please press 3 to go back to main menu");
            System.out.println("Please enter your choice");
            int choice= Integer.parseInt(BR.readLine());
            switch (choice) {
                case 1:
                    
                    System.out.println("Please enter the user name");
                    String userName=BR.readLine();
                    System.out.println("Please enter the email");
                    String email = BR.readLine();
                    System.out.println("Please enter the password");
                    String password = BR.readLine();
                    String hashedPassword = passwordHashing.passwordHashing(password) ;
                    adminLogins.setUserName(userName);
                    adminLogins.setEmail(email);
                    adminLogins.setPassword(hashedPassword);
                    status = adminLoginServiceImpl.registerUser(adminLogins);
                    if(status){
                        System.out.println("Registration is successfull");
                    }else{
                        System.out.println("Registration is not successful");
                    }
                    break;
                case 2:
                    System.out.println("Please enter the email");
                    email = BR.readLine();
                    System.out.println("Please enter the password");
                    password = BR.readLine();
                    hashedPassword = passwordHashing.passwordHashing(password) ;
                    status = adminLoginServiceImpl.loginUser(email, hashedPassword);
                    if(status){
                        boolean temp= false;
                        AdminOperations adminOperations = new AdminOperations();
                        System.out.println("Admin login is successfull");
                        System.out.println("Please press 1 to add movie");
                        System.out.println("Please press 2 to update movie");
                        System.out.println("Please press 3 to delete movie");
                        System.out.println("Please press 4 to return main menu");
                        System.out.println("Please enter your choice");
                        choice = Integer.parseInt(BR.readLine());
                        switch (choice) {
                            case 1:
                                System.out.println("Please enter the id of the movie");
                                int id = Integer.parseInt(BR.readLine());
                                System.out.println("Please enter the name of the movie");
                                String name= BR.readLine();
                                System.out.println("Please enter the category of the movie");
                                String category = BR.readLine();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                System.out.println("Please enter the release date of the movie in YYYY-MM-DD"); 
                                String input = scanner.nextLine();
                                LocalDate date = LocalDate.parse(input, formatter);
                                movie.setId(id);
                                movie.setName(name);
                                movie.setCategory(category);
                                movie.setReleaseDate(date);
                                temp = adminOperations.addMovies(movie);
                                if(temp){
                                    System.out.println("Movie Insertion is successful");
                                }else{
                                    System.out.println("Movie Insertion is not successful");
                                }
                                break;
                            case 2:
                                System.out.println("Please enter the id of the movie");
                                id = Integer.parseInt(BR.readLine());
                                System.out.println("Please enter the name of the movie");
                                name= BR.readLine();
                                System.out.println("Please enter the category of the movie");
                                category = BR.readLine();
                                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                System.out.println("Please enter the release date in YYYY-MM-DD");
                                input = scanner.nextLine();
                                date = LocalDate.parse(input, formatter);
                                movie.setId(id);
                                movie.setName(name);
                                movie.setCategory(category);
                                movie.setReleaseDate(date);
                                temp = adminOperations.updateMovies(movie);
                                if(temp)
                                    System.out.println("Updation is successfull");
                                else
                                    System.out.println("Updation is not successful");
                                break;
                            case 3:
                                System.out.println("Please enter the name of the name of the movie");
                                name= BR.readLine();
                                adminOperations.deleteMovieName(name);
                                break;
                            case 4:
                                String a[]={};
                                main(a);
                                break;
                            default:
                                System.out.println("Wrong choice");
                        }
                    }
                    break;
                case 3:
                    String a[]={};
                    main(a);
                    break;
                    
                default:
                    throw new AssertionError();
            }
        }
    }

    public void userLogin() throws IOException {
        System.out.println("Welcome to the user registration portal");
        System.out.println("Please press 1 for user registration");
        System.out.println("Please press 2 for user login");
        System.out.println("Please press 3 to return to the main menu");
        System.out.println("Please enter your choice");
        int choice = Integer.parseInt(BR.readLine());
        boolean status = false;
        switch (choice) {
            case 1:
                System.out.println("Welcome to the user registration portal");
                System.out.println("Please enter your user name");
                String username = BR.readLine();
                System.out.println("Please enter your email");
                String email = BR.readLine();
                System.out.println("Please enter your password");
                String password = BR.readLine();
                String hashPassword = passwordHashing.passwordHashing(password);
                userLogin.setUserName(username);
                userLogin.setEmail(email);
                userLogin.setPassword(hashPassword);
                status = userLoginServiceImpl.registerUser(userLogin);
                if(status)
                    System.out.println("User Registration is successful");
                else
                    System.out.println("User registration is not successful");
                break;
            case 2:
                System.out.println("Welcome to the User Login portal");
                System.out.println("Please enter the email");
                email = BR.readLine();
                System.out.println("Please enter the password");
                password = BR.readLine();
                hashPassword = passwordHashing.passwordHashing(password);
                status = userLoginServiceImpl.loginUser(email, hashPassword);
                if(status){
                    UserOperations userOperations = new UserOperations();
                    System.out.println("Welcome to the User Portal");
                    System.out.println("Please press 1 to view all the movie available");
                    System.out.println("Please press 2 to view movies by category");
                    System.out.println("Please press 3 to book movie tickets");
                    System.out.println("Please press 4 to add reviews");
                    System.out.println("Please press 5 to go to the main menu");
                    System.out.println("Please enter the choice");
                    choice = Integer.parseInt(BR.readLine());
                    while(true){
                        switch (choice) {
                            case 1:
                                userOperations.getAllMovies();
                                break;
                            case 2:
                                System.out.println("Please enter the category of the movies");
                                String category = BR.readLine();
                                userOperations.getMovieByCategory(category);
                            case 3:
                                System.out.println("Please enter your username");
                                String userName= BR.readLine();
                                System.out.println("Please enter the name of the movie");
                                String movieName = BR.readLine();
                                System.out.println("Please enter the date of the booking ");
                                LocalDate date = LocalDate.now();
                                System.out.println("Please enter the time of the booking");
                                LocalTime time= LocalTime.now();
                                System.out.println("Please press 1 for economy seats, 2 for reclinar seats, 3 for balcony seats");
                                int seat = Integer.parseInt(BR.readLine());
                                String type=userOperations.seatType(seat);
                                System.out.println("Please enter the number of tickets");
                                int numberOfTickets = Integer.parseInt(BR.readLine());
                                bookingMovie.setUseerName(userName);
                                bookingMovie.setMovieName(movieName);
                                bookingMovie.setDate(date);
                                bookingMovie.setTime(time);
                                bookingMovie.setSeatType(type);
                                bookingMovie.setNumberOfTickets(numberOfTickets);
                                userOperations.addMovieTickets(bookingMovie);
                            case 4:
                                ReviewRepository reviewRepository = new ReviewRepository();
                                MovieServiceImpl movieServiceImpl = new MovieServiceImpl();
                                System.out.println("Please enter the name of the movie");
                                movieName = BR.readLine();
                                System.out.println("PLease enter the username");
                                userName=BR.readLine();
                                System.out.println("Please enter the user Id");
                                int userId = Integer.parseInt(BR.readLine());
                                System.out.println("Please enter the movie id");
                                int movieId = movieServiceImpl.getMovieIdByName(movieName);
                                System.out.println("Please enter the review ");
                                String reviews = BR.readLine();
                                System.out.println("Please enter the movie ratings from any number from 0-5");
                                double ratings = Double.parseDouble(BR.readLine());
                                
                                int count = reviewRepository.calculateReviewCount(movieName);
                                double averageRating = reviewRepository.calculateAverageRatings(movieName,ratings);
                                review.setId(movieId);
                                review.setUserId(userId);
                                review.setUserName(userName);
                                review.setMovieName(movieName);
                                review.setReviewCount(count);
                                review.setRatings(ratings);
                                review.setReview(reviews);
                                review.setAverageRating(averageRating);
                                userOperations.addMovieTickets(bookingMovie);
                                break;
                            default:
                                throw new AssertionError();
                        }
                    }
                }else{
                    System.out.println("Email / Password is not valid");
                }
            default:
                throw new AssertionError();
        }
    }
}
