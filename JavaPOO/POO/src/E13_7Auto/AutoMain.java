/*
Crea una clase Auto. Como atributos tendrá nombre del dueño, fecha vencimiento carnet, color del
vehículo, modelo y KM en motor (deberá ser inicializado por defecto en 7500km),
Crear métodos que permitan:
● Que un usuario cargue su ficha del auto.
● Que el usuario, modifique la titularidad del vehículo.
● Indicar un trayecto recorrido, modificando de este modo los KM del motor
● Crear un método que indique si es necesario realizar Service al vehículo, considerando que
al llegar a los 10.000km corresponde realizarlo.
 */
package E13_7Auto;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class AutoMain {
    public static void main(String[] args) {
        System.out.println("*** FICHA AUTOS ***");
        Scanner leer = new Scanner(System.in);
        AutoService as = new AutoService();
        Auto auto1 = as.crearFicha();
        
        System.out.println("---------------------------");
        System.out.println("¿Deseas modificar los datos del titular? Si/No");
        String option = leer.nextLine();
        if (option.equalsIgnoreCase("SI")) {
            as.modificarTitular(auto1);
        }
        System.out.println("");
        as.recorrido(auto1);
        System.out.println("---------------------------");
        as.imprimirFicha(auto1);
        as.alertaServicio(auto1);
        
    }
}
