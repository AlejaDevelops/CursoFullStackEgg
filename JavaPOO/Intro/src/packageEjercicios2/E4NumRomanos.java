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
public class E4NumRomanos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int numero;
        
        System.out.println("Ingrese un número entre 1 y 10");
        numero = input.nextInt();
        
        if(numero >= 0 && numero <= 10){
            if(numero >= 1 && numero <= 3){
                for (int i = 0; i < numero; i++) {
                    System.out.print("I");
                }
            }else if(numero >= 4 && numero <= 8){
                if(numero == 4){
                    System.out.print("I");
                }

                System.out.print("V");

                for (int i = 0; i < numero - 5; i++) {
                    if(numero != 5 && numero != 4){
                        System.out.print("I");
                    }
                }
            }else if (numero >= 9 && numero <=10) {
                if(numero == 9){
                    System.out.print("I");
                }
                System.out.print("X");
            }
        }
    }
}
