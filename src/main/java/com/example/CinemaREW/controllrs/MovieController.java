package com.example.CinemaREW.controllrs;
import com.example.CinemaREW.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

//контролирует обращение пользователей к приложению
@Controller
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
//    @GetMapping("/search")
//    public String searchAnime(@ModelAttribute("search_anime") Movie movie, Model model) {
//        model.addAttribute("found_movie", movieService.listMovies(movie.getNameRu()));
//        model.addAttribute("search_movie", new Movie());
//        String s = movie.getNameRu();
//        model.addAttribute("query", s);
//        return "search_movie";
//    }

//    @GetMapping("/")//при переходе на локальный хост вызывается этот метод
//    public String films(Model model) //главная страница где будут отображаться фильмы
//    {
////        model.addAttribute("films", )
//        return "films";
//    }

}
