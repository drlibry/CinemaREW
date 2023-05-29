package com.example.CinemaREW.services;

import com.example.CinemaREW.DTO.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@Service
public class MovieApiService {
    private WebClient webClient;

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
                        .build())
                .header("X-API-KEY","ace706e7-1540-4e4d-b15e-080bf6619b6e").retrieve()
                .bodyToMono(CinemaSearchResponse.class).block();
        System.out.println("HELLOOOOOOOOOOO");

        return response.getData();
    }

    public CinemaDTO getFilmById(int kinopoiskId){
        CinemaResponse response=webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v2.2/films")
                        .queryParam("id",kinopoiskId)
                        .build())
                .header("X-API-KEY","ace706e7-1540-4e4d-b15e-080bf6619b6e").retrieve()
                .bodyToMono(CinemaResponse.class).block();
        return response.getData();
    }

    public GenreCountryDTO getIDofGenreAndCountry(){//int page
        GenreCountryResponse response=webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v2.2/films/filters")
                        ///.queryParam("page",page)
                        .build())
                .header("X-API-KEY","ace706e7-1540-4e4d-b15e-080bf6619b6e").retrieve()
                .bodyToMono(GenreCountryResponse.class).block();
        return response.getData();
    }
}