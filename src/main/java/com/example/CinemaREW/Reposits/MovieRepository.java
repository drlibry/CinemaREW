package com.example.CinemaREW.Reposits;

import com.example.CinemaREW.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAll();


}
