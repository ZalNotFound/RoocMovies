package com.ndduroc.rocmovies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ndduroc.rocmovies.service.IMovieService;


@Controller
public class MovieByIdController {

    @Autowired
    private IMovieService movieService;
    
    @RequestMapping(value = "/home/movie/{id}")
    public String displayMoviePage(@PathVariable("id") int movieId, Model model) {

        model.addAttribute("prenom", "Guest");
        model.addAttribute("movie", movieService.getMovieById(movieId));

        return "movie.html";
    }

}
