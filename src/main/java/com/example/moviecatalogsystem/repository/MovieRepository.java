package com.example.moviecatalogsystem.repository;

import com.example.moviecatalogsystem.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Long> {
}
