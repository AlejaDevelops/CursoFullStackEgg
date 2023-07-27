
package libreria.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author AlejaDevelops
 */
@Entity
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)    
    private Integer id; //Numero de identificación interno
    @Column(unique = true)
    private String isbn; //Identificador único de cada libro, es el único dato que no se podría repetir en un libro, lo debe suministrar el usuario
    @Basic
    private String titulo;
    private Integer anio;
    private Integer ejemplares;
    private Integer ejemplaresPrestados;
    private Integer ejemplaresRestantes;
    private Boolean alta;
    @ManyToOne //Muchos libros - un autor
    //@JoinColumn(name = "AUTOR_ID")
    private Autor autor;
    @ManyToOne //Muchos libros - una editorial
    private Editorial editorial;

    public Libro() {
    }

    public Libro(Integer id, String isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta, Autor autor, Editorial editorial) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

   

    @Override
    public String toString() {
        return "\n Libro{"+"ID: "+id + ", ISBN: " + isbn + ", Titulo: " + titulo + ", Ejemplares: " + ejemplares + ", Ejemplares prestados: " + ejemplaresPrestados + ", Ejemplares restantes: " + ejemplaresRestantes + ", Alta: " + alta + ", Autor: " + autor.getNombre()+ ", Editorial: " + editorial.getNombre() + '}';
    }
    
    
    
    
}
