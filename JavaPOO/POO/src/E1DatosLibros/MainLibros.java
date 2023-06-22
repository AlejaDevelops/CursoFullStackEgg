/*
Crear una clase llamada Libro que contenga los siguientes atributos: ISBN, Título, Autor,
Número de páginas, y un constructor con todos los atributos pasados por parámetro y un
constructor vacío. Crear un método para cargar un libro pidiendo los datos al usuario y
luego informar mediante otro método el número de ISBN, el título, el autor del libro y el
numero de páginas.
 */
package E1DatosLibros;

/**
 *
 * @author AlejaDevelops
 */
public class MainLibros {


    public static void main(String[] args) {
       
        // Instanciación de un objeto libroServicio del tipo E1LibroService (Nombre de la Clase Servicio)
        LibrosService libroServicio = new LibrosService();
        
        //Instanciación de un objeto libro1 del tipo E1Libro (Método de la clase Servicio)
        Libros libro1 = libroServicio.informacionLibro();
        
        //Llamado del método impresionLibro con libro1 como parámetro
        libroServicio.impresionLibro(libro1);
    }
    
    
}
