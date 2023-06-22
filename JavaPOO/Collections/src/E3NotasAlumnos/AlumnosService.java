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
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class AlumnosService {
    Scanner leer = new Scanner(System.in);
    public ArrayList<Alumnos> crearAlumnos(){ 
        ArrayList<Alumnos> listaAlumnos = new ArrayList(); //ArrayList de objetos tipo Alumnos
       
        String respuesta;
        
        do {
            Alumnos alumno = new Alumnos(); //Objeto tipo alumno
            ArrayList<Integer> listaNotas = new ArrayList(); //ArrayList que almacenará las notas            
            int nota;
            System.out.println("Ingresa el nombre del alumno ");
            alumno.setNombre(leer.next());           
            for (int i = 0; i < 3; i++) {
                do {
                    System.out.println("Ingresa la nota N°"+(i+1)+ ". Valores válidos entre 0 y 5 ");
                    nota = leer.nextInt();
                    if (nota>=0 && nota<=5) {
                        listaNotas.add(nota);
                    }else{
                        System.out.println("Nota ingresada no válida. Intenta nuevamente");
                    }
                } while (nota<0 || nota>5 );               
            }
            
            alumno.setListaNotas(listaNotas);
            listaAlumnos.add(alumno);
            System.out.println("¿Deseas ingresar otro estudiante?");
            respuesta = leer.next();
        } while (respuesta.equalsIgnoreCase("si"));        
        
       return listaAlumnos; 
    }
    
    public int notaFinal(ArrayList<Integer> a){        
        Integer suma = 0;
        
        for (Integer num : a) {
            suma += num;
        }
        
        return suma/a.size();
        
    }
    
    
}
