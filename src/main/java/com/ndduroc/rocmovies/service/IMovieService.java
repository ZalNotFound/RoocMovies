package com.ndduroc.rocmovies.service;

import java.util.List;
import java.util.Optional;

import com.ndduroc.rocmovies.entities.Movie;

public interface IMovieService {

    /** 
     * Liste complète de tous les films
     */
    List<Movie> getListMovies();

    Optional<Movie> getMovieById(long id);

    void addMovie(Movie movie);

}