package com.ndduroc.rocmovies.controllers;

import com.ndduroc.rocmovies.entities.Movie;
import com.ndduroc.rocmovies.entities.MovieStyles;
import com.ndduroc.rocmovies.service.IMovieService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller()
@RequestMapping("home/movie")

public class MovieController {

    @Autowired
    // @Qualifier("service2")
    private IMovieService movieService;
    
    @GetMapping("/{id}")
    public String getMovieById(@PathVariable("id") int movieId, Model model) {
        Optional<Movie> movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie.get());
        model.addAttribute("sourceImg", movieId + "-affiche-film.jpg");
        return "movie.html";
    }

    @GetMapping()
    public String getListMovies(@RequestParam (name="style") Optional<MovieStyles> style, Model model) {
        List<Movie> movies = movieService.getListMovies();
        if (style.isPresent()) {
            // movies.removeIf(m -> !m.getStyle().equals(style.get()));
            movies = movies.stream().filter(m->m.getStyle().equals(style.get())).collect(Collectors.toList());
            
        }

        model.addAttribute("prenom", "Guest");
        model.addAttribute("movies", movies);

        return "home.html";
    }

    @PostMapping()
    public void addMovie(@RequestBody Movie newMovie) {

        movieService.addMovie(newMovie);

    }
    
    
}
    