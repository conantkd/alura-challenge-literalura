package com.alura.challengeliteralura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;
    private String idioma;
    private int numeroDescargas;

    @ManyToOne
    private Autor autor;

        public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        this.idioma = datosLibro.idiomas().get(0);
        this.numeroDescargas = datosLibro.numeroDescargas();
        this.autor = datosLibro.autores().stream().map(Autor::new).toList().get(0);

        }



    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }


    public void addAutor(Autor autor) {
        autor.getLibros().add(this);
    }


    @Override
    public String toString() {
        return "*********LIBRO*********\n"+
                "Titulo: " + titulo + "\n" +
                "Autor: " + autor.getNombre() + "\n" +
                "Idioma: " + idioma.toUpperCase()+ "\n" +
                "Numero de descargas: " + numeroDescargas + "\n" +
                "**********************";

    }
}
