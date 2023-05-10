package com.example.CinemaREW.controllrs;

import com.example.CinemaREW.models.Movie;
import com.example.CinemaREW.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomePageController {

    //private final UserService userService;
    private final MovieService movieService;

    @GetMapping("/")
    public String Home(Principal principal, Model model){
        return HomePage(principal,1,model);
    }

    @GetMapping("/home/{currentPage}")
    public String HomePage(Principal principal, @PathVariable("currentPage") int currentPage, Model model) {
        //databaseService.updateAnimeGenreTable();
        Page<Movie> moviePage=movieService.getPage(currentPage);
        int totalPages=moviePage.getTotalPages();
        int totalItems= (int) moviePage.getTotalElements();
        List<Movie> movieList=moviePage.getContent();

        model.addAttribute("movie_list",movieList);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("currentPage",currentPage);

        model.addAttribute("search_anime",new Movie());
        return "home";
    }
}
