package com.example.CinemaREW.models;

import com.example.CinemaREW.DTO.CountryDTO;
import com.example.CinemaREW.DTO.GenreDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="movie_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "kinopoiskId")
    private int kinopoiskId;

    @Column(name = "nameRu")
    private String nameRu;

    @Column(name = "nameOriginal")
    private String nameOriginal;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REFRESH)//&&&&&
    private List<MovieCountry> countries;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REFRESH)//????????????????/
    private List<MovieGenre> genres;

    @Column(name = "ratingKinopoisk")
    private float ratingKinopoisk;

    @Column(name = "ratingImdb")
    private float ratingImdb;

    @Column(name = "year")
    private int year;

    @Column(name = "posterUrl")
    private String posterUrl;

    @Column(name = "description", columnDefinition = "text")
    private String description;
     public Movie(Long id,
                  int kinopoiskId,
                  String nameRu,
                  String nameOriginal,
                  List<MovieCountry> countries,
                  List<MovieGenre> genres,
                  float ratingImdb,
                  int year,
                  String posterUrl,
                  String description){
         this.id = id;
         this.kinopoiskId = kinopoiskId;
         this.nameRu = nameRu;
         this.nameOriginal = nameOriginal;
         this.countries = countries;
         this.genres = genres;
         this.ratingImdb = ratingImdb;
         this.year = year;
         this.posterUrl= posterUrl;
         this.description =description ;
     }



}
