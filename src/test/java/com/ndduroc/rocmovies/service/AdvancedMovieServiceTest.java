package com.ndduroc.rocmovies.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ndduroc.rocmovies.entities.Movie;
import com.ndduroc.rocmovies.entities.MovieStyles;

@ExtendWith(MockitoExtension.class)
public class AdvancedMovieServiceTest {

    @Mock
    private MovieService1 movieService;

    @InjectMocks
    private AdvancedMovieService advancedMovieService;


    @Test
    void testGetMoviesBetween() {
        List<Movie> fakeList = new ArrayList<>();
        fakeList.add(new Movie(1, "Film 1", MovieStyles.SF, 2012, "USA-123456"));
        fakeList.add(new Movie(2, "Film 2", MovieStyles.THRILLER, 2010, "USA-654321"));
        fakeList.add(new Movie(3, "Film 3", MovieStyles.SF, 2018, "UK-123456"));
        fakeList.add(new Movie(4, "Film 4", MovieStyles.ACTION, 2001, "USA-456321"));

        when(movieService.getListMovies()).thenReturn(fakeList);

        assertTrue(advancedMovieService.getMoviesBetween(2010, 2018).size() == 3);
    }
}


