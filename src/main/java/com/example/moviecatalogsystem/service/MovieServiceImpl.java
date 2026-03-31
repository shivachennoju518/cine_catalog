
package com.example.moviecatalogsystem.service;

import com.example.moviecatalogsystem.model.MovieEntity;
import com.example.moviecatalogsystem.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieEntity createMovie(MovieEntity movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public MovieEntity getById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public MovieEntity updateMovie(Long id, MovieEntity movie) {
        MovieEntity existing = movieRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setTitle(movie.getTitle());
            existing.setDirector(movie.getDirector());
            existing.setGenre(movie.getGenre());
            existing.setYear(movie.getYear());
            existing.setRating(movie.getRating());
            return movieRepository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
