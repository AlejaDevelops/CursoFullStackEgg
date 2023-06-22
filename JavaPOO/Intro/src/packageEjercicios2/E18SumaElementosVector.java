/*
Realizar un algoritmo que calcule la suma de todos los elementos de un vector de tamaño N, 
con los valores ingresados por el usuario.
 */
package packageEjercicios;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class E18SumaElementosVector {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("*** SUMA DE LOS ELEMENTOS DE UN VECTOR ***");
        System.out.println("--------------------------------------");
        System.out.println("Indica el tamaño deseado en tu vector");
        int tamanoVector = leer.nextInt();
        int vector[] = new int[tamanoVector];
        
        llenarVector(tamanoVector, vector);
        System.out.println("El vector ingresado es: ");
        imprimirVector(vector);
        System.out.println("");
        System.out.println("La suma de los elementos del vector ingresado es: " + sumaElementosVector(vector));
        
    }
    
    public static int[] llenarVector(int n, int[] vector){
        Scanner leer = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Por favor ingresa el dato de la posición "+i+" del vector");
            vector[i]=leer.nextInt();
            
        }
        return vector;
    }
    
    public static void imprimirVector(int[] vector){
        
        System.out.print("|");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]+" ");
        }
        System.out.println("|");
         
    }
    
    public static int sumaElementosVector(int[]vector){
        int suma = 0;
        for (int i = 0; i < vector.length; i++) {
            suma+= vector[i];                     
        }

        return suma;
    }
}
