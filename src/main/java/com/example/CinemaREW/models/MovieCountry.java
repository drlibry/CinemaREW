package com.example.CinemaREW.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="movie_country")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Movie movie;

    @OneToOne
    private Country country;

    public MovieCountry(Movie movie, Country country){
        this.movie = movie;
        this.country = country;
    }
}
