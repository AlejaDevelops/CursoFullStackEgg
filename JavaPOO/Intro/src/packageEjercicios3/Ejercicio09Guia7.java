
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
public class Ejercicio09Guia7 {
    public static void main(String[] args) {
    int num;
    int sumaTotal=0;
    int cont=0;
    Scanner leer=new Scanner(System.in);
        
    do {
        System.out.println("Ingrese 20 números");
        num=leer.nextInt();
        cont++;
        
        if (num==0){
         System.out.println("Se ingresó el numero 0");
         System.out.println("Fin");
         break;
        }
                
        if (num>0){
           sumaTotal += num;
        }
    } while (cont<5);
    System.out.println("La suma de los números positivos ingresados es " +sumaTotal);
    System.out.println("La cantidad de números ingresados es " +cont);
    }
}
