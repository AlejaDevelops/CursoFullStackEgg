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
public class E8Multiplo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("NUMERO MULTIPLO 5");
        
        int cont = 0;
        int sumaPar=0;
        int sumaImpar=0;
        int numero;
        
        do {                
            System.out.println("Ingresa un número");
            numero = leer.nextInt();
            
            if (numero<0) {
                continue;
            }
            
            if (numero%5==0) {
                break;
            }
            
            if (numero%2==0) {
                sumaPar++;
            } else {
                sumaImpar++;
            }

        } while (numero%5!=0);
        
        System.out.println("La cantidad de números pares es: "+sumaPar);
        System.out.println("La cantidad de números impares es: "+sumaImpar);
        
    }
    
}
