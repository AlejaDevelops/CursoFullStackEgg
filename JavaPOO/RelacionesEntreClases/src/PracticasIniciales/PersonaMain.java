/*
EJERCICIO PERSONA
Realiza un programa en donde una clase Persona tenga como atributo nombre, apellido y un
objeto de clase Dni. La clase Dni tendrá como atributos la serie (carácter) y número. Prueba
acceder luego a los atributos del dni de la persona creando objetos y jugando desde el main.
 */
package PracticasIniciales;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class PersonaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
                
        Persona p = new Persona();        
        System.out.println("Ingresa el nombre de la persona");
        p.setNombre(leer.nextLine());
        System.out.println("Ingresa el apellido de la persona");
        p.setApellido(leer.nextLine());
        
        Dni dni = new Dni();  
        System.out.println("Ingresa su número del DNI");
        dni.setNumero(leer.nextInt());        
        System.out.println("Ingresa la serie del DNI");
        dni.setSerie(leer.next().charAt(0));
        p.setDni(dni);
        
        System.out.println("Nombre: "+p.getNombre()
                +"\n Apellido: "+p.getApellido()
                +"\n"+p.getDni().toString());
        
    }
    
}
