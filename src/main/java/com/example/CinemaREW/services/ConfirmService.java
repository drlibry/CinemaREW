package com.example.CinemaREW.services;

import com.example.CinemaREW.DTO.CinemaDTO;
import com.example.CinemaREW.Reposits.CountryRepository;
import com.example.CinemaREW.Reposits.GenreRepository;
import com.example.CinemaREW.models.Movie;
import com.example.CinemaREW.models.MovieCountry;
import com.example.CinemaREW.models.MovieGenre;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
@Component
@RequiredArgsConstructor
public class ConfirmService {
    private final MovieApiService movieApiService;
    public final MovieGenreService movieGenreService;
    public GenreRepository genreRepository;
    public CountryRepository countryRepository;


    public Movie getCinemaFromCinemaDTO(CinemaDTO cinemaDTO){
        Movie movie=new Movie(
                cinemaDTO.getKinopoiskId(),
                cinemaDTO.getNameRu(),
                cinemaDTO.getNameOriginal(),
                cinemaDTO.getRatingKinopoisk(),
                cinemaDTO.getRatingImdb(),
                cinemaDTO.getYear(),
                cinemaDTO.getPosterUrl());
        List<MovieGenre> movieGenreList=new ArrayList<>();
        for(int i=0;i<cinemaDTO.getGenres().size();i++){
            movieGenreList.add(new MovieGenre(movie,genreRepository.findGenreByName(cinemaDTO.getGenres().get(i).getGenre())));
        }
        movie.setGenres(movieGenreList);
        List<MovieCountry> movieCountryList = new ArrayList<>();
        for(int i=0;i<cinemaDTO.getCountries().size();i++){
            movieCountryList.add(new MovieCountry(movie, countryRepository.findCountryByName(cinemaDTO.getCountries().get(i).getCountry())));
        }
        movie.setCountries(movieCountryList);
        CinemaDTO cDTO= movieApiService.getFilmById(cinemaDTO.getKinopoiskId());//не уверена, что это правильно
        movie.setDescription(cDTO.getDescription());//не уверена, что это правильно
        return movie;
    }

    public List<Movie> getCinemaListFromCinemaDTOList(int page){
        List<CinemaDTO> cinemaDTOList = movieApiService.getCinemaList(page);
        List<Movie> movieList=new ArrayList<>();
        for(int i=0;i<cinemaDTOList.size();i++){
            movieList.add(getCinemaFromCinemaDTO(cinemaDTOList.get(i)));
        }
        return movieList;
    }
    public List<Movie> getCinemaListByGenreFromGenreCountryDTO(int page, String s){
        List<CinemaDTO> cinemaDTOList = movieApiService.getCinemaList(page);
        List<Movie> movieList=new ArrayList<>();
        for(int i=0;i<cinemaDTOList.size();i++){
            for(int j=0; j<cinemaDTOList.get(i).getGenres().size();j++)
            {
                if(s==cinemaDTOList.get(i).getGenres().get(j).getGenre()){
                    movieList.add(getCinemaFromCinemaDTO(cinemaDTOList.get(i)));
                }
            }
        }
        return movieList;

    }


}
