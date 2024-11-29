package com.ndduroc.rocmovies.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ndduroc.rocmovies.entities.Movie;
import com.ndduroc.rocmovies.entities.MovieStyles;

@SpringBootTest
public class MovieService1Test {

    @Autowired
    private MovieService1 movieService;

    @Test
    void testAddMovie() {

        int originalSize = movieService.getListMovies().size();

        Movie newMovie = new Movie(6, "Back in Black", MovieStyles.DRAME, 2024, "UK-575952");
        movieService.addMovie(newMovie);

        int newSize = movieService.getListMovies().size();

        assertTrue(newSize == originalSize + 1);

        movieService.getListMovies().remove(newMovie);
    }
}