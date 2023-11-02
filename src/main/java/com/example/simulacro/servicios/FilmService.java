package com.example.simulacro.servicios;

import com.example.simulacro.entidades.Film;

import java.util.NoSuchElementException;

public interface FilmService {

    Film add(Film entity);

    Film modify(Film entity) throws NoSuchElementException;

    Film findById(int filmId);

    Film delete(int filmId);
}
