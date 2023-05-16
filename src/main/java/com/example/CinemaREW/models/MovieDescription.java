package com.example.CinemaREW.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="movie_description")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Movie movie;


    private String description;

    public MovieDescription(Movie movie, String description){
        this.movie = movie;
        this.description = description;
    }
}
