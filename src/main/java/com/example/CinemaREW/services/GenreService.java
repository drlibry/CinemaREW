package com.example.CinemaREW.services;

import com.example.CinemaREW.Reposits.GenreRepository;
import com.example.CinemaREW.models.Genre;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Component
@RequiredArgsConstructor
public class GenreService {
    private GenreRepository genreRepository;
    int limit=20;

    public Genre getGenreByName(String genre_name){
        return genreRepository.findGenreByName(genre_name);
    }
    public List<Genre> getGenreList(){
        return genreRepository.findAll();
    }

}
