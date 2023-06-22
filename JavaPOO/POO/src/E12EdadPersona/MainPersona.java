/*
Implemente la clase Persona. Una persona tiene un nombre y una fecha de nacimiento
(Tipo Date), constructor vacío, constructor parametrizado, get y set. Y los siguientes
métodos:
 Agregar un método de creación del objeto que respete la siguiente firma:
crearPersona(). Este método rellena el objeto mediante un Scanner y le pregunta al
usuario el nombre y la fecha de nacimiento de la persona a crear, recordemos que la
fecha de nacimiento debe guardarse en un Date y los guarda en el objeto.
 Escribir un método calcularEdad() a partir de la fecha de nacimiento ingresada. Tener
en cuenta que para conocer la edad de la persona también se debe conocer la fecha
actual.
 Agregar a la clase el método menorQue(int edad) que recibe como parámetro otra
edad y retorna true en caso de que el receptor tenga menor edad que la persona que
se recibe como parámetro, o false en caso contrario.


 Metodo mostrarPersona(): este método muestra la persona creada en el método
anterior. 
 */
package E12EdadPersona;

import java.util.Date;

/**
 *
 * @author AlejaDevelops
 */
public class MainPersona {
    public static void main(String[] args) {
        
        System.out.println("*** CALCULADORA EDADES ***" );
        PersonaService ps = new PersonaService(); 
        
        Persona p1 = ps.crearPersona(); 
        
        
        System.out.println("Registro de datos de una nueva persona");
        Persona p2 = ps.crearPersona();
        
        
        if (ps.menorQue(p1, p2)!=true) {
           System.out.println(p1.getNombre()+" es menor que "+p2.getNombre());
           ps.mostrarPersona(p2);
        } else {
            System.out.println(p1.getNombre()+" es mayor que "+p2.getNombre());
            ps.mostrarPersona(p1);
            
        }
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
            
    
    
    
    
}
