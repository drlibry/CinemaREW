package com.example.CinemaREW.services;

import com.example.CinemaREW.DTO.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@Service
public class MovieApiService {
    private final WebClient webClient;

    public MovieApiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<CinemaDTO> getCinemaList(int page) {
        CinemaSearchResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v2.2/films").queryParam("order", "RATING")
                        .queryParam("type", "ALL")
                        .queryParam("ratingFrom", 0)
                        .queryParam("ratingTo", 10)
                        .queryParam("yearFrom", 1000)
                        .queryParam("yearTo", 3000)
                        .queryParam("page", page)
                        .build()).retrieve()
                .bodyToMono(CinemaSearchResponse.class).block();

        return response.getData();
    }

    public CinemaDTO getFilmById(int kinopoiskId){
        CinemaResponse response=webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v2.2/films")
                        .queryParam("id",kinopoiskId)
                        .build()).retrieve()
                .bodyToMono(CinemaResponse.class).block();
        return response.getData();
    }

    public GenreCountryDTO getIDofGenreAndCountry(){//int page
        GenreCountryResponse response=webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v2.2/films/filters")
                        ///.queryParam("page",page)
                        .build()).retrieve()
                .bodyToMono(GenreCountryResponse.class).block();
        return response.getData();
    }

//    public List<GenreDTO> getGenreList(int limit){
//        CinemaGenresResponse response = webClient.get()
//                .uri(uriBuilder -> uriBuilder.path("/genres/anime").queryParam("limit",limit).build()).retrieve()
//                .bodyToMono(CinemaGenresResponse.class).block();
//
//        return response.getData();
//    }
}