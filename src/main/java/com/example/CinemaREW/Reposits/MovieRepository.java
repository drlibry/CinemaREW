package com.example.CinemaREW.Reposits;

import com.example.CinemaREW.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAll();

    Movie findMovieByKinopoiskId(int kinopoiskId);


    //обновление бд
    @Transactional
    @Modifying
    @Query("update Movie a set a.nameRu=:nameRu," +
            "a.nameOriginal=:nameOriginal," +
            "a.ratingKinopoisk=:ratingKinopoisk," +
            "a.ratingImdb=:ratingImdb," +
            "a.year=:year," +
            "a.posterUrl=:posterUrl," +
            "a.description=:description where a.kinopoiskId=:kinopoiskId")
    void updateMovie(int kinopoiskId,
                     String nameRu,
                     String nameOriginal,
                     float ratingKinopoisk,
                     float ratingImdb,
                     int year,
                     String posterUrl,
                     String description);
}
