/*
Clase Jugador: esta clase posee los siguientes atributos: id (representa el número del
jugador), nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (indica
si está mojado o no el jugador). El número de jugadores será decidido por el usuario, pero
debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.

Métodos:
• disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
revolver tira el agua, el jugador se moja.

El atributo mojado pasa a false y el método devuelve true, sino false.
 */
package E2RuletaRusaAguaService;

import E2RuletaRusaAgua.Revolver;



/**
 *
 * @author AlejaDevelops
 */
public class JugadorService {
    public boolean disparo(Revolver r){
        RevolverService rs = new RevolverService();      
        
        if (rs.mojar(r)) {
            System.out.println("Te has mojado, has perdido! :( ");
            return false;
            
        } else{
            rs.siguienteChorro(r);
            System.out.println("No te has mojado! Sigue el juego!");
            System.out.println("-----------------------------------------------");
            return true;
        } 
    }

    
}
