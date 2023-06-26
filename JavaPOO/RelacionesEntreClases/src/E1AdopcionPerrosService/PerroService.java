/*
Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro programa va a
tener que contar con muchas personas y muchos perros. El programa deberá preguntarle a
cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden adoptar
al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la
persona.
Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las
personas con sus respectivos perros.
 */
package E1AdopcionPerrosService;

import E1AdopcionPerro.Perro;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author AlejaDevelops
 */
public class PerroService {

    public ArrayList<Perro> crearPerros() { //SE DEBE CORREGIR EL DUPLICADO DE LOS NOMBRES
        ArrayList<Perro> listaPerros = new ArrayList();
        int n;
        String[] nombresPerros = {"Luna", "Pachito", "Lola", "Chiquito", "Pluto", "Drack", "Pulgoso", "Firulais", "Bruno", "Pepe"};
        String[] razas = {"Labrador", "Poodle", "Bulldog", "Golden Retriever", "Chihuahua", "Husky", "Boxer", "Dalmata", "Pastor Alemán", "Bichón Frisé"};
        String[] tamanios = {"Pequeño", "Mediano", "Grande", "Extra Grande", "Pequeño", "Grande", "Mediano", "Extra Grande", "Mediano", "Grande"};
        Random random = new Random();

        for (int i = 0; i < nombresPerros.length; i++) {
            Perro p = new Perro();
            p.setNombre(nombresPerros[i]);
            p.setRaza(razas[random.nextInt(razas.length)]);
            p.setEdad(random.nextInt(18) + 1);
            p.setTamanio(tamanios[random.nextInt(tamanios.length)]);
            listaPerros.add(p);
        }

        return listaPerros;
    }
}
