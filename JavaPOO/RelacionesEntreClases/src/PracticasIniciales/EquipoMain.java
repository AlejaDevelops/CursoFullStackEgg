/*
EJERCICIO JUGADOR
Realiza un programa en donde exista una clase Jugador que contenga nombre, apellido, posición
y número. Luego otra clase Equipo que contenga una colección de jugadores. Una vez hecho
esto, desde el main recorreremos el equipo mostrando la información de cada jugador.
 */
package PracticasIniciales;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class EquipoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Jugador> equipo = new ArrayList();
        int input;
        do {            
            System.out.println("MENU "
                + "\n 1 - Agregar un jugador "
                + "\n 2 - Ver equipo"
                + "\n 3- Salir");
            input = leer.nextInt();
            
            switch(input){
                case 1:
                    Jugador j = new Jugador();
                    System.out.println("Ingresa el nombre ");
                    j.setNombre(leer.next());
                    System.out.println("Ingresa el apellido");
                    j.setApellido(leer.next());
                    System.out.println("Ingresa la posición");
                    j.setPosicion(leer.next());
                    System.out.println("Ingresa el numero");
                    j.setNumero(leer.nextInt());
                    equipo.add(j);
                    break;
                case 2:
                    System.out.println("*** EQUIPO*** ");
                    for (Jugador jugador : equipo) {
                        System.out.println(jugador.toString());                        
                    }
                    break;
                case 3:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Opción no válida");
                            
            }
        } while (input!=3);
        
    
    
    }
    
}
