package com.example.CinemaREW.services;


import com.example.CinemaREW.Reposits.GenreRepository;
import com.example.CinemaREW.Reposits.MovieRepository;
import com.example.CinemaREW.models.Movie;
import com.example.CinemaREW.models.MovieGenre;
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
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final ConfirmService confirmService;
    private final MovieGenreService movieGenreService;

    @Scheduled(fixedRate = 24*60*60*1000)
    @Async
    public void updateGenreTable(){
        //List<Genre> genreList=confirmService.getGenreListFromGenreDTOList();  - это должен быть как раз запрос с жанром
//        Genre genre;
//        for(int i=0;i<genreList.size();i++){
//            genre=genreRepository.findGenreById(genreList.get(i).getId());
//            if(genre==null) genreRepository.save(genreList.get(i));
//            else{
//                genreRepository.updateGenre(genre.getId(),genre.getName());
//            }
//        }
    }

    @Scheduled(fixedRate = 24*60*60*1000)
    @Scheduled(fixedDelay = 5000)
    public void updateAnimeTable() throws InterruptedException {
        int start = 1;
        int finish = 1034;
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
                            movie.getPosterUrl());
                    Movie movie1=movieList.get(i);
                    for(int j=0;j<movie1.getGenres().size();j++){
                        MovieGenre animeGenre=new MovieGenre(movie1,movie1.getGenres().get(j).getGenre());
                        // у нас банально нету moviegenrerepo
//                        MovieGenre animeGenre1=movieGenreRepository.findAnimeGenreByAnimeAndGenre(anime1,
//                                anime1.getAnimeGenres().get(j).getGenre());
//                        if(animeGenre1==null) animeGenreRepository.save(animeGenre);
//                        else animeGenreRepository.updateAnimeGenre(animeGenre1.getId(),animeGenre.getAnime(),animeGenre.getGenre());
                    }
                }
            }
            Thread.sleep(2000);
        }
    }
}
