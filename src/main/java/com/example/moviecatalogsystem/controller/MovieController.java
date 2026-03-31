package com.example.moviecatalogsystem.controller;

import com.example.moviecatalogsystem.model.MovieEntity;
import com.example.moviecatalogsystem.repository.MovieRepository;
import com.example.moviecatalogsystem.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/create")
    public MovieEntity createMovie(@RequestBody MovieEntity movie) {
        return movieService.createMovie(movie);
    }

    @GetMapping("/{id}")
    public MovieEntity getById(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @GetMapping()
    public List<MovieEntity> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PutMapping("/{id}")
    public MovieEntity updateMovie(@PathVariable Long id, @RequestBody MovieEntity movie) {
        return movieService.updateMovie(id, movie);

    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "movie is deleted";
    }
}

