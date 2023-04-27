package com.example.CinemaREW.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaDTO {
   private int kinopoiskId;
   private String nameRu;
   private String nameOriginal;
   private List<CountryDTO> countries;
   private List<GenreDTO> genres;
   private float ratingKinopoisk;
   private float ratingImdb;
   private int year;
   private String posterUrl;
   private String description;

}
