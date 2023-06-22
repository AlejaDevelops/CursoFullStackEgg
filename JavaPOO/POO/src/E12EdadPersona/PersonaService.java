
package E12EdadPersona;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class PersonaService {
    Scanner leer = new Scanner(System.in);
    
    public Persona crearPersona(){
        Persona persona1 = new Persona();
        System.out.println("Ingresa el nombre de la persona");
        persona1.setNombre(leer.next());
        System.out.println("A continuación ingresa su fecha de nacimiento");
        System.out.println("Dia");
        int dia = leer.nextInt();
        System.out.println("Mes");
        int mes = leer.nextInt();
        System.out.println("Año");
        int anio = leer.nextInt();
        Date fechaNac = new Date(anio-1900,mes-1,dia);
        System.out.println("Confirmo la fecha de nacimiento ingresada: "+fechaNac);
        persona1.setFechaNacimiento(fechaNac);
        
        return persona1;
    }
    
    public Date calcularEdad(Persona a){
        Date hoy = new Date ();
        //ñSystem.out.println("La fecha actual es "+hoy);
        Date edad = new Date(hoy.getYear()-a.getFechaNacimiento().getYear(),hoy.getMonth()-a.getFechaNacimiento().getMonth(),hoy.getDate()-a.getFechaNacimiento().getDate());
        
        System.out.println("La edad de "+a.getNombre()+" es "+edad.getYear());
        
        return edad;             
   
    }
    
    public boolean menorQue (Persona b, Persona c){
        Date edad1 = calcularEdad(b);
        Date edad2 = calcularEdad(c);
        
        return edad2.getYear() <edad1.getYear();
        }
    
    public void mostrarPersona (Persona d){
        System.out.println("Datos de la persona mayor");
        System.out.println("NOMBRE: "+d.getNombre());    
        System.out.println("FECHA DE NACIMIENTO: "+d.getFechaNacimiento());
        System.out.println("EDAD: "+calcularEdad(d));
        
    }
        
         
    
}
