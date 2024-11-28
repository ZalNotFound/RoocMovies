package com.ndduroc.rocmovies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ndduroc.rocmovies.service.IMovieService;


@Controller
public class HomeController {

    @Autowired
    private IMovieService movieService;
    
    @RequestMapping(value = {"", "/", "/home"})
    public String displayHomePage(Model model) {

        model.addAttribute("prenom", "Guest");
        model.addAttribute("movies", movieService.getListMovies());
    
        return "home.html";
    }

}
