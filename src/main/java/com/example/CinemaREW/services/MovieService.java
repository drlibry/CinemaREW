package com.example.CinemaREW.services;

import com.example.CinemaREW.Reposits.MovieRepository;
import com.example.CinemaREW.models.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private List<Movie> movies = new ArrayList<>();


    public List<Movie> listMovies(String s){
        List<Movie> movieList = movieRepository.findAll();
        movieList = movieRepository.findAll().stream()
                .filter(movie -> movie.getNameRu().toLowerCase().contains(s.toLowerCase())).toList();
        return movieList;
    }


}
