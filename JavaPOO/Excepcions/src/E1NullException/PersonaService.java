/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E1NullException;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class PersonaService {

    public Persona crearPersona() {
        Scanner leer = new Scanner(System.in);
        Persona pc = new Persona();
        boolean bandera = true;

        System.out.println("Ingresa el nombre de la persona");
        pc.setNombre(leer.nextLine());
        System.out.println("Ingresa su edad");
        pc.setEdad(leer.nextInt());

        //Validación elección Sexo
        do {
            System.out.println("Ingresa el sexo");
            System.out.println("M - Mujer");
            System.out.println("H - hombre");
            System.out.println("O - Otro");
            pc.setSexo(leer.next().charAt(0));

            if ("M".equalsIgnoreCase(Character.toString(pc.getSexo())) || "H".equalsIgnoreCase(Character.toString(pc.getSexo())) || "O".equalsIgnoreCase(Character.toString(pc.getSexo()))) {
                bandera = false;
            } else {
                System.out.println("Elección no válida, intenta nuevamente");
            }
        } while (bandera);

        System.out.println("Ingresa su estatura en metros");
        pc.setEstatura(leer.nextDouble());
        System.out.println("Ingresa su peso en kg");
        pc.setPeso(leer.nextDouble());

        return pc;
    }

    public int calcularIMC(Persona a) {
        int salida;

        a.setImc(a.getPeso() / Math.pow(a.getEstatura(), 2));

        if (a.getImc() < 20) {
            //Persona debajo de su peso ideal
            salida = -1;
        } else if (a.getImc() >= 20 && a.getImc() <= 25) {
            //la persona está en su peso ideal
            salida = 0;
        } else {
            //La persona tiene sobrepeso
            salida = 1;
        }

        return salida;
    }

    public boolean esMayorDeEdad(Persona b) {
        boolean salida = false;

        if (b.getEdad() >= 18) {
            //le persona es mayor de edad
            salida = true;
        }

        return salida;
    }
}
