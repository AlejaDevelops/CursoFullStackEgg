/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E8GuardarFrase;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class FraseMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("*** OPCIONES PARA UNA FRASE ***");
        FraseService fs = new FraseService();
        Frase f = fs.crearFrase();
        int opcion;
        
        do {            
            System.out.println("Menú de opciones para la frase ingresada");
            System.out.println("1- Contar las vocales que tiene la frase");
            System.out.println("2- Invertir la frase");
            System.out.println("3- Contar las veces que se repite una letra");
            System.out.println("4- Comparar la longitud con una frase nueva");
            System.out.println("5- Unir la frase con una nueva");
            System.out.println("6- Reemplazar la letra A");
            System.out.println("7- Buscar una letra en la frase");
            System.out.println("8- Ingresar una nueva frase");
            System.out.println("9- Salir");
            opcion = leer.nextInt();
            
            switch(opcion){
                case 1:
                    fs.contarVocal(f);
                    System.out.println("---------------------");
                    break;
                case 2:
                    fs.invertirFrase(f);
                    System.out.println("---------------------");
                    break;
                case 3:
                    fs.vecesRepetido(f);
                    System.out.println("---------------------");
                    break;
                case 4:
                    fs.compararFrase(f);
                    System.out.println("---------------------");
                    break;
                case 5:
                    fs.unirFrases(f);
                    System.out.println("---------------------");
                    break;
                case 6:
                    fs.reemplazar(f);
                    System.out.println("---------------------");
                    break;
                case 7:
                    fs.contiene(f);
                    System.out.println("---------------------");
                    break;
                case 8:
                    f=fs.crearFrase();
                    System.out.println("---------------------");
                    break;
                case 9:
                    System.out.println("Has salido del menú");
                default:
                    System.out.println("Opción no válida, intenta nuevamente");                   
                
            }          
  
        } while (opcion!=9);    
  
    }
    
}
