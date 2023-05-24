package com.example.CinemaREW.controllrs;

import com.example.CinemaREW.models.Movie;
import com.example.CinemaREW.models.User;
import com.example.CinemaREW.models.UserMovie;
import com.example.CinemaREW.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserMovieController {
    private final UserMovieService userMovieService;
    private final MovieService movieService;
    private  final UserService userService;
    private final MovieGenreService movieGenreService;
    private final MovieApiService movieApiService;

    @ModelAttribute("user")
    public User userForAll(Principal principal){
        if(principal==null) return null;
        return userService.getUserByEmail(principal.getName());
    }

    @GetMapping("/auth_home")
    public String AuthHome(@ModelAttribute("user") User user, Model model){
        return AuthHomePage(user,1,model);
    }

    @GetMapping("/auth_home/{currentPage}")
    public String AuthHomePage(@ModelAttribute("user") User user, @PathVariable("currentPage") int currentPage, Model model){

        Page<Movie> moviePage=movieService.getPage(currentPage);
        int totalPages=moviePage.getTotalPages();
        int totalItems= (int) moviePage.getTotalElements();
        List<Movie> movieList=moviePage.getContent();

        model.addAttribute("usermovie_list",user.getUserMovieList());
        model.addAttribute("movie_list", movieList);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("currentPage",currentPage);


        model.addAttribute("search_movie",new Movie());

        return "auth_home";
    }

    @GetMapping("/movie_info/{id}")
    public String movieInfo(@PathVariable Long id, Model model,@ModelAttribute("user") User user) {
        model.addAttribute("movie", movieService.getMovie(id));
        model.addAttribute("usermovie",new UserMovie());
        model.addAttribute("usermovie1", userMovieService.readUserMovie(user,movieService.getMovie(id)));
        return "movie_info";
    }

    @PostMapping("/movie _info/{id}/change_status")
    public String addMovieToUser(@PathVariable Long id,
                                 @ModelAttribute("usermovie") UserMovie userMovie,
                                 Principal principal){
        User user=userService.getUserByEmail(principal.getName());
        userMovie.setMovie(movieService.getMovie(id));
        userMovie.setUser(user);
        if(!userMovieService.isExist(userMovie)){
            userMovieService.createUserMovie(userMovie);
        }
        else if(userMovie.getStatus().equals("notadded")){
            userMovieService.deleteUserMovie(userMovie);
        }
        else userMovieService.updateUserMovie(userMovie);
        return "redirect:/movie_info/"+id;
    }

    @GetMapping("/account")
    public String AccountPage(@ModelAttribute("user") User user,Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("NAME",username);
        model.addAttribute("movie_list", user.getUserMovieList());
        model.addAttribute("search_movie",new Movie());
        return "account";
    }
    @GetMapping("/search/mylist")
    public String searchMovie(@ModelAttribute("search_movie") Movie movie, Model model){
        model.addAttribute("found_movie", userMovieService.searchUserMovieList(movie.getNameRu()));
        model.addAttribute("search_movie", new Movie());
        String s=movie.getNameRu();
        model.addAttribute("query", s);
        return "search_movie";
    }

}
