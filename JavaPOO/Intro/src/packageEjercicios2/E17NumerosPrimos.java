/*
Crea una aplicación que nos pida un número por teclado y con una función se lo pasamos por parámetro 
para que nos indique si es o no un número primo, debe devolver true si es primo, sino false.
*/
package packageEjercicios;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class E17NumerosPrimos {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);  
        System.out.println("*** CALCULADORA DE NUMERO PRIMO ***");
        System.out.println("--------------------------------");
        System.out.println("Ingresa un número y te indicaré si es primo o no");
        int numero = leer.nextInt();
        
        System.out.println(" ");
        System.out.println("¿El número ingresado es primo? "+ primo(numero));
        
       
        
    }
    
    private static boolean primo(int num){
        
     int contadorPrimos = 0;
        for (int i = 1; i <= num; i++) {
            double operador = num%i;
            
            if (operador==0) {
                contadorPrimos +=1;
            }
        }
        if (contadorPrimos >2) {
            return false;
            
        } else {
            return true;
        }  
    }
    
}
        
    
   

