package com.ndduroc.rocmovies.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ndduroc.rocmovies.entities.Movie;
import com.ndduroc.rocmovies.entities.MovieStyles;

// import jakarta.annotation.PreDestroy;

@Service (value="service2")
@Profile("PreProd")
public class MovieService2 implements IMovieService {

    /** 
     * Fournit une liste de films 'en dur' 
     * en attendant de pouvoir utiliser une base de données 
     * @return
     */
    private static List<Movie> getDefaultList()
    {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Film 1", MovieStyles.SF, 2000, "TES-147963"));
        movies.add(new Movie(2, "Film 2", MovieStyles.THRILLER, 2001, "TES-741963"));
        movies.add(new Movie(3, "Film 3", MovieStyles.SF, 2002, "TES-741369"));
        movies.add(new Movie(4, "Film 4", MovieStyles.ACTION, 2003, "TES-147369"));
        movies.add(new Movie(5, "Film 5", MovieStyles.THRILLER, 2004, "TES-159753"));
        
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


    public MovieService2(){
        System.out.println("Création du service MovieService");
    }

    

    @Override
    public void addMovie(Movie movie) {

        getListMovies().add(movie);
    }
    
}
