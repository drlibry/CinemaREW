package com.example.CinemaREW.services;

import com.example.CinemaREW.models.Movie;
import com.example.CinemaREW.Reposits.MovieRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Component
//@RequiredArgsConstructor

public class MovieService {
    private MovieRepository movieRepository;
    private List<Movie> movieList = new ArrayList<>();

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovie(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public  List<Movie> searchMovieList(String s) {
        movieList = movieRepository.findAll().stream()
                .filter(anime -> anime.getNameRu().toLowerCase().contains(s.toLowerCase())).toList();
        return movieList;
    }

    public Page<Movie> getPage(int p){
        Pageable pageable= PageRequest.of(p,20);
        return movieRepository.findAll(pageable);
    }


}
