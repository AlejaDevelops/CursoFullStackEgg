
package E1Cancion;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class CancionService {
    
    Scanner leer = new Scanner(System.in);
    public Cancion registrarCancion(){
        Cancion cancion1 = new Cancion();

        System.out.println("Registra el nombre de la canción ");
        cancion1.setTitulo(leer.nextLine());
        System.out.println("Ingresa el autor");
        cancion1.setAutor(leer.nextLine());

        return cancion1;
    
    }
    
    public void imprimirCancion(Cancion a){
        System.out.println("Datos de la canción: ");
        System.out.println("Título: "+a.getTitulo());
        System.out.println("Autor: "+a.getAutor());
    }
}
