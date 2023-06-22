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
public class E10AdivineElProducto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        int num1= (int) (Math.random()*11),num2 = (int) (Math.random()*11), resultado=num1*num2;
        
        System.out.println("ADIVINA EL PRODUCTO DE DOS NUMEROS");
        System.out.println("El programa está eligiendo 2 números");
        System.out.println("...");
        System.out.println("Números elegidos! Ahora adivina el número...");
        int numUsuario = leer.nextInt();
        
        while (numUsuario!=resultado) {
            System.out.println("Fallaste, intenta de nuevo: ");
            numUsuario = leer.nextInt();
 
        }
        System.out.println("Acertaste!!! ");
    }
    
}
