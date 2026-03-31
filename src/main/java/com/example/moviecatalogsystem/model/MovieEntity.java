package com.example.moviecatalogsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="movies")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieEntity {
    @Id
    private Long id;
    private String title;
    private  String genre;
    private  String director;
    private int year;
    private double rating;

}
