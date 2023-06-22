/*
Definir una clase llamada Puntos que contendrá las coordenadas de dos puntos, sus
atributos serán, x1, y1, x2, y2, siendo cada x e y un punto. Generar un objeto puntos
usando un método crearPuntos() que le pide al usuario los dos números y los ingresa en
los atributos del objeto. Después, a través de otro método calcular y devolver la distancia
que existe entre los dos puntos que existen en la clase Puntos.
 */
package E2DistanciaEntreDosPuntos;

import java.util.Scanner;

/**
 *
 * @author AlejsDevelops
 */
public class PuntosService {
    Scanner leer = new Scanner(System.in);
    public Puntos crearPuntos(){               
        Puntos puntos = new Puntos ();        
        System.out.println("Ingrese las coordenadas del punto 1");
        System.out.println("X1");
        puntos.setX1(leer.nextInt());
        System.out.println("Y1");
        puntos.setY1(leer.nextInt());
        System.out.println("Ingrese las coordenadas del punto 2");
        System.out.println("X2");
        puntos.setX2(leer.nextInt());
        System.out.println("Y2");
        puntos.setY2(leer.nextInt());
        
        
        return puntos;
    }
    
    
    public void distanciaEntreDosPuntos (Puntos a){
        double distancia;
        
        distancia =  Math.sqrt(Math.pow(a.getX2()- a.getX1(),2)+(Math.pow(a.getY2()-a.getY1(),2)));
        System.out.println("La distancia entre ("+a.getX1()+","+a.getX2()+") y ("+a.getY1()+","+a.getY2()+") es "+distancia);
    }
}
