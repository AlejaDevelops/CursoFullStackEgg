/*
Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
con sus 3 notas.
En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.
 */
package E3NotasAlumnos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class AlumnosMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("*** NOTAS ALUMNOS ***");
        Scanner leer = new Scanner(System.in);
        AlumnosService as = new AlumnosService();
        ArrayList<Alumnos> listaAlumnos = as.crearAlumnos();
        
        System.out.println("Alumnos ingresados: ");
        Iterator it = listaAlumnos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
            
        }
        System.out.println("");
        System.out.println("Ingresa el nombre de un estuadiante para calcular su promedio");
        String nombre = leer.nextLine();
        boolean flag = true;
        for (Alumnos aux : listaAlumnos) {
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                int notaFinal = as.notaFinal(aux.getListaNotas());
                System.out.println("La nota final de "+aux.getNombre()+" es: "+notaFinal);
                flag = false;                
            }            
        }
        if (flag) {
            System.out.println("El nombre ingresado no se encuentra registrado");
        }       

    }
    
}
