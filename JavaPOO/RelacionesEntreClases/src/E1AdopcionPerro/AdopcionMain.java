/*
Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase. 
Persona con atributos: nombre, apellido, edad, documento y Perro.

Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
 */
package E1AdopcionPerro;

import E1AdopcionPerrosService.PerroService;
import E1AdopcionPerrosService.PersonaService;
import java.util.ArrayList;

/**
 *
 * @author AlejaDevelops
 */
public class AdopcionMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("*** ADOPTA UN PERRITO ***");
        System.out.println("Cargando lista de Personas...");
        PersonaService ps = new PersonaService();        
        ArrayList<Persona> listaPersonas = ps.crearPersonas(); //Creación de las personas
        System.out.println("Cargando lista de perritos...");
        PerroService perroS = new PerroService();
        ArrayList<Perro> listaPerros = perroS.crearPerros();
        System.out.println("Listas cargadas exitosamente :)"
                + "\n");        
        ps.imprimir(ps.adoptandoPerrito(listaPersonas, listaPerros));
        
    }
    
}
