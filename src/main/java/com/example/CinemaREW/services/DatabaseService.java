package com.example.CinemaREW.services;


import com.example.CinemaREW.Reposits.*;
import com.example.CinemaREW.models.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Component
@RequiredArgsConstructor
public class DatabaseService {
    private MovieRepository movieRepository;
    private GenreRepository genreRepository;
    private CountryRepository countryRepository;
    private ConfirmService confirmService;
    private MovieGenreService movieGenreService;
    private MovieCountryRepository movieCountryRepository;
    private MovieGenreRepository movieGenreRepository;

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    @Async
    public void updateGenreTable() {
        List<Genre> genreList = confirmService.getGenreListFromGenreDTOList();
        Genre genre;
        for (int i = 0; i < genreList.size(); i++) {
            genre = genreRepository.findGenreById(genreList.get(i).getId());
            if (genre == null) genreRepository.save(genreList.get(i));
            else {
                genreRepository.updateGenre(genre.getId(), genre.getName());
            }
        }
    }

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    @Async
    public void updateCountryTable() {
        List<Country> countryList = confirmService.getCountryListFromCountryDTOList();
        Country country;
        for (int i = 0; i < countryList.size(); i++) {
            country = countryRepository.findCountryById(countryList.get(i).getId());
            if (country == null) countryRepository.save(countryList.get(i));
            else {
                countryRepository.updateCountry(country.getId(), country.getName());
            }
        }
    }


    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    @Scheduled(fixedDelay = 5000)
    public void updateMovieTable() throws InterruptedException {
        int start = 1;
        int finish = 1034;//????
        for (int page = start; page <= finish; page++) {
            List<Movie> movieList = confirmService.getCinemaListFromCinemaDTOList(page);
            Movie movie;
            for (int i = 0; i < movieList.size(); i++) {
                movie = movieRepository.findMovieById(movieList.get(i).getKinopoiskId());
                if (movie == null) movieRepository.save(movieList.get(i));
                else {
                    movieRepository.updateMovie(movie.getKinopoiskId(),
                            movie.getNameRu(),
                            movie.getNameOriginal(),
                            movie.getRatingKinopoisk(),
                            movie.getRatingImdb(),
                            movie.getYear(),
                            movie.getPosterUrl(),
                            movie.getDescription());
                    Movie movie1 = movieList.get(i);

                    for (int j = 0; j < movie1.getGenres().size(); j++) {
                        MovieGenre movieGenre = new MovieGenre(movie1, movie1.getGenres().get(j).getGenre());
                        MovieGenre movieGenre1 = movieGenreRepository.findMovieGenreByMovieAndGenre(movie1,
                                movie1.getGenres().get(j).getGenre());
                        if(movieGenre1==null) movieGenreRepository.save(movieGenre);
                        else movieGenreRepository.updateMovieGenre(movieGenre1.getId(),movieGenre.getMovie(),movieGenre.getGenre());
                    }

                    for (int j = 0; j < movie1.getCountries().size(); j++) {
                        MovieCountry movieCountry = new MovieCountry(movie1, movie1.getCountries().get(j).getCountry());
                        MovieCountry movieCountry1 = movieCountryRepository.findMovieCountryByMovieAndCountry(movie1,
                                movie1.getCountries().get(j).getCountry());
                        if(movieCountry1==null) movieCountryRepository.save(movieCountry);
                        else movieCountryRepository.updateMovieCountry(movieCountry1.getId(),movieCountry.getMovie(),movieCountry.getCountry());
                    }
                    //как-то обновить description
                    MovieDescription movieDescription = new MovieDescription(movie1, movie1.getDescription());




                }
                Thread.sleep(2000);
            }
        }
    }
}
