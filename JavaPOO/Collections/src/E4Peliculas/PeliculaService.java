/*
Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
tendremos una clase Pelicula con el título, director y duración de la película (en horas).
Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
que se pide a continuación:
En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones:
22
• Mostrar en pantalla todas las películas.
• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.


• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en
pantalla.
• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
pantalla.
• Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
 */
package E4Peliculas;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class PeliculaService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);; 
    public ArrayList<Pelicula> crearPeliculas(){      
       
        ArrayList<Pelicula> listaPeliculas = new ArrayList();
        String option;
        
        do {            
            Pelicula peli = new Pelicula();        
            System.out.println("Ingresa los datos de la película");
            System.out.println("Título");
            peli.setTitulo(leer.next());
            System.out.println("Director");
            peli.setDirector(leer.next());
            System.out.println("Duración en horas");
            peli.setDuracion(leer.nextDouble());
            listaPeliculas.add(peli);
            System.out.println("Deseas ingresar otra película?");
            option = leer.next();
            
            while ((!option.equalsIgnoreCase("si")) && (!option.equalsIgnoreCase("no"))) {
                System.out.println("Error! Ingrese nuevamente su respuesta.");
                System.out.println("Desea agregar otro alumno?(si/no) ");
                option = leer.next();
            }                       
                   
        } while (option.equalsIgnoreCase("si"));        
        
        return listaPeliculas;       
         
    }
    
    public void pelisMasUnaHora(ArrayList<Pelicula> listaP){
        boolean flag = true;
        for (Pelicula pelicula : listaP) {
            if (pelicula.getDuracion()>1) {
                if (flag) {
                    System.out.println("Las peliculas que duran más de 1 hora son: ");
                    System.out.println("* "+pelicula.getTitulo());                    
                    flag = false;
                } else{
                    System.out.println("* "+pelicula.getTitulo()); 
                }              
            }
        }
        if (flag) {
            System.out.println("No existen películas que duren más de una hora");
        }
        
    }
    
    public void imprimirArrayList(ArrayList<Pelicula> listaP){
        for (Pelicula pelicula : listaP) {
            System.out.println(pelicula.toString());            
        }
    }
            
    
    
}
