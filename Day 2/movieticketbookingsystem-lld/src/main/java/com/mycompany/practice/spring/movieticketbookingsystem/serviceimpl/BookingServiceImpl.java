/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.serviceimpl;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.BookingMovie;
import com.mycompany.practice.spring.movieticketbookingsystem.repository.BookingMovieRepository;
import com.mycompany.practice.spring.movieticketbookingsystem.service.BookingService;
import java.util.List;

/**
 *
 * @author SUMAN
 */
public class BookingServiceImpl implements BookingService{

    private BookingMovieRepository bookingMovieRepository;
    @Override
    public boolean registerMovieBooking(BookingMovie bookingMovie) {
      boolean status =false;
        try {
           bookingMovieRepository.bookingSeats(bookingMovie);
           status =true;
           return status;
        } catch (Exception e) {
        e.printStackTrace();
        }
        return status;
    }

    @Override
    public void getAll() {
    bookingMovieRepository.displayList();
    }
    
}
