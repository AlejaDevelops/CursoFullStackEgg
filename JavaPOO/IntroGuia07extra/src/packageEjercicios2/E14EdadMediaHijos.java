/*
Se dispone de un conjunto de N familias, cada una de las cuales tiene una M cantidad de hijos.
Escriba un programa que pida la cantidad de familias y para cada familia la cantidad de hijos 
para averiguar la media de edad de los hijos de todas las familias.
 */
package packageEjercicios;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class E14EdadMediaHijos {
    public static void main(String[] args) {
         Scanner leer = new Scanner(System.in);
    
         System.out.println("*** CALCULADORA EDAD MEDIA DE HIJOS ***");
         System.out.println("-------------------------------------");
         System.out.println("Ingresa la cantidad de familias a evaluar");
        int nFamilias = leer.nextInt();
        
        while (nFamilias<=0) {            
            System.out.println("El número ingresado es inválido.");
            System.out.println("Intenta nuevamente");
            nFamilias = leer.nextInt();
        }
        
        calculadoraEdadMedia(nFamilias);
    }
    
    public static void calculadoraEdadMedia(int n){
        Scanner leer = new Scanner(System.in);
        int edadTotal = 0;
        int nHijosTotal = 0;
        
        for (int i = 1; i <= n; i++) {
            System.out.println("*** Registro datos familia "+i+ " ***");
            System.out.println("¿Cuántos hijos tiene la familia "+i+" ?");
            int nHijos = leer.nextInt();
            nHijosTotal +=nHijos;

            
            for (int j = 1; j <= nHijos; j++) {
                System.out.println("Ingresa la edad del hijo "+j);
                int edad = leer.nextInt();
                edadTotal +=edad; 
            }
            
        }
        System.out.println("La edad promedio de los hijos de las "+n+" familias es "+edadTotal/nHijosTotal);
    
    }
}
