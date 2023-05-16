package com.example.CinemaREW.Reposits;

import com.example.CinemaREW.models.Genre;
import com.example.CinemaREW.models.Movie;
import com.example.CinemaREW.models.MovieGenre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MovieGenreRepository extends JpaRepository<Genre, Long>{
    List<MovieGenre> findAllByGenre(Genre genre);

    Page<MovieGenre> findAllByGenre(Genre genre, Pageable pageable);

    MovieGenre findMovieGenreByMovieAndGenre(Movie movie, Genre genre);
    @Transactional
    @Modifying
    @Query("update MovieGenre mg set mg.movie=:movie, mg.genre=:genre where mg.id=:id")
    void updateMovieGenre(Long id, Movie movie,Genre genre);

}
