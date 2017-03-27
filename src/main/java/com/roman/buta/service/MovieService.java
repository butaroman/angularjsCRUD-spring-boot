package com.roman.buta.service;

import com.roman.buta.model.Movie;
import java.util.List;

public interface MovieService {

    Movie addMovie(Movie movie);

    Movie findById(int id);

    List<Movie> findAll();

    boolean deleteMovie(int movieId);
}
