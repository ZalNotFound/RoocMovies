package com.ndduroc.rocmovies.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Movie {

    public Movie(int idMovie, String title, MovieStyles style, int productionYear, String reference) {
        this.idMovie = idMovie;
        this.title = title;
        this.style = style;
        this.productionYear = productionYear;
        this.reference = reference;
    }

    @NotNull   
    private Integer idMovie;

    @NotBlank
    @Size(max=100, message="Le titre ne doit pas contenir plus de 100 caractères")
    private String title;

    @NotNull
    private MovieStyles style;
    
    @NotNull
    private Integer productionYear;

    @NotBlank
    @Pattern(regexp = "^[A-Z]{2-3}-\\d{6}$", message="Le format de référence doit être 'XX-YYYYYYYY'")
    private String reference;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieStyles getStyle() {
        return style;
    }

    public void setStyle(MovieStyles style) {
        this.style = style;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }
    
    
    
    
}
