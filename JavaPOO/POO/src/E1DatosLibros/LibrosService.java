
package E1DatosLibros;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class LibrosService {
    //Método "informacionLibro" para recolectar la información del usuario. El método retorna un objeto libro1 del tipo "E1Libro"
    //Se debe importar desde Entidades.E1Libro (La clase E1Libro)
    public Libros informacionLibro(){
        
        //Instanciación de un objeto del tipo E1Libro
        Libros libro1 = new Libros ();
        
        //Solicitud datos al usuario
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa el ISBN");
        libro1.setIsbn(leer.nextLine());
        System.out.println("Ingresa el título");
        libro1.setTitulo(leer.nextLine());
        System.out.println("Ingrese el nombre del autor");
        libro1.setAutor(leer.nextLine());
        System.out.println("Ingresa el número del páginas");
        libro1.setnPaginas(leer.nextInt());
        
        return libro1;
        
    }
    
    //Método "Impresión  libro" que permite imprimir la información necesaria, requiere como parámetro 
    // un objeto del tipo E1Libro
    public void impresionLibro(Libros l1){
        System.out.println("El ISBN del libro es " +l1.getIsbn());
        System.out.println("El título del libro es "+l1.getTitulo());
        System.out.println("El nombre del autor es "+l1.getAutor());
        System.out.println("El número de páginas es "+l1.getnPaginas());
    }
}
