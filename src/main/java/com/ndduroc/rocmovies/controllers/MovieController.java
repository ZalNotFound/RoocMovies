package com.ndduroc.rocmovies.controllers;

import com.ndduroc.rocmovies.entities.Movie;
import com.ndduroc.rocmovies.entities.MovieStyles;
import com.ndduroc.rocmovies.service.MovieService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController()
@RequestMapping("movie")

public class MovieController {
    private MovieService movieService = new MovieService();
    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable("id") int movieId) {
        return movieService.getMovieById(movieId);
    }

    @GetMapping()
    public List<Movie> getListMovies(@RequestParam (name="style") Optional<MovieStyles> style) {
        List<Movie> movies = movieService.getListMovies();
        if (style.isPresent()) {
            movies.removeIf(m -> !m.getStyle().equals(style.get()));
        }

        return movies;
    }

    @PostMapping()
    public void addMovie(@RequestBody Movie newMovie) {
        //TODO: process POST request
        movieService.addMovie(newMovie);
        
    }
    
    
}
    