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
public class E1ConversorTiempo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner leer = new Scanner(System.in);
                 
        System.out.println("Por favor ingrese los minutos");
        int minutos = leer.nextInt();
        int dias = (int) (minutos/1440);
        int horas = (int) ((minutos%1440)/60);
        System.out.println("El tiempo ingresado equivale a "+ dias + " días más " +horas+" horas"); 
    
    }
    
}
