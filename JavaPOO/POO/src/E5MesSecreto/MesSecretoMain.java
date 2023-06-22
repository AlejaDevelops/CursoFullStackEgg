/*
Crea una clase en Java donde declares una variable de tipo array de Strings que
contenga los doce meses del año, en minúsculas. A continuación, declara una variable
mesSecreto de tipo String, y hazla igual a un elemento del array (por ejemplo,
mesSecreto = mes[9]. El programa debe pedir al usuario que adivine el mes secreto. Si el
usuario acierta mostrar un mensaje, y si no lo hace, pedir que vuelva a intentar adivinar
el mes secreto. Un ejemplo de ejecución del programa podría ser este:
Adivine el mes secreto. Introduzca el nombre del mes en minúsculas: febrero
No ha acertado. Intente adivinarlo introduciendo otro mes: agosto
¡Ha acertado!
 */
package E5MesSecreto;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class MesSecretoMain {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        MesSecretoService ms = new MesSecretoService();
        MesSecreto mesSecreto = ms.elegirMes();
        
        System.out.println("*** JUEGA ADIVINA EL MES ***");
        System.out.println("El programa ha elegido un mes que debes adivinar");
        System.out.println(mesSecreto.getMesSecreto());
        System.out.println("Introduce el nombre del mes en minúsculas");
        String eleccion = leer.nextLine();
        
        if (!eleccion.equalsIgnoreCase(mesSecreto.getMesSecreto())) {
            do {      
                System.out.println("No has acertado");
                System.out.println("Intenta adivinarlo introduciendo otro mes:");
                eleccion = leer.nextLine();
    
            } while (!eleccion.equalsIgnoreCase(mesSecreto.getMesSecreto()));            
        }
           
        System.out.println("¡Has acertado!");
        
        
    }
}
