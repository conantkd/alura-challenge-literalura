package com.alura.challengeliteralura.repository;

import com.alura.challengeliteralura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNombre(String nombre);

    @Query("select a from Autor a where a.anioNacimiento <=:anio and a.anioFallecimiento >=:anio")
    List<Autor> buscarAutoresVivosPorAnio(int anio);

}
