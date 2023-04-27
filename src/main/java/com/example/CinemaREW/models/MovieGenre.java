package com.example.CinemaREW.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="movie_genre")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //для будущей бд
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Movie movie;

    @OneToOne
    private Genre genre;

    public MovieGenre(Movie movie, Genre genre){
        this.movie = movie;
        this.genre = genre;
    }
}
