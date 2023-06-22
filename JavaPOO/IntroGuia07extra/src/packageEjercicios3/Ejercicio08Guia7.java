
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**Escriba un programa que valide si una nota está entre 0 y 10, sino está entre 0 y 10 la nota se
pedirá de nuevo hasta que la nota sea correcta.
 *
 * @author Computador 1
 */
public class Ejercicio08Guia7 {
    public static void main(String[] args) {
      int nota;
      Scanner leer=new Scanner(System.in);
      
      System.out.println("Ingresa una nota");
      nota=leer.nextInt();
      
      while (nota<0 || nota>10){ 
          System.out.println("Ingresa una nota");
          nota=leer.nextInt();
      }
      System.out.println("La nota es correcta");
    }
}
