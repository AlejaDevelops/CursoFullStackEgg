
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
public class Ejercicio04Guia7 {
    public static void main(String[] args) {
        String nombre;
        int edad;
        Scanner Leer=new Scanner(System.in);
        System.out.println("Ingresa tu nombre");
        nombre=Leer.next();
        System.out.println("Ingresa tu edad");
        edad=Leer.nextInt();
        System.out.println("Tu nombre es "+nombre+ " y tu edad es " +edad);
        
        
    }
}
