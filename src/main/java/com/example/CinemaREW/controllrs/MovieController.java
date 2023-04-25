package com.example.CinemaREW.controllrs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//контролирует обращение пользователей к приложению
@Controller
public class MovieController {
    @GetMapping("/")//при переходе на локальный хост вызывается этот метод
    public String films() //главная страница где будут отображаться фильмы
    {
        return "films";
    }
}
