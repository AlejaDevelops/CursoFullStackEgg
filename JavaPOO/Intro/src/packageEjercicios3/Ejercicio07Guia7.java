
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
public class Ejercicio07Guia7 {
    public static void main(String[] args) {
        int motor;
        Scanner leer=new Scanner(System.in);
        System.out.println("Ingresa el tipo de motor entre 1 y 4");
        
        motor=leer.nextInt();
        switch(motor){
            case 1: 
                System.out.println("La bomba es una bomba de agua");
                break;
            case 2:
                System.out.println("La bomba es una bomba de gasolina");
                break;
            case 3:
                System.out.println("La bomba es una bomba de hormigón");
                break;
            case 4:
                System.out.println("La bomba es una bomba de alimenticia");
                break;
            default:
                System.out.println("No existe un valor válido para tipo de bomba");
            }
        }
                
}

