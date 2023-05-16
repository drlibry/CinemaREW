package com.example.CinemaREW.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreCountryDTO {
    private List<CountryDTO> countries;
    private List<GenreDTO> genres;
}
