/*
 * Diseñe una función que pida el nombre y la edad de N personas e imprima 
los datos de las personas ingresadas por teclado e indique si son mayores 
o menores de edad. Después de cada persona, el programa debe preguntarle 
al usuario si quiere seguir mostrando personas y frenar cuando el usuario ingrese la palabra “No”.
 */
package packageEjercicios;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class E16MayoresEdad {

   
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String input;
        StringBuilder sb = new StringBuilder();
        
        //Encabezado
        System.out.println("*** CALCULO DE PERSONAS MAYORES DE EDAD ***");
        System.out.println("-----------------------------------------");
        
        do {
            //Regristro de datos por el usuario
            System.out.println("Ingresa el nombre de la persona: ");
            String nombre = leer.next();
            System.out.println("Ahora escribe su edad: ");
            int edad = leer.nextInt();
            
            
            //La instancia StringBuilder almacena varias cadenas recibidas por teclado 
            //y las guarda dentro de una sola variable del ciclo if
            // El método append() permite guardar cada cadena en la instancia sb
            if (edad>=0 && edad<18) {
                sb.append(nombre + " -    " + edad + "    - No \n");
                
            } else {
                sb.append(nombre + " -    " + edad + "    - Si \n");
            }
            
                    

            
            System.out.println("¿Deseas ingresar otro dato?");
            input = leer.next();
            
        } while (!input.equalsIgnoreCase("no") );
        
        String listado = sb.toString();
        System.out.println("-----------------------------");
        System.out.println("NOMBRE  EDAD  MAYOR DE EDAD \n" + listado);
        
        
    }
    
}
