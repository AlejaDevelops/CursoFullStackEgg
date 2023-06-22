
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
public class Ejercicio11Guia7 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribe una frase terminada en punto");
        String frase = leer.nextLine();
        System.out.println("=====================================");
        System.out.println("");
        System.out.println("Frase encriptada: ");
        
        
        System.out.println(encriptarFrase(frase));

    
    }
    
    public static String encriptarFrase(String frase){
        int longF = frase.length();
        String nuevaFrase="";
        
        for (int i = 0; i < longF; i++) {
            String letra = String.valueOf(frase.charAt(i));
            switch (letra){
                case "a":
                    letra="@";
                    nuevaFrase +=letra;
                    break;        
                case "e":
                    letra="#";
                    nuevaFrase +=letra;
                    break;
                case "i":
                    letra="$";
                    nuevaFrase +=letra;
                    break;
                case "o":
                    letra="%";
                    nuevaFrase +=letra;
                    break;
                case "u":
                    letra="*";
                    nuevaFrase +=letra;
                    break;
                default:
                     nuevaFrase +=letra;

            }
        }
        
        return nuevaFrase;
    }
          
}
