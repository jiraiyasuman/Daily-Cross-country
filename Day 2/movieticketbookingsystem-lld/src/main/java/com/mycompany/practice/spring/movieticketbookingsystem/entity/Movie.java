/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.movieticketbookingsystem.entity;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author SUMAN Talukdar
 */
public class Movie {
    
    private int id;
    private String name;
    private String category;
    
    private LocalDate releaseDate;
    private List<Review> reviews;

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Movie(int id, String name, String category, LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.releaseDate = releaseDate;
    }

    

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", name=" + name + ", category=" + category + ", releaseDate=" + releaseDate + ", reviews=" + reviews + '}';
    }
    
    
}
