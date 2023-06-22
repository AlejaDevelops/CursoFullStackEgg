/*
Pongamos de lado un momento el concepto de POO, ahora vamos a trabajar solo con la
clase Date. En este ejercicio deberemos instanciar en el main, una fecha usando la clase
Date, para esto vamos a tener que crear 3 variables, dia, mes y anio que se le pedirán al
usuario para poner el constructor del objeto Date. Una vez creada la fecha de tipo Date,
deberemos mostrarla y mostrar cuantos años hay entre esa fecha y la fecha actual, que
se puede conseguir instanciando un objeto Date con constructor vacío.
Ejemplo fecha: Date fecha = new Date(anio, mes, dia);
Ejemplo fecha actual: Date fechaActual = new Date();
 */
package E11FechaDate;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class MainDate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner leer = new Scanner(System.in);
        
        int dia, mes, anio;
        
        System.out.println("Ingrese un día: ");
        dia = leer.nextInt();
        System.out.println("Ingrese un mes: ");
        mes = leer.nextInt();
        System.out.println("Ingrese un año: ");
        anio = leer.nextInt();
        
        Date fechaActual = new Date();
        Date fecha = new Date(fechaActual.getYear()+1900-anio, fechaActual.getMonth()+1-mes, fechaActual.getDate()-dia);       
        
        
        System.out.println("Hay " + fecha.getYear()+" años " + fecha.getMonth()+ " meses "+fecha.getDate()+" días "+" de diferencia.");
        System.out.println("La fecha actual es: " + fechaActual.toString());
    }
    
    
}
