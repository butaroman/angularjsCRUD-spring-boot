package com.roman.buta.service;

import com.roman.buta.model.Movie;
import com.roman.buta.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.saveAndFlush(movie);
    }

    @Override
    public Movie findById(int id) {
        return movieRepository.findOne(id);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public boolean deleteMovie(int movieId) {
        if(movieRepository.exists(movieId)) {
            movieRepository.delete(movieId);
            return true;
        } else {
            return false;
        }
    }
}
