/*
Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y
Revolver
Métodos:
• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
y el revolver para guardarlos en los atributos del juego.

• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
 */
package E2RuletaRusaAguaService;

import E2RuletaRusaAgua.Juego;
import E2RuletaRusaAgua.Jugador;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class JuegoService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Juego llenarJuego() {
        ArrayList<Jugador> listaJ = new ArrayList();
        RevolverService rs = new RevolverService();
        Juego juego = new Juego();
        System.out.println("------------------------------");
        System.out.println("*** Registro de jugadores *** ");
        System.out.println("Indica la cantidad de jugadores");
        int n = leer.nextInt();
        if (n < 1 && n > 6) {
            n = 6;
            System.out.println("Número inválido. Se asignarán 6 jugadores");
        }

        for (int i = 0; i < n; i++) {
            Jugador j = new Jugador();
            System.out.println("*** Ingresa el nombre del jugador " + (i + 1));
            j.setNombre(leer.next());
            System.out.println("El número asignado al jugador es " + (i + 1));
            j.setId(i + 1);
            j.setMojado(false);
            listaJ.add(j);
        }
        System.out.println("------------------------------");
        juego.setJugadores(listaJ);
        juego.setR(rs.llenarRevolver());  //Llenado inicial, ocurre solo una vez, al inicio del juego
        System.out.println(juego.getR().toString()); //Impresión de las Posiciones iniciales a modo de prueba
        //System.out.println(juego.getJugadores().toString());//Impresión de los jugadores a modo de prueba
        return juego;
    }

    public void ronda(Juego game) {
        ArrayList<Jugador> gamers = game.getJugadores();
        boolean output = true;
        boolean flag = true;
        JugadorService js = new JugadorService();

        do {
            for (Jugador gamer : gamers) {
                System.out.println("Es el turno del " + gamer.toString());
                System.out.println("Posición actual : " + game.getR().getPosicionActual());
                output = js.disparo(game.getR()); //Se guarda la salida del método disparo, que evalúa si posición del agua y posición actual son iguales (método mojar) y devuelve false si son iguales, es decir si se "mojó" o true en caso contrario, además de aumentar en una posición la posición actual solo cuando ocurra true. Cuando ocurra true se puede seguir jugando
                if (output) {
                    gamer.setMojado(!output);
                } else {
                    gamer.setMojado(!output);
                    System.out.println("El jugador que se ha mojado ha sido: " + gamer.toString());
                    break;                    
                }
            }
            if (!output) {
                flag = false;
            }
        } while (flag);

        System.out.println("Fin del juego!");

    }
}
