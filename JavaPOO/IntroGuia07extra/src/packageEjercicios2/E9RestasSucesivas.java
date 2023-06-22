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
public class E9RestasSucesivas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el Dividendo");
        int dividendo =leer.nextInt();
        System.out.println("Ingrese el Divisor");
        int divisor =leer.nextInt();
        int cont =0;
        
        do {            
            dividendo-=divisor;
            cont ++;
        } while (dividendo>=divisor);
     
        System.out.println("El cociente es: " +cont);
        System.out.println("El residuo es: " +dividendo);
    }
    
}
