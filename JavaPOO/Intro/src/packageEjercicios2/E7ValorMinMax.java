/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageEjercicios;

import java.util.Scanner;

/**
 *
 * @author Computador 1
 */
public class E7ValorMinMax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("CALCULADORA NUMERO MINIMO Y MÁXIMO");
        System.out.println("Ingrese la cantidad de números que desea");
        int n = leer.nextInt();
        int cont = 0;
        int numeroMayor = 0;
        int sumaTotal =0;
        int numeroMenor=0;
               
        /*while (cont<n-1) {     
            System.out.println("Ingresa un número");
            int numero = leer.nextInt();
            sumaTotal += numero;
            
            if (cont==0) {
                numeroMenor = numero;
                
            }else {
              if (numeroMayor<= numero) {
                numeroMayor=numero;
            
            }
            if (numeroMenor>=numero) {
                numeroMenor=numero;
            }  
            } 
            
            cont++;*/
            
            
            do {                
                System.out.println("Ingresa un número");
                int numero = leer.nextInt();
                
                if (numero<=0) {
                    continue;
                }
                
                sumaTotal += numero;

                if (cont==0) {
                    numeroMenor = numero;

                }
                if (numeroMayor<= numero) {
                    numeroMayor=numero;

                }
                if (numeroMenor>=numero) {
                    numeroMenor=numero;
                  
                } 

                cont++;
                
            } while (cont<n);
            
            System.out.println("El promedio total de los números ingresados es: "+(sumaTotal/cont));
            System.out.println("El número mayor es: "+numeroMayor);
            System.out.println("El número menor es: "+numeroMenor);
        }
        
        
}
    
