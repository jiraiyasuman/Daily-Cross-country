/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.service;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.BookingMovie;
import java.util.List;

/**
 *
 * @author SUMAN
 */
public interface BookingService {
    
     public boolean registerMovieBooking(BookingMovie bookingMovie);
     public void getAll();
   
}
