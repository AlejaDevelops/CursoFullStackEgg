/*
Crea una aplicación que le pida dos números al usuario y este pueda elegir 
entre sumar, restar, multiplicar y dividir. La aplicación debe tener 
una función para cada operación matemática y deben devolver sus resultados 
para imprimirlos en el main.
 */
package packageEjercicios;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class E15CalculadoraMath {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int eleccion;
        System.out.println("*** CALCULADORA OPERACIONES BASICAS ***");

        do {
            System.out.println("-----------------------------------------------------");
            System.out.println("Selecciona la operación matemática que deseas realizar: ");
            System.out.println("1 - Suma");
            System.out.println("2 - Resta");
            System.out.println("3 - Multiplicación");
            System.out.println("4 - División");
            System.out.println("5 - Salir");
            //Lectura de la operación elegida
            eleccion = leer.nextInt();

            //Validación de la operación elegida
            if (eleccion == 5) {
                System.out.println("Saliste de la calculadora :(");
                break;
            }
            while (eleccion < 1 || eleccion > 5) {
                System.out.println("Elección no válida, por favor intenta nuevamente");
                eleccion = leer.nextInt();
            }
            System.out.println("Elección válida :)");

            //Solicitud de números
            System.out.println("Ingresa el primer número: ");
            int n1 = leer.nextInt();
            System.out.println("Ingresa el segundo número: ");
            int n2 = leer.nextInt();

            //Validación de denominador para evitar división entre 0
            if (n2 == 0 && eleccion == 4) {
                while (n2 == 0) {
                    System.out.println("No se puede dividir entre 0");
                    System.out.println("Ingresa el segundo número nuevamente: ");
                    n2 = leer.nextInt();

                }
                System.out.println("Denominador válido :)");
            }
            System.out.println(" ");

            //Llamado de operaciones
            switch (eleccion) {
                case 1:
                    System.out.println("La suma de ambos números es " + calcularSuma(n1, n2));
                    break;
                case 2:
                    System.out.println("La resta de ambos números es " + calcularResta(n1, n2));
                    break;
                case 3:
                    System.out.println("La multiplicación de ambos números es " + calcularMultiplicacion(n1, n2));
                    break;
                case 4:
                    System.out.println("La división del primer número entre el segundo es " + calcularDivision(n1, n2));
                    break;
            }
        } while (eleccion != 5);

    }

    public static int calcularSuma(int num1, int num2) {
        return num1 + num2;
    }

    public static int calcularResta(int num1, int num2) {
        return num1 - num2;
    }

    public static int calcularMultiplicacion(int num1, int num2) {
        return num1 * num2;
    }

    public static int calcularDivision(int num1, int num2) {
        return num1 / num2;
    }

}
