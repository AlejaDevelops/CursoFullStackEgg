/*
Escriba un programa que averigüe si dos vectores de N enteros son iguales 
(la comparación deberá detenerse en cuanto se detecte alguna diferencia entre los elementos).
 */
package packageEjercicios;

import java.util.Arrays;


/**
 *
 * @author AlejaDevelops
 */
public class E19VectoresIguales {

    public static void main(String[] args) {
        System.out.println("*** COMPARANDO 2 VECTORES ***");
        int longitud = 10;
        int[] vector1 = new int[longitud]; 
        int[] vector2 = new int[longitud]; 
        System.out.println("Se están cargando aleatoriamente los datos de ambos vectores...");
        for (int i = 0; i < longitud; i++) {
            vector1[i] = (int) (Math.random()*11);
            vector2[i] = (int) (Math.random()*11);
        }
        System.out.println("");
        System.out.println("VECTOR 1");
        System.out.println(Arrays.toString(vector1));
        System.out.println("VECTOR 2");
        System.out.println(Arrays.toString(vector2));
        
        
        if (Arrays.equals(vector1, vector2)) {
            System.out.println("Los arreglos son iguales");
        } else {
            System.out.println("Los arreglos no son iguales");
        }
        
        
    }
    
}
