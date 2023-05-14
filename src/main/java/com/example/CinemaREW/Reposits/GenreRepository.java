package com.example.CinemaREW.Reposits;

import com.example.CinemaREW.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findGenreByName(String genre_name);
    Genre findGenreById(Long id);

    @Transactional
    @Modifying
    @Query("update Genre g set g.name=:name where g.id=:id")
    void updateGenre(Long id,String name);
}
