/*
Escribir un programa que lea un número entero y devuelva el número de dígitos que componen ese número. 
Por ejemplo, si introducimos el número 12345, el programa deberá devolver 5. 
Calcular la cantidad de dígitos matemáticamente utilizando el operador de división.
Nota: recordar que las variables de tipo entero truncan los números o resultados.
 */
package packageEjercicios;

import java.util.Scanner;

/*
 * @author AlejaDevelops
 */
public class E11CantidadDigitos {

     public static void main(String[] args) {
         System.out.println("*** CALCULADORA DE CANTIDAD DE DIGITOS DE UN NUMERO ***");
         System.out.println("Ingrese un número");
         Scanner leer = new Scanner(System.in);
         int numero = leer.nextInt();
         int contador = 0;
         
         do {             
             numero = numero/10;
             contador +=1;        
                     
         } while (numero>0);
         
         System.out.println("La cantidad de dígitos del número ingresado es: "+contador);
    }
}
    
    
    
    
    
    
    
  