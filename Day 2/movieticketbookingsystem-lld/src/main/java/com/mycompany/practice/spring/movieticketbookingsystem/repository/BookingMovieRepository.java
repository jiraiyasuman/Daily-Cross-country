/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.repository;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.BookingMovie;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
public class BookingMovieRepository {
    private final int totalSeats = 300;
    private final int economySeats= 160;
    private final int reclinarSeats = 100;
    private final int balconySeats = 40;
    private ArrayList<BookingMovie> economy = new ArrayList<>();
    private ArrayList<BookingMovie> reclinar = new ArrayList<>();
    private ArrayList<BookingMovie> balcony = new ArrayList<>();
    private Logger LOGGER = Logger.getLogger(getClass().getName());
    public int getAvailableEconomySeats(){
        int result =0;
        result = economySeats - economy.size();
        LOGGER.info("Booking Movie repository is");
        return result;
    }
    public int getAvailableReclinarSeats(){
        int result =0;
        result = reclinarSeats - reclinar.size();
        return result;
    }
    public int getAvailableBalconySeats(){
        int result =0;
        result = balconySeats - balcony.size();
        return result;
    }
    public boolean bookingSeats(BookingMovie bookingMovie){
        boolean status = false;
        try {
            if(bookingMovie.getSeatType().equalsIgnoreCase("economy Seats")){
                if(economySeats>economy.size()){
                    economy.add(bookingMovie);
                    status=true;
                    System.out.println("Movie Tickets have been booked successfully");
                    LOGGER.info("Booking Seats BookingMovieRepository is being executed");
                    return status;
                }else{
                    System.out.println("Booking seats are unavailable");
                    LOGGER.info("Booking Seats BookingMovieRepository is being executed");
                    return status;
                }
            }else if(bookingMovie.getSeatType().equalsIgnoreCase("reclinar Seats")){
                if(reclinarSeats>reclinar.size()){
                    reclinar.add(bookingMovie);
                    status=true;
                    System.out.println("Movie Tickets have been booked successfully");
                    LOGGER.info("Booking Seats BookingMovieRepository is being executed");
                    return status;
                }else{
                    System.out.println("Booking seats are unavailable");
                    LOGGER.info("Booking Seats BookingMovieRepository is being executed");
                    return status;
                }
            }else{
                if(balconySeats<balcony.size()){
                    balcony.add(bookingMovie);
                    System.out.println("Movie Tickets have been booked successfully");
                    LOGGER.info("Booking Seats BookingMovieRepository is being executed");
                    return status;
                }else{
                    System.out.println("Booking seats are unavailable");
                    LOGGER.info("Booking Seats BookingMovieRepository is being executed");
                    return status;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public void displayList(){
        BookingMovie bookingMovie = new BookingMovie();
        // display the economy seat booking
        LOGGER.info("Executing display all Booking Movie Repository");
        System.out.println("Displaying the economy seats booking");
        for(int i=0;i<economy.size();i++){
            bookingMovie = economy.get(i);
            System.out.println(bookingMovie.toString());
        }
        // display the reclinear seat booking
        System.out.println("Displaying the reclinar seats booking");
        for(int i=0;i<reclinar.size();i++){
            bookingMovie = reclinar.get(i);
            System.out.println(bookingMovie.toString());
        }
        System.out.println("Displaying the balcony seats booking");
        // display the balcony seats booking
        for(int i=0;i<balcony.size();i++){
            bookingMovie = balcony.get(i);
            System.out.println(bookingMovie.toString());
        }
    }
}
