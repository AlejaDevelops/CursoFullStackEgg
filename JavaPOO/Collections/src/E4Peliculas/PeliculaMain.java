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

import E4Peliculas.utilidades.Comparadores;
import java.util.ArrayList;
import java.util.Collections;



/**
 *
 * @author AlejaDevelops
 */
public class PeliculaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("*** TU ARCHIVO DE PELICULAS ***");
        PeliculaService ps = new PeliculaService();
        ArrayList<Pelicula> listaPelis = ps.crearPeliculas();
        
        
        System.out.println("\n"
                + "Las peliculas ingresadas son: ");        
        ps.imprimirArrayList(listaPelis);
        
        System.out.println("");
        ps.pelisMasUnaHora(listaPelis);
        
        System.out.println("");        
        Collections.sort(listaPelis, Comparadores.ordenPorDuracionDescen);
        System.out.println("Películas ordenadas por duración");
        System.out.println("Orden descendente: ");
        ps.imprimirArrayList(listaPelis);      
        Collections.sort(listaPelis, Comparadores.ordenPorDuracionDescen.reversed());
        System.out.println("");        
        System.out.println("Orden ascendente: ");
        ps.imprimirArrayList(listaPelis);
        System.out.println("");  
        System.out.println("Películas ordenadas por titulo:");
        Collections.sort(listaPelis, Comparadores.ordenPorTitulo);
        ps.imprimirArrayList(listaPelis);
        System.out.println("");  
        System.out.println("Películas ordenadas por director:");
        Collections.sort(listaPelis, Comparadores.ordenPorDirector);
        ps.imprimirArrayList(listaPelis);
    }
    
}
