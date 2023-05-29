package com.example.CinemaREW.controllrs;

import com.example.CinemaREW.models.Movie;
//import com.example.CinemaREW.models.User;
import com.example.CinemaREW.services.MovieService;
//import com.example.CinemaREW.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
public class HomePageController {

    //private final UserService userService;
    private final MovieService movieService;

    @GetMapping("/")
    public String Home(Principal principal, Model model){
        System.out.println("HELLOOOOOOOOOOOHOME");
        return HomePage(principal,1,model);
    }

    @GetMapping("/home/{currentPage}")
    public String HomePage(Principal principal, @PathVariable("currentPage") int currentPage, Model model) {
        //databaseService.updateMovieGenreTable();
        //databaseService.updateMovieCountryTable();
        System.out.println("HELLOOOOOOOOOOOHOMEPAGE");
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
    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//        return "registration";
//    }
//    @PostMapping("/registration")
//    public String createUser(@ModelAttribute("userForm") User user, Model model) {
//        if (!userService.createUser(user)) {
//            model.addAttribute("errorMessage", "Пользователь с email " + user.getEmail() + " уже существует");
//            return "registration";
//        }
//        return "redirect:/login";
//    }


}
