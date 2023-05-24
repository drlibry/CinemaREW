package com.example.CinemaREW.services;

import com.example.CinemaREW.Reposits.UserMovieRepository;
import com.example.CinemaREW.models.Movie;
import com.example.CinemaREW.models.User;
import com.example.CinemaREW.models.UserMovie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Component
@RequiredArgsConstructor
public class UserMovieService {
    private UserMovieRepository userMovieRepository;

    public void createUserMovie(UserMovie userMovie){
        userMovie.getUser().getUserMovieList().add(userMovie);
        userMovieRepository.save(userMovie);
        log.info("User with id="+userMovie.getUser().getId()+" added movie with id="+userMovie.getMovie().getKinopoiskId()+" (status="+userMovie.getStatus()+")");
    }

    public UserMovie readUserMovie(User user, Movie movie){
        return userMovieRepository.findByUserAndMovie(user,movie);
    }
    public void updateUserMovie(UserMovie userMovie){
        UserMovie userMovie1=userMovie.getUser().getUserMovieList().stream()
                .filter(userMovie2 -> userMovie2.getMovie().equals(userMovie.getMovie()))
                .findAny().get();
        userMovie.getUser().getUserMovieList().remove(userMovie1);
        userMovieRepository.delete(userMovie1);
        userMovie.getUser().getUserMovieList().add(userMovie);
        userMovieRepository.save(userMovie);
        log.info("User with id="+userMovie.getUser().getId()+" updated movie with id="+userMovie.getMovie().getKinopoiskId()+"(status = "+userMovie.getStatus()+")");
    }

    public boolean isExist(UserMovie userMovie){
        if(userMovieRepository.existsByUserAndMovie(userMovie.getUser(),userMovie.getMovie())) return true;
        return false;
    }

    public void deleteUserMovie(UserMovie userMovie){
        if(isExist(userMovie)){
            userMovie.getUser().getUserMovieList().remove(userMovie);
            userMovieRepository.deleteByUserAndMovie(userMovie.getUser(),userMovie.getMovie());
            log.info("User with id="+userMovie.getUser().getId()+" deleted movie with id="+userMovie.getMovie().getKinopoiskId());
        }
    }

    public List<UserMovie> searchUserMovieList(String title) {
        return userMovieRepository.findAll().stream().filter(userMovie-> userMovie.getMovie().getNameRu().toLowerCase().contains(title.toLowerCase())).toList();
    }

}
