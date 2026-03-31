package com.example.moviecatalogsystem.service;

import com.example.moviecatalogsystem.model.MovieEntity;

import java.util.List;

public interface MovieService {
    MovieEntity createMovie(MovieEntity movie);
    MovieEntity getById(Long id);
     List<MovieEntity> getAllMovies();
     MovieEntity updateMovie(Long id,MovieEntity movie);
     void deleteMovie(Long id);
}
