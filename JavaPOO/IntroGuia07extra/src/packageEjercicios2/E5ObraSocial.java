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
public class E5ObraSocial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Digite la clase de socio de acuerdo a las siguientes opciones:");
        System.out.println("A - B - C");
        String tipoSocio = leer.nextLine();
        System.out.println("Ingrese el valor del tratamiento tomado");
        double valorTratamiento = leer.nextDouble();
        double valorConDescto;
                
        switch(tipoSocio){
            case "A":
                valorConDescto = valorTratamiento-(valorTratamiento*0.5);
                System.out.println("El valor a pagar es: " +valorConDescto);
                break;
                
            case "B":
                valorConDescto = valorTratamiento-(valorTratamiento*0.35);
                System.out.println("El valor a pagar es: " +valorConDescto);
                break;
                
            case "C":
                valorConDescto = valorTratamiento;
                System.out.println("El valor a pagar es: " +valorConDescto);
                break;
                
            default:
                System.out.println("Tipo de socio inválido");
                
               
                
        }
        
        
    }
    
}
