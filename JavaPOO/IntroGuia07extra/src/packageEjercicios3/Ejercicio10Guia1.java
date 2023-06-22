
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
public class Ejercicio10Guia1 {
    public static void main(String[] args) {
        int num1, num2, num3, num4, i, j, cont;
        Scanner leer=new Scanner(System.in);
        
        System.out.println("A continuación debes ingresar 4 números entre 1 y 20");
     
        System.out.println("Ingresa el primero");
        num1=leer.nextInt();
        if (num1<1 || num1>20) {
            System.out.println("Número no válido");
            num1=0;
        }

        System.out.println("Ingresa el segundo");
        num2=leer.nextInt();
        if (num2<1 || num2>20) {
            System.out.println("Número no válido");
            num2=0;
        }

        System.out.println("Ingresa el tercero");
        num3=leer.nextInt();
        if (num3<1 || num3>20) {
            System.out.println("Número no válido");
            num3=0;
        }

        System.out.println("Ingresa el cuarto");
        num4=leer.nextInt();
        if (num4<1 || num4>20) {
            System.out.println("Número no válido");
            num4=0;
        }
        
        System.out.println("==========================");

        if (num1>0){
            System.out.print(num1+"");
            for (j=0;j<num1;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        
        if (num2>0) {
            System.out.print(num2+"");
            for (j=0;j<num2;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
                    
        if (num3>0) {
             System.out.print(num3+"");
            for (j=0;j<num3;j++){
                System.out.print("*");
            }
            System.out.println("");
            
        }
        
        if (num4>0) {
            System.out.print(num4+"");
            for (j=0;j<num4;j++){
                System.out.print("*");
             
            }
            System.out.println("");
            
        }
    }    
}
