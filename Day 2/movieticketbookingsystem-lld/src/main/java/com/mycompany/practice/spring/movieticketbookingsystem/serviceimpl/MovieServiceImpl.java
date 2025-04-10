/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.serviceimpl;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.Movie;
import com.mycompany.practice.spring.movieticketbookingsystem.repository.MovieRepository;
import com.mycompany.practice.spring.movieticketbookingsystem.service.MovieService;
import java.util.List;

/**
 *
 * @author SUMAN
 */
public class MovieServiceImpl implements MovieService{

    
    private MovieRepository movieRepository=new MovieRepository();
    
    @Override
    public boolean addMovies(Movie movie) {
        boolean status =false;
        try {
            boolean temp = movieRepository.addMovies(movie);
            if(temp){
                status = true;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
                    
        }
        return status;
    }

    @Override
    public void getAll() {
       
       movieRepository.getAll();
    }

    @Override
    public boolean getMovieByCategory(String category) {
      boolean status = false;
        try {
            boolean temp = movieRepository.getMovieByCategory(category);
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

    @Override
    public boolean upateMovies(Movie movie) {
     boolean status=false;
        try {
            boolean temp = movieRepository.updateMovies(movie);
            if(temp){
                status=true;
                return status;
            }else{
                return status;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public void deleteMovieByName(String name) {
     movieRepository.deleteMovieByName(name);
    }
    
    public int getMovieIdByName(String name){
        int result =0;
        result = movieRepository.getMovieIdByName(name);
        return result;
    }
    
}
