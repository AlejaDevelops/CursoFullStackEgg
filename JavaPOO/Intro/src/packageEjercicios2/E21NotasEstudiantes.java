/*
Los profesores del curso de programación de Egg necesitan llevar un registro de las notas adquiridas por sus 10 alumnos
para luego obtener una cantidad de aprobados y desaprobados. Durante el periodo de cursado cada alumno obtiene 4 notas, 
2 por trabajos prácticos evaluativos y 2 por parciales. 
Las ponderaciones de cada nota son:
Primer trabajo práctico evaluativo 10%
Segundo trabajo práctico evaluativo 15%
Primer Integrador 25%
Segundo integrador 50%
Una vez cargadas las notas, se calcula el promedio y se guarda en el arreglo. 
Al final del programa los profesores necesitan obtener por pantalla la cantidad de aprobados y 
desaprobados, teniendo en cuenta que solo aprueban los alumnos con promedio mayor o igual al 7 de sus notas del curso.
 */
package packageEjercicios;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class E21NotasEstudiantes {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        System.out.println("*** CALCULADORA ESTUDIANTES APROBADOS ***");
        System.out.println("¿Qué cantidad de estudiantes deseas registrar?");
        int n = leer.nextInt();
        double[] promedioNotas = new double [n];
        System.out.println("Ingresa las notas de los estudiantes");        
      
        for (int i = 0; i < n; i++) {
            System.out.println("Notas estudiante "+(i+1));
            System.out.println("Primer trabajo práctico evaluativo");
            double nota1 = leer.nextDouble();
            System.out.println("Segundo trabajo práctico evaluativo");
            double nota2 = leer.nextDouble();
            System.out.println("Primer Integrador");
            double nota3 = leer.nextDouble();
            System.out.println("Segundo integrador");
            double nota4 = leer.nextDouble();
            
            double promedio = (nota1*0.1)+(nota2*0.15)+(nota3*0.25)+(nota4*0.5);
            promedioNotas[i] = promedio;
        }
        
        int contAprobados = 0;
        int contDesaprobados = 0;
        for (int i = 0; i < n; i++) {
            if (promedioNotas[i]>=7) {
                contAprobados++;
            } else {
                contDesaprobados++;
            }            
        }
        
        System.out.println("La cantidad de estudiantes aprobados es: "+contAprobados);
        System.out.println("La cantidad de estudiantes desaprobados es: "+contDesaprobados);
        
        
    }
            
}
