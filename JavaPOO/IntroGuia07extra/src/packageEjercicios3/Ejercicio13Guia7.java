
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Computador 1
 */
public class Ejercicio13Guia7 {
    public static void main(String[] args) {
        String[] equipo = new String[4]; //Vector de dim 8 que puede alojar cadenas 
        String nombre;
        Scanner leer =new Scanner (System.in);
                
        //Llenado del vector
        for (int i = 0; i < 4; i++) {
            System.out.println("Ingresa el nombre de tu compañero de equipo");
            nombre=leer.nextLine();
            equipo[i]=nombre;
            
        }
        
        //Impresión de la matriz
        
        System.out.println("Tus compañeros de equipo son: ");
        for (int i = 0; i < 4; i++) {
            System.out.println((i+1)+ ". " +equipo[i]);
            
        }
    }
}
