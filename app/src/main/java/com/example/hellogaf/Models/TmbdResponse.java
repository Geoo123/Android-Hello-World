package com.example.hellogaf.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TmbdResponse {

    @SerializedName("results")
    List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}