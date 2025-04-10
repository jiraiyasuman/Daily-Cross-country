/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.entity;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author SUMAN
 */
public class BookingMovie {
    
    private String useerName;
    private String movieName;
    private LocalDate date;
    private LocalTime time;
    private String seatType;
    private int numberOfTickets;

    @Override
    public String toString() {
        return "BookingMovie{" + "useerName=" + useerName + ", movieName=" + movieName + ", date=" + date + ", time=" + time + ", seatType=" + seatType + ", numberOfTickets=" + numberOfTickets + '}';
    }

    public BookingMovie(String useerName, String movieName, LocalDate date, LocalTime time, String seatType, int numberOfTickets) {
        this.useerName = useerName;
        this.movieName = movieName;
        this.date = date;
        this.time = time;
        this.seatType = seatType;
        this.numberOfTickets = numberOfTickets;
    }

    public BookingMovie() {
    }

    
    public String getUseerName() {
        return useerName;
    }

    public void setUseerName(String useerName) {
        this.useerName = useerName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
