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
public class E6Estaturas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        System.out.println("*** CALCULADORA ESTATURAS PROMEDIO ***");
        System.out.println("Ingrese la cantidad de personas ");
        int nEstaturas = leer.nextInt();
        double sumaTotal = 0;
        int cont = 0;
        double sumaParcial =0;
        
        for (int i = 0; i < nEstaturas; i++) {
            System.out.println("Ingrese la estatura de la persona "+(i+1)+" en metros");
            double estatura = leer.nextDouble();
            sumaTotal = sumaTotal + estatura; 
            if (estatura<1.6) {
                sumaParcial = sumaParcial + estatura;
                cont++;
            }
            
        }
        System.out.println("");
        System.out.println("El promedio total de las estaturas es: "+sumaTotal/nEstaturas);
        System.out.println("El promedio de las estaturas por debajo de 1.6m es: "+sumaParcial/cont);
    }
    
}
