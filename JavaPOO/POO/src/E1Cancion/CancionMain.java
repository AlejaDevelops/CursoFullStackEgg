/*
Desarrollar una clase Cancion con los siguientes atributos: titulo y autor. Se deberá́
definir además dos constructores: uno vacío que inicializa el titulo y el autor a cadenas
vacías y otro que reciba como parámetros el titulo y el autor de la canción. Se deberán
además definir los métodos getters y setters correspondientes.
 */
package E1Cancion;

/**
 *
 * @author AlejaDevelops
 */
public class CancionMain {

    public static void main(String[] args) {
        System.out.println("*** REGISTRO DE CANCIONES ***");
        CancionService cs = new CancionService();
        Cancion cancion1 = cs.registrarCancion();
        System.out.println("--------------");
        cs.imprimirCancion(cancion1);
        
        
        
        
    }

    
    
    
}
