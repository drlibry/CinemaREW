package com.example.CinemaREW.Reposits;

import com.example.CinemaREW.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findCountryByName(String country_name);
    Country findCountryById(Long id);

    @Transactional
    @Modifying
    @Query("update Country c set c.name=:name where c.id=:id")
    void updateCountry(Long id,String name);
}
