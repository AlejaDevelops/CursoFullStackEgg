
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*Implementar un programa que le pida dos números enteros a usuario y determine si ambos o
alguno de ellos es mayor a 25.*/
 /*
 * @author Computador 1
 */
public class Ejercicio06Guia7 {
    public static void main(String[] args) {
    int num1;
    int num2;
    Scanner leer=new Scanner(System.in);
    
    System.out.println("Ingresa un numero");
    num1=leer.nextInt();
    System.out.println("Ingresa otro numero");
    num2=leer.nextInt();
    
    if ((num1<25) && (num2<25)) {
        System.out.println("Ninguno de los dos números es mayor a 25");
    }
    else if ((num1>25) && (num2>25)){
        System.out.println("Ambos números son mayores a 25");
    }
    else {
            System.out.println("Al menos uno de los números es mayor que 25");
    }
  
 }
}
