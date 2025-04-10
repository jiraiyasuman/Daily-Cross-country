/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.entity;

/**
 *
 * @author SUMAN
 */
public class Review {
    
    private int id;
    private int userId;
    private String userName;
    private String movieName;
    private String review;
    private double ratings;
    private int reviewCount ;
    private double averageRating;

    public Review(int id, int userId, String userName, String movieName, String review, double ratings, int reviewCount, double averageRating) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.movieName = movieName;
        this.review = review;
        this.ratings = ratings;
        this.reviewCount = reviewCount;
        this.averageRating = averageRating;
    }

    public Review() {
    }

    @Override
    public String toString() {
        return "Review{" + "id=" + id + ", userId=" + userId + ", userName=" + userName + ", movieName=" + movieName + ", review=" + review + ", ratings=" + ratings + ", reviewCount=" + reviewCount + ", averageRating=" + averageRating + '}';
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    

    
}
