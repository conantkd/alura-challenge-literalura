package com.alura.challengeliteralura.repository;

import com.alura.challengeliteralura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByIdiomaIgnoreCase(String idioma);
    Libro findByTitulo(String titulo);}