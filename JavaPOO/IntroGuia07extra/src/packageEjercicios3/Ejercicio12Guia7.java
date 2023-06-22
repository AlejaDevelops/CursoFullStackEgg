

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
public class Ejercicio12Guia7 {
     public static void main(String[] args) {
         Scanner leer=new Scanner(System.in);
         System.out.println("Ingresa dos números: ");
         int num1 = leer.nextInt();
         int num2 = leer.nextInt();
         
         esMultiplo(num1, num2);
                   
     }
       public static void esMultiplo(int num1, int num2){
           int result = num1 % num2;
           
           if (result!=0){
             System.out.println("El número " +num1+ " no es múltiplo del número " +num2);
           }else{
             System.out.println("El número " +num1+ " es múltiplo de número " +num2);
           }
    
       }
               
}
