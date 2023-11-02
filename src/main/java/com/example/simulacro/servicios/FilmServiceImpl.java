package com.example.simulacro.servicios;

import com.example.simulacro.entidades.Film;
import com.example.simulacro.repositorios.FilmRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FilmServiceImpl implements FilmService{

    @Autowired
    public FilmRespository filmRespository;

    @Override
    public Film add(Film entity) {
        int maxId = filmRespository.getMaxId();
        entity.setFilmId(maxId + 1);
        filmRespository.save(entity);
        return entity;
    }

    @Override
    public Film modify(Film entity) throws NoSuchElementException {
        Film existing = filmRespository.findById((int) entity.getFilmId()).orElseThrow();
        existing.setTitle(entity.getTitle());
        filmRespository.save(existing);
        return existing;
    }

    @Override
    public Film findById(int filmId) {
        return filmRespository.findById(filmId).orElseThrow();
    }

    @Override
    public Film delete(int filmId) {
        Film existing = filmRespository.findById(filmId).orElseThrow();
        filmRespository.delete(existing);
        return existing;
    }
}
