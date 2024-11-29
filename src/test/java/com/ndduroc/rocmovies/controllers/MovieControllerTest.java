package com.ndduroc.rocmovies.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.ndduroc.rocmovies.entities.Movie;
import com.ndduroc.rocmovies.entities.MovieStyles;
import com.ndduroc.rocmovies.service.MovieService1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHomePageNotEmpty() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }

    @Autowired
    private MovieService1 movieService;
    @Autowired
    private MovieController movieController;


    @Test
    void testAddMovie() throws Exception{

        Movie newMovie = new Movie(6, "Back in Black", MovieStyles.DRAME, 2024, "UK-575952");
        movieController.addMovie(newMovie);

        String uriTemplate = "/home/movie/" + newMovie.getIdMovie();

        mockMvc.perform(get(uriTemplate))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));

        movieService.getListMovies().remove(newMovie);
    }
}
