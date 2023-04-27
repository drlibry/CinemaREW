package com.example.CinemaREW.controllrs;
import com.example.CinemaREW.services.CinemaApiService;
import com.example.CinemaREW.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//контролирует обращение пользователей к приложению
@Controller
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/")//при переходе на локальный хост вызывается этот метод
    public String films(Model model) //главная страница где будут отображаться фильмы
    {
//        model.addAttribute("films", )
        return "films";
    }
}
