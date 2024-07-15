package com.alura.challengeliteralura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private int anioNacimiento;
    private int anioFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros = new ArrayList<>();

    public Autor(DatosAutor datosAutor){
        System.out.println("Creando Autor con DatosAutor: " + datosAutor);
        this.nombre = datosAutor.nombre();
        this.anioNacimiento = datosAutor.anioNacimiento();
        this.anioFallecimiento = datosAutor.anioFallecimiento();
        System.out.println("Autor creado: " + this);
    }

    @Override
    public String toString() {
        return "\nAutor: " + nombre + "\n" +
                "Fecha de nacimiento: " + anioNacimiento + "\n" +
                "Fecha de fallecimiento: " + anioFallecimiento +"\n" +
                "Libros: " + libros.stream().map(Libro::getTitulo).toList() + "\n";
    }
}

