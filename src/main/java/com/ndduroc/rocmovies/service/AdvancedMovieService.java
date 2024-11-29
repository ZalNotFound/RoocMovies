package com.ndduroc.rocmovies.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ndduroc.rocmovies.entities.Movie;
import com.ndduroc.rocmovies.entities.MovieStyles;

@Component
public class AdvancedMovieService implements IMovieService {

    /** Méthode spécifique */
    public List<Movie> getActionMovies() {
        List<Movie> list = movieService.getListMovies().stream().filter(p -> p.getStyle() == MovieStyles.ACTION)
                .collect(Collectors.toList());
        return list;
    }

    public List<Movie> getMoviesBetween(int year1, int year2) {
        List<Movie> list = movieService.getListMovies().stream().filter(p -> p.getProductionYear() >= year1 && p.getProductionYear() <= year2)
                .collect(Collectors.toList());
        return list;
    }

    @Autowired
    private MovieService1 movieService;

    // Les méthodes suivantes sont simplement des appels au service "proxyfié"
    @Override
    public List<Movie> getListMovies() {
        return movieService.getListMovies();
    }

    @Override
    public Optional<Movie> getMovieById(long id) {

        return movieService.getMovieById(id);
    }

    @Override
    public void addMovie(Movie movie) {

        movieService.addMovie(movie);

    }

}
