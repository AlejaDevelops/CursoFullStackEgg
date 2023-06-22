/*
Escribir un programa en Java que juegue con el usuario a adivinar un número. La computadora
debe generar un número aleatorio entre 1 y 500, y el usuario tiene que intentar adivinarlo. Para
ello, cada vez que el usuario introduce un valor, la computadora debe decirle al usuario si el
número que tiene que adivinar es mayor o menor que el que ha introducido el usuario. Cuando
consiga adivinarlo, debe indicárselo e imprimir en pantalla el número de veces que el usuario
ha intentado adivinar el número. Si el usuario introduce algo que no es un número, se debe
controlar esa excepción e indicarlo por pantalla. En este último caso también se debe contar el
carácter fallido como un intento.
 */
package E5AdivinaElNumero;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class AdivinaElNumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("*** Adivina el número *** \n");
        int n = (int) (Math.random() * (499) + 1);
        System.out.println("El sistema acaba de escoger un número..." + n);

        int input = 0;
        int cont = 0;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        do {
            System.out.println("Ingresa el número que crees el sistema escogió");
            try {                
                input = leer.nextInt();
                cont++;

                if (input > n) {
                    System.out.println("El número ingresado es mayor al escogido por el sistema, sigue intentando");
                } else if (input < n && input > 0) {
                    System.out.println("El número ingresado es menor al escogido por el sistema, sigue intentando");
                }
            } catch (InputMismatchException e) {
                System.out.println("El caracter ingresado no es un número, intenta nuevamente");
                cont++;
                leer.nextLine(); //Corrección del input?
            }

        } while (input != n);

        System.out.println("Felicitaciones! Has adivinado el número."
                + "\n Cantidad de intentos: " + cont);

    }

}
