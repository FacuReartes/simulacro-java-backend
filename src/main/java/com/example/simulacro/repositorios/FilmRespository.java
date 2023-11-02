package com.example.simulacro.repositorios;

import com.example.simulacro.entidades.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRespository extends JpaRepository<Film, Integer> {

    @Query("SELECT coalesce(max(filmId), 0) FROM Film")
    Integer getMaxId();

}
