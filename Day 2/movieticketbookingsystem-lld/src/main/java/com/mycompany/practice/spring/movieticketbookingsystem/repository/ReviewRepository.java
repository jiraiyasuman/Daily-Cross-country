/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.repository;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.Review;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
/**
 *
 * @author SUMAN
 */
public class ReviewRepository {
    private List<Review> reviews = new ArrayList<>();
    private Logger LOGGER = Logger.getLogger(getClass().getName());
    public boolean addReviews(Review review){
        boolean status = false;
        try {
            reviews.add(review);
            LOGGER.info("Review Repository addReviews is being executed");
            status =true;
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public void displayAllReviews(){
        try {
            Review review = new Review();
            System.out.println("Displaying the movie reviews");
            for(int i=0;i<reviews.size();i++){
             review =reviews.get(i);
                System.out.println(review.toString());
            }
            LOGGER.info("Review Display is being executed");
        } catch (Exception e) {
            e.printStackTrace();
                    
        }
    }
    public double calculateAverageRatings(String movieName,double ratings){
        double averageRating=0.0d;
        int count =0;double sum =0.0d;
        Review review = new Review();
        // counting the number of reviews 
        for(int i=0;i<reviews.size();i++){
            review = reviews.get(i);
            if(review.getMovieName().equalsIgnoreCase(movieName)){
                count+=1;   
            }
        }
        System.out.println("Total number of reviews are"+count);
        // fetching the average ratings 
        for(int i=0; i<reviews.size();i++){
             review = reviews.get(i);
            if(review.getMovieName().equalsIgnoreCase(movieName)){
                averageRating = review.getAverageRating();
                break;
            }
        }
        // calculate the new average ratings
        sum = averageRating*count;
        averageRating = (sum+ratings)/(count+1);
        LOGGER.info("Review Repository average rating is being executed");
        return averageRating;
    }
    public int calculateReviewCount(String movieName){
        int count=0;
         Review review = new Review();
        // counting the number of reviews 
        for(int i=0;i<reviews.size();i++){
            review = reviews.get(i);
            if(review.getMovieName().equalsIgnoreCase(movieName)){
                count+=1;   
            }
        }
        System.out.println("Total review count"+count);
        LOGGER.info("Review Repository calculate review count is being executed");
        return count;
    }
}
