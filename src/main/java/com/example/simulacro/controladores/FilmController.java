package com.example.simulacro.controladores;

import com.example.simulacro.entidades.Film;
import com.example.simulacro.servicios.AddressServiceImpl;
import com.example.simulacro.servicios.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/{filmId}")
    public ResponseEntity<Film> findById(@PathVariable("filmId") int filmId) {
        try {
            Film f = filmService.findById(filmId);
            return ResponseEntity.ok(f);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Film> add(@RequestBody Film entity) {
        Film f = filmService.add(entity);
        return ResponseEntity.ok(f);
    }

    @DeleteMapping("/{filmId}")
    public ResponseEntity<Film> delete(@PathVariable("filmId") int filmId) {
        try {
            Film f = filmService.delete(filmId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<Film> modify(@RequestBody Film entity) {
        try {
            Film f = filmService.modify(entity);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(f);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
