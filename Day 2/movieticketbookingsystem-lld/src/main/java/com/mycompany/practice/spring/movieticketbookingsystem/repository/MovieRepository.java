/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.repository;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.Movie;
import com.sun.source.tree.ContinueTree;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
public class MovieRepository {
    
    private List<Movie> movies = new ArrayList<>();
    private Logger LOGGER = Logger.getLogger(getClass().getName());
    public boolean addMovies(Movie movie){
        boolean status = false;
        try {
            movies.add(movie);
            status =true;
            LOGGER.info("Movie add movie is being executed");
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public void getAll(){
        Movie movie = new Movie();
        try {
            LOGGER.info("Movie repository get all movies is being executed");
            System.out.println("Movie List");
            for(int i=0;i<movies.size();i++){
               movie = movies.get(i);
                System.out.println(movie.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean getMovieByCategory(String category){
        boolean status = false;
        Movie movie = new Movie();
        try {
            LOGGER.info("Movie repository get movie by category");
            ArrayList<Movie> categories = new ArrayList<>();
            for(int i=0;i<movies.size();i++){
                movie =movies.get(i);
                if(movie.getCategory().equalsIgnoreCase(category)){
                    categories.add(movie);
                }else{
                    continue;
                }
            }
            if(categories!=null){
                System.out.println("Movies by the category");
            for(int i=0; i<categories.size();i++){
                movie=categories.get(i);
                System.out.println(movie.toString());
            }
            LOGGER.info("Movie Repository get Movie by category is executed");
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
        Movie moviess = new Movie();
        try {
            for(int i=0; i<movies.size();i++){
                moviess = movies.get(i);
                if(moviess.getName().equalsIgnoreCase(movie.getName())){
                    moviess.setName(movie.getName());
                    moviess.setCategory(movie.getCategory());
                    moviess.setReleaseDate(movie.getReleaseDate());
                    movies.set(moviess.getId(), moviess);
                    status=true;
                    LOGGER.info("Movie Update Repository is being executed");
                    return status;
                }else{
                    return status;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public void deleteMovieByName(String name){
        Movie movie =new Movie();
        
        for(int i=0; i<movies.size();i++){
            movie = movies.get(i);
            if(name.equalsIgnoreCase(movie.getName())){
                movies.remove(i);
                LOGGER.info("Movie delete repository is being executed");
            }
        }
    }
    
    public int getMovieIdByName(String name){
        int result=0;
         Movie movie =new Movie();
        
        for(int i=0; i<movies.size();i++){
             movie = movies.get(i);
            if(name.equalsIgnoreCase(movie.getName())){
                result = movie.getId();
                return result;
            }else{
                return result;
            }
        }
        return result;
    }
}
