/*
Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos
usaremos un conjunto. El programa pedirá un país en un bucle, se guardará el país en el
conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir,
si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer
los servicios en la clase correspondiente)
Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar
cómo se ordena un conjunto.

Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se
buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
al usuario.
 */
package E5Paises;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author AlejaDevelops
 */
public class PaisesService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public TreeSet<String> guardarPaises() {
        TreeSet<String> setPaises = new TreeSet();
        String option;
        do {
            System.out.println("Ingresa un pais");
            setPaises.add(leer.nextLine());
            System.out.println("¿Deseas ingresar otro pais?");
            option = leer.nextLine();
        } while (option.equalsIgnoreCase("si"));

        imprimirSet(setPaises);
        return setPaises;
    }

    public void imprimirSet(TreeSet<String> a) {
        System.out.println("Los paises que se encuentran en el conjunto son: ");
        for (String aux : a) {
            System.out.println(aux);
        }
    }

    public void eliminarPais(TreeSet<String> a) {
        System.out.println("Ingresa el nombre del pais que deseas eliminar");
        String pais = leer.nextLine();
        Iterator it = a.iterator();
        boolean flag = true;
        while (it.hasNext()) {
            if (it.next().equals(pais)) {
                it.remove();
                flag = false;
                System.out.println("Pais eliminado");
            }       
        }
        if (flag) {
            System.out.println("El pais ingresado no se encuentra en el conjunto");
        }
        imprimirSet(a);
    }
}
