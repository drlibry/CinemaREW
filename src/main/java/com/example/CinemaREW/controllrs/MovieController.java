package com.example.CinemaREW.controllrs;
import com.example.CinemaREW.models.Movie;
import com.example.CinemaREW.models.MovieGenre;
//import com.example.CinemaREW.models.User;
import com.example.CinemaREW.services.GenreService;
import com.example.CinemaREW.services.MovieGenreService;
import com.example.CinemaREW.services.MovieService;
//import com.example.CinemaREW.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

//контролирует обращение пользователей к приложению
@Controller
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final MovieGenreService movieGenreService;
    private final GenreService genreService;
    //private final UserService userService;

//    @ModelAttribute("user")
//    public User userForAll(Principal principal){
//        if(principal==null) return null;
//        return userService.getUserByEmail(principal.getName());
//    }

    @GetMapping("/search")
    public String searchMovie(@ModelAttribute("search_movie") Movie movie, Model model) {
        model.addAttribute("found_movie", movieService.searchMovieList(movie.getNameRu()));
        model.addAttribute("search_movie", new Movie());
        String s =movie.getNameRu();
        model.addAttribute("query", s);
        return "search_movie";
    }

    @GetMapping("/search/{genre_name}")
    public String searchMovie(@ModelAttribute("search_movie") Movie movie, @PathVariable("genre_name") String genre_name, Model model){
        model.addAttribute("found_movie", movieGenreService.getMovieGenreListByMovieAndGenre(movie.getNameRu(),genre_name));
        model.addAttribute("search_movie", new Movie());
        String s=movie.getNameRu();
        model.addAttribute("query", s);
        model.addAttribute("genre_name", genre_name);
        return "search_movie";
    }

//    @GetMapping("/genres")
//    public String Genre(@ModelAttribute("user") User user, Model model){
//        model.addAttribute("genreList",genreService.getGenreList());
//        if(user!=null) model.addAttribute("usermovieList", user.getUserMovieList());
//        model.addAttribute("search_movie", new Movie());
//        return "genres";
//    }
//
//    @GetMapping("/genres/{genre_name}")
//    public String genreMovie(@ModelAttribute("user") User user,@PathVariable("genre_name") String genre_name,Model model){
//        return genreMoviePage(user,genre_name,1,model);
//    }

//    @GetMapping("/genres/{genre_name}/{currentPage}")
//    public String genreMoviePage(@ModelAttribute("user") User user,@PathVariable("genre_name") String genre_name,
//                                 @PathVariable("currentPage") int currentPage,Model model){
//
//        Page<MovieGenre> movieGenrePage=movieGenreService.getMovieGenreListByGenreNamePage(genre_name,currentPage);
//        List<MovieGenre> movieGenreList=movieGenrePage.getContent();
//        int totalItems= (int) movieGenrePage.getTotalElements();
//        int totalPages=movieGenrePage.getTotalPages();
//
//        model.addAttribute("moviegenreList",movieGenreList);
//        model.addAttribute("totalItems",totalItems);
//        model.addAttribute("totalPages",totalPages);
//        model.addAttribute("currentPage",currentPage);
//
//        if(user!=null) model.addAttribute("usermovieList",user.getUserMovieList());
//        model.addAttribute("genre_name", genre_name);
//        model.addAttribute("search_movie",new Movie());
//        return "genres_movie";
//    }

}
