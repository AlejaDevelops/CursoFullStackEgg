/*
Realizar un programa en Java donde se creen dos arreglos: el primero será un arreglo A
de 50 números reales, y el segundo B, un arreglo de 20 números, también reales. 
El programa deberá inicializar el arreglo A con números aleatorios y mostrarlo por pantalla.

Luego, el arreglo A se debe ordenar de menor a mayor y copiar los primeros 10 números
ordenados al arreglo B de 20 elementos, y rellenar los 10 últimos elementos con el valor
0.5. Mostrar los dos arreglos resultantes: el ordenado de 50 elementos y el combinado de
20.
 */
package E10LLenarArrays;

import java.util.Arrays;


/**
 *
 * @author AlejaDevelops
 */
public class MainArrays {

    public static void main(String[] args) {
    
        double[] vectorA = new double[50];
        double[] vectorB = new double[20];
        
        System.out.println("VECTOR A ");
        System.out.print("|");
        for (int i = 0; i < vectorA.length; i++) {
            vectorA[i]=Math.random()*100;
            System.out.print("("+i+")"+vectorA[i]+"  ");
        }
        System.out.println("|");
        System.out.println(" ");
        
        Arrays.sort(vectorA);
              
        System.out.println("VECTOR A ORDENADO ");
        System.out.print("|");
        for (int i = 0; i < vectorA.length; i++) {            
            System.out.print("("+i+")"+vectorA[i]+"  ");
        }
        System.out.println("|");
        System.out.println(" ");
        
        for (int i = 0; i < 10; i++) {
            vectorB[i]=vectorA[i];
        }
                   
        Arrays.fill(vectorB, 10, 19, 0.5);
        
        System.out.println("VECTOR B ");
        System.out.print("|");
        for (int i = 0; i < vectorB.length; i++) {            
            System.out.print("("+i+")"+vectorB[i]+"  ");
        }
        System.out.println("|");
    
    
    
    }
    
    
    
       
    
}
