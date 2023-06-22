
package E1DatosLibros;

/**
 *
 * @author AlejaDevelops
 */
public class Libros {
    //Creación de las variables
    String isbn;
    String titulo;
    String autor;
    int nPaginas;
    
    //Constructor vacío - Por defecto
    public Libros() {
    }
    
    ///Constructor con parámetros - OBJETOS DEL TIPO E1Libro
    public Libros(String isbn, String titulo, String autor, int nPaginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.nPaginas = nPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    @Override
    public String toString() {
        return "Libros{" + "isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", nPaginas=" + nPaginas + '}';
    }
}
