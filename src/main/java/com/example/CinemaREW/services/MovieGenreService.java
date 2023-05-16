package com.example.CinemaREW.services;

import com.example.CinemaREW.Reposits.GenreRepository;
import com.example.CinemaREW.Reposits.MovieGenreRepository;
import com.example.CinemaREW.models.Genre;
import com.example.CinemaREW.models.Movie;
import com.example.CinemaREW.models.MovieGenre;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Component
@RequiredArgsConstructor
public class MovieGenreService {
    private MovieGenreRepository movieGenreRepository;
    private GenreRepository genreRepository;


    public List<MovieGenre> getMovieGenreListByMovieAndGenre(String movieTitle, String genreName){
        List<MovieGenre> movieGenreList;
        movieGenreList=movieGenreRepository.findAll().stream().filter(movieGenre ->
                movieGenre.getGenre().getName().toLowerCase().equals(genreName.toLowerCase()) &&
                        movieGenre.getMovie().getNameRu().toLowerCase().contains(movieTitle.toLowerCase())).toList();
        return movieGenreList;
    }

    public Page<MovieGenre> getMovieGenreListByGenreNamePage(String genre_name, int p){
        Pageable pageable= PageRequest.of(p,20);//вроде у нас 20
        Genre genre=genreRepository.findGenreByName(genre_name);
        return movieGenreRepository.findAllByGenre(genre, pageable);
    }



}
