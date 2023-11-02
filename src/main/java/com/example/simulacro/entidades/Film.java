package com.example.simulacro.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "film")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Film {

    @Id
    private long filmId;

    @Basic
    private String title;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "language_id")
    private long languageId;

    @Column(name = "rental_duration")
    private int rentalDuration;

    @Column(name = "rental_rate")
    private float rentalRate;

    @Basic
    private int length;

    @Column(name = "replacement_cost")
    private float replacementCost;

    @Basic
    private String rating;

    @Column(name = "special_features")
    private String specialFeatures;

    @Basic
    private String description;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
