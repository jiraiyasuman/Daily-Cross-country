/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.service;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.Movie;
import java.util.List;

/**
 *
 * @author SUMAN
 */
public interface MovieService {
    
    public boolean addMovies(Movie movie);
    public void getAll();
    public boolean getMovieByCategory(String category);
    public boolean upateMovies(Movie movie);
    public void deleteMovieByName(String name);
}
