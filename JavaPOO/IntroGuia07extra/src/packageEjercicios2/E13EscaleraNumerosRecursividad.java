/*
Crear un programa que dibuje una escalera de números, donde cada línea de números comience en uno y termine en el número de la línea. 
Solicitar la altura de la escalera al usuario al comenzar. Ejemplo: si se ingresa el número 3:
1
12
123
 */
package packageEjercicios;

import java.util.Scanner;

/**
  * @author AlejaDevelops
 */
public class E13EscaleraNumerosRecursividad {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println(" *** ESCALERA DE NUMEROS *** ");
        System.out.println("---------------------------");
        System.out.println("Ingresa un número que indique la altura que deseas en tu escalera");
        int alturaEscalera = leer.nextInt();

        while (alturaEscalera <= 0) {
            System.out.println("Número inválido"
                    + "Inténtalo nuevamente");
            alturaEscalera = leer.nextInt();
        }

        for (int i = 1; i <= alturaEscalera; i++) {
            for (int j = 1; j <= i; j++) {

                System.out.print(j + " ");
            }
            System.out.println("");
        }
        
        System.out.println("Resultado con método recursivo: ");
        escalera(alturaEscalera);
                
    }
    
    //Método con recursividad: 
     public static void escalera(int n){
        
        if(n == 1){
            System.out.println(n);
        }else{
            escalera(n-1);
            for (int i = 1; i <= n; i++) {
                 System.out.print(i + " ");
            }
            System.out.println("");
        }
    
    }
}
    

