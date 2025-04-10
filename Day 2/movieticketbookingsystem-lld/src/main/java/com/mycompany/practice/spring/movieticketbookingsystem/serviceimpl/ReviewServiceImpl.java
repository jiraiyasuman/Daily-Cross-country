/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.serviceimpl;

import com.mycompany.practice.spring.movieticketbookingsystem.entity.Review;
import com.mycompany.practice.spring.movieticketbookingsystem.repository.ReviewRepository;
import com.mycompany.practice.spring.movieticketbookingsystem.service.ReviewService;
import java.util.logging.Logger;

/**
 *
 * @author SUMAN
 */
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository reviewRepository;
    private Logger LOGGER = Logger.getLogger(getClass().getName());
    @Override
    public boolean addReviews(Review review) {
    
        boolean status=false;
        try {
            boolean temp = reviewRepository.addReviews(review);
            status =true;
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public void displayList() {
      reviewRepository.displayAllReviews();
    }
    
}
