package com.ndduroc.rocmovies.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
// import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ndduroc.rocmovies.entities.Movie;
import com.ndduroc.rocmovies.entities.MovieStyles;

// import jakarta.annotation.PreDestroy;

@Service (value="service1")
@Profile("!PreProd")
@Primary
// @Scope("singleton")
public class MovieService1 implements IMovieService {

    /** 
     * Fournit une liste de films 'en dur' 
     * en attendant de pouvoir utiliser une base de données 
     * @return
     */
    private static List<Movie> getDefaultList()
    {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Cloud Atlas", MovieStyles.SF, 2012));
        movies.add(new Movie(2, "Shutter Island", MovieStyles.THRILLER, 2010));
        movies.add(new Movie(3, "Interstellar", MovieStyles.SF, 2018));
        movies.add(new Movie(4, "Pulp Fiction", MovieStyles.ACTION, 2001));
        movies.add(new Movie(5, "Mulholland Drive", MovieStyles.THRILLER, 2001));
        
        return movies;
    }
    private List<Movie> movieList;

    /** 
     * Liste complète de tous les films
     */
    @Override
    public List<Movie> getListMovies(){
        if (movieList == null)
        {
            movieList = getDefaultList();
        }
        return movieList;
    }


    @Override
    public Optional<Movie> getMovieById(long id){
        return getListMovies().stream().filter(m -> m.getIdMovie()==id).findFirst();
    }


    public MovieService1(){
        System.out.println("Création du service MovieService");
    }

    

    @Override
    public void addMovie(Movie movie) {

        getListMovies().add(movie);
    }
    
}
