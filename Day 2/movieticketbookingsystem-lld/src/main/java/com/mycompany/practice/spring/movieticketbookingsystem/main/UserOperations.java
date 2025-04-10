/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.main;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.BookingMovie;
import com.mycompany.practice.spring.movieticketbookingsystem.entity.Review;
import com.mycompany.practice.spring.movieticketbookingsystem.serviceimpl.BookingServiceImpl;
import com.mycompany.practice.spring.movieticketbookingsystem.serviceimpl.MovieServiceImpl;
import com.mycompany.practice.spring.movieticketbookingsystem.serviceimpl.ReviewServiceImpl;
import java.io.IOException;

/**
 *
 * @author SUMAN
 */
public class UserOperations {
    
    BookingMovie bookingMovie = new BookingMovie();
    Review review = new Review();
    MovieServiceImpl movieServiceImpl= new MovieServiceImpl();
    BookingServiceImpl bookingServiceImpl= new BookingServiceImpl();
    ReviewServiceImpl reviewServiceImpl = new ReviewServiceImpl();
    MovieMain obj = new MovieMain();
    public void getAllMovies(){
        movieServiceImpl.getAll();
    }
    public void getMovieByCategory(String category){
       boolean status =  movieServiceImpl.getMovieByCategory(category);
       if(status)
            System.out.println("Movies found ");
       else
            System.out.println("Movies not found");
    }
    public void addMovieTickets(BookingMovie bookingMovie){
        boolean status=bookingServiceImpl.registerMovieBooking(bookingMovie);
        if(status)
            System.out.println("Bookng movie is successful");
        else
            System.out.println("Booking movie is not successful");
    }
    public void addReview(Review review){
        boolean status = reviewServiceImpl.addReviews(review);
        if(status)
            System.out.println("Review addition is successful");
        else
            System.out.println("Review addition is not successful");
    }
    public String seatType(int seat) throws IOException{
        if(seat==1){
            return "economy Seats";
        }else if(seat==2){
            return "reclinar Seats";
        }else if(seat==3){
            return "balcony Seats";
        }else{
            obj.userLogin();
        }
        return "";
    }
    
}
