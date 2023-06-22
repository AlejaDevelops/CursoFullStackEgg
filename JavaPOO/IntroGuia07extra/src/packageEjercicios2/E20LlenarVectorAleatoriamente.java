/*
Crear una función rellene un vector con números aleatorios, pasándole un arreglo por parámetro. 
Después haremos otra función o procedimiento que imprima el vector.
 */
package packageEjercicios;

import java.util.Arrays;

/**
 *
 * @author AlejaDevelops
 */
public class E20LlenarVectorAleatoriamente {
    public static void main(String[] args) {
        int[] vector = new int[15];
    
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random()*101);
        }
        
        System.out.println("VECTOR LLENADO ALEATORIAMENTE");
        System.out.println(Arrays.toString(vector));
    }
    
}
    
