package com.example.CinemaREW.Reposits;

import com.example.CinemaREW.models.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MovieCountryRepository extends JpaRepository<Country, Long> {
    List<MovieCountry> findAllByCountry(Country country);

    Page<MovieCountry> findAllByCountry(Country country, Pageable pageable);

    MovieCountry findMovieCountryByMovieAndCountry(Movie movie, Country country);
    @Transactional
    @Modifying
    @Query("update MovieCountry mc set mc.movie=:movie, mc.country=:country where mc.id=:id")
    void updateMovieCountry(Long id, Movie movie,Country country);

}
