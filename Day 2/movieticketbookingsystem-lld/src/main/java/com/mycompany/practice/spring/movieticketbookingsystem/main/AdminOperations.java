/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.main;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.Movie;
import com.mycompany.practice.spring.movieticketbookingsystem.serviceimpl.AdminLoginServiceImpl;
import com.mycompany.practice.spring.movieticketbookingsystem.serviceimpl.MovieServiceImpl;

/**
 *
 * @author SUMAN
 */
public class AdminOperations {
    
    AdminOperations adminOperations = new AdminOperations();
    MovieServiceImpl movieServiceImpl = new MovieServiceImpl();
    public boolean addMovies(Movie movie){
        boolean status= false;
        try {
          boolean temp = movieServiceImpl.addMovies(movie);
           if(temp){
               status =true;
               return status;
           }else{
               return status;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
                return status;
    }
    
    public boolean updateMovies(Movie movie){
        boolean status=false;
        try {
            boolean temp = movieServiceImpl.upateMovies(movie);
            if(temp){
                status= true;
                return status;
            }else{
                return status;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public void deleteMovieName(String name){
        movieServiceImpl.deleteMovieByName(name);
        System.out.println("Movie Name is deleted successfully");
    }
}
