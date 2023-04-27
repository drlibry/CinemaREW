package com.example.CinemaREW.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="anime_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private int id;


    private int kinopoiskId;

    private String name;
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
