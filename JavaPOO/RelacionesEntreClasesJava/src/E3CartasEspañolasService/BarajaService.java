/*
Realizar una baraja de cartas españolas orientada a objetos. Una carta tiene un número entre 1
y 12 (el 8 y el 9 no los incluimos) y un palo (espadas, bastos, oros y copas). Esta clase debe
contener un método toString() que retorne el número de carta y el palo. La baraja estará
compuesta por un conjunto de cartas, 40 exactamente.
Las operaciones que podrá realizar la baraja son:
• barajar(): cambia de posición todas las cartas aleatoriamente. OK
• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de
cartas. En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero
debemos indicárselo al usuario. OK
• siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o
se haya llegado al final, se indica al usuario que no hay más cartas. OK
• cartasDisponibles(): indica el número de cartas que aún se puede repartir. ok
• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
indicárselo al usuario ok


• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y
luego se llama al método, este no mostrara esa primera carta.
 */
package E3CartasEspañolasService;

import E3CartasEspaniolas.Carta;
import java.util.ArrayList;
import static java.util.Collections.shuffle;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class BarajaService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Carta> cartasEntregadas = new ArrayList();
    ArrayList<Carta> baraja = new ArrayList();

    public ArrayList<Carta> crearBaraja() {       
        String[] palos = {"Espadas", "Bastos", "Oro", "Copas"};

        for (String palo : palos) {
            for (int i = 0; i < 12; i++) {
                if (i + 1 == 8 || i + 1 == 9) {
                    continue; //SE SALTA EL 8 Y EL 9
                }
                Carta carta = new Carta();
                carta.setNum(i + 1);
                carta.setPalo(palo);
                baraja.add(carta);
            }
        }
        return baraja;
    }

    public ArrayList<Carta> barajar(ArrayList<Carta> baraja) {
        shuffle(baraja);
        return baraja;
    }

    public ArrayList<Carta> darCartas(ArrayList<Carta> baraja) {
        System.out.println("¿Cuántas cartas desea?");
        int n = leer.nextInt();
        int cont = 0;

        if (baraja.size() < n) {
            System.out.println("La cantidad solicitada es mayor a las cartas que quedan en la baraja. "
                    + "\n No se entregan cartas.");
        } else {

            Iterator<Carta> it = baraja.iterator();
            while (it.hasNext() && cont < n) {
                Carta carta = it.next();
                cartasEntregadas.add(carta);
                it.remove();
                cont++;
            }
        }
        return cartasEntregadas;
    }

    public ArrayList<Carta> siguienteCarta(ArrayList<Carta> baraja) {

        Iterator<Carta> it = baraja.iterator();
        boolean flag = true;

        while (it.hasNext() && flag == true) {
            Carta next = it.next();
            cartasEntregadas.add(next);
            it.remove();
            flag = false;
        }

        return cartasEntregadas;
    } //VERIFICAR CUANDO NO HAYAN MAS CARTAS PARA REPARTIR

    public void cartasDisponibles(ArrayList<Carta> baraja) {
        System.out.println("La cantidad de cartas que aún se pueden repartir es: " + baraja.size());
    }

    public void cartasMonton(ArrayList<Carta> cartasEntregadas) {
        if (cartasEntregadas.size() == 0) {
            System.out.println("Aún no se han entregado cartas");
        } else {
            System.out.println("Se han entregado " + cartasEntregadas.size() + " cartas, estas son:"
                    + "\n" + cartasEntregadas.toString());
        }

    }

    public void mostrarBaraja(ArrayList<Carta> baraja) {
        System.out.println("Actualmente esta es la baraja: "
                + "\n" + baraja.toString());
    }

    public void menu() {
        System.out.println("*** BIENVENIDO ***");
        System.out.println("** JUEGO DE CARTAS ESPAÑOLAS ** ");
        System.out.println("Baraja creada!");
        crearBaraja();
        System.out.println("");
        int input;
        System.out.println("------------------------------------");

        do {            
            System.out.println("Elige una opción del siguiente menú: "
                    + "\n 1 - Barajar"
                    + "\n 2 - Pedir varias cartas"
                    + "\n 3 - Pedir la siguiente carta "
                    + "\n 4 - Preguntar cuántas cartas quedan disponibles en la baraja"
                    + "\n 5 - Preguntar cuántas cartas y cuáles han sido entregadas"
                    + "\n 6 - Mostrar la baraja "
                    + "\n 7 - Salir");
            input = leer.nextInt();

            switch (input) {
                case 1:
                    barajar(baraja);
                    System.out.println("------------------------------------");
                    break;
                case 2:
                    darCartas(baraja);
                    System.out.println("------------------------------------");
                    break;
                case 3:
                    siguienteCarta(baraja);
                    System.out.println("------------------------------------");
                    break;
                case 4:
                    cartasDisponibles(baraja);
                    System.out.println("------------------------------------");
                    break;
                case 5:
                    cartasMonton(cartasEntregadas);
                    System.out.println("------------------------------------");
                    break;
                case 6:                    
                    mostrarBaraja(baraja);
                    System.out.println("------------------------------------");
                    break;
                case 7:
                    System.out.println("Bye!!!");
                    System.out.println("------------------------------------");
                    break;
                default:

            }

        } while (input != 7);

    }
}
