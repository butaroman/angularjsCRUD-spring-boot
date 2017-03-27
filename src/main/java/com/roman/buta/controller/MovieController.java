package com.roman.buta.controller;

import com.roman.buta.model.Movie;
import com.roman.buta.service.MovieService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "movie")
public class MovieController {

    private static final Logger log = Logger.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getAllMovie() {
        List<Movie> movieList = movieService.findAll();
        log.info("Find all movies: " + movieList);
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        log.info("Save movie: " + movie);
        return new ResponseEntity<>( movieService.addMovie(movie), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> findMovieById(@PathVariable("id") Integer movieId) {
        Movie movie = movieService.findById(movieId);
        log.info("Find movie by id: " + movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Movie> deleteMovie(@PathVariable("id") Integer id) {
        log.info("Delete movie with id: " + id );
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}