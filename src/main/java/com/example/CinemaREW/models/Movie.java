package com.example.CinemaREW.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
    private String name;
    private int id;
    private float ratingKP;
    private float ratingIMDB;
    private int year;
    private String [] countries;
    private String slogan;
    private String [] actors;
    private String [] genres;
    private String premiere;
    private String description;



}
