/*
Dado un fichero con una serie de números, hay que eliminar todos los ceros que hay en el fichero, 
y si una linea esta llena de ceros, hay que eliminar la linea. En este caso tenemos en el fichero el contenido siguiente:
1 2 0 3 0 7 
0 0 0 0 
0 6 9 8 0 9 6 
0 0 0 0 7 9 0 0 
0 0 0 0 0 
8 7 0 8 9 0 8

Y lo que hay que conseguir es trasformar esos datos en los siguientes:
1 2 3 7 
6 9 8 9 6 
7 9 
8 7 8 9 8
*/
package E14SerieNumeros;

import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author AlejaDevelops
 */
public class SerieMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<int[][]> listaNumeros = new ArrayList<>();
        int[][] matrizNumeros = {{1,2,0,3,0,7 },{0, 0, 0, 0 },{0, 6, 9, 8, 0, 9, 6},{0, 0, 0, 0, 7, 9, 0, 0},{0, 0, 0, 0, 0},{8, 7, 0, 8, 9, 0, 8}};
        listaNumeros.add(matrizNumeros);
        
        System.out.println("LISTA INICIAL DE NUMEROS ");
        for (int[][] aux : listaNumeros) {
            for (int[] filas : aux) {
                for (int i : filas) {
                    System.out.print(i+" ");
                }
                System.out.println(" ");
            }
        }
        
        Iterator<int[][]> iteratorNum = listaNumeros.iterator();
        
        while (iteratorNum.hasNext()) {
            int[][] matriz = iteratorNum.next();
            for (int[] filas : matriz) {
                for (int i : filas) {
                    if (i==0) {
                        iteratorNum.remove();
                    }
                }
                
            }
        }
        
        System.out.println("LISTA FINAL DE NUMEROS ");
        for (int[][] aux : listaNumeros) {
            for (int[] filas : aux) {
                for (int i : filas) {
                    System.out.print(i+" ");
                }
                System.out.println(" ");
            }
        }
    }
    
}
