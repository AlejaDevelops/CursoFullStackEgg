/*
Defina una clase llamada DivisionNumero. En el método main utilice un Scanner para leer dos
números en forma de cadena. A continuación, utilice el método parseInt() de la clase Integer,
para convertir las cadenas al tipo int y guardarlas en dos variables de tipo int. Por ultimo realizar
una división con los dos numeros y mostrar el resultado.
 */
package E3_E4DivisionNumero;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class DivisionNumeroMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresa dos números: ");

        try {
            String n1 = leer.nextLine();
            String n2 = leer.nextLine();
            int num1 = Integer.parseInt(n1);
            int num2 = Integer.parseInt(n2);
            int division = num1 / num2;
            System.out.println(n1 + "/" + n2 + " = " + (num1 / num2));
        } catch (ArithmeticException e) {
            System.out.println("Error, no se puede dividir entre cero");

        } catch (NumberFormatException f) {
            System.out.println("Al menos un caracter ingresado no es un número");
        } catch (InputMismatchException g) {
            System.out.println("El dato ingresado no es de tipo String"); //Error no admitido
        }

        System.out.println("Se sigue ejecutando el resto de código...");

    }

}
