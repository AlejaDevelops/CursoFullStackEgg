/*
Nos piden hacer un programa sobre un Cine, que tiene una sala con un conjunto de asientos
(8 filas por 6 columnas). 
--- De Cine nos interesa conocer la película que se está reproduciendo, la sala con los espectadores y el precio de la entrada. 
--- Luego, de las películas nos interesa saber el título, duración, edad mínima y director. 
--- Por último, del espectador, nos interesa saber su nombre, edad y el dinero que tiene disponible.
Para representar la sala con los espectadores vamos a utilizar una matriz. Los asientos son
etiquetados por una letra y un número la fila A1 empieza al final del mapa como se muestra en
la tabla. También deberemos saber si el asiento está ocupado por un espectador o no, si esta
ocupado se muestra una X, sino un espacio vacío.
8 A X | 8 B X | 8 C X | 8 D | 8 E X | 8 F X
7 A X | 7 B X | 7 C X | 7 D X | 7 E | 7 F X
6 A X | 6 B X | 6 C | 6 D X | 6 E X | 6 F
5 A X | 5 B X | 5 C X | 5 D X | 5 E X | 5 F X
4 A X | 4 B X | 4 C X | 4 D X | 4 E X | 4 F X
3 A X | 3 B X | 3 C X | 3 D | 3 E X | 3 F X
2 A X | 2 B | 2 C X | 2 D X | 2 E X | 2 F
1 A X | 1 B X | 1 C X | 1 D X | 1 E X | 1 F X
Se debe realizar una pequeña simulación, en la que se generen muchos espectadores y se los
ubique en los asientos aleatoriamente (no se puede ubicar un espectador donde ya este
ocupado el asiento).
Los espectadores serán ubicados de uno en uno y para ubicarlos tener en cuenta que sólo se
podrá sentar a un espectador si tiene el dinero suficiente para pagar la entrada, si hay espacio
libre en la sala y si tiene la edad requerida para ver la película. En caso de que el asiento este
ocupado se le debe buscar uno libre.
Al final del programa deberemos mostrar la tabla, podemos mostrarla con la letra y numero de
cada asiento o solo las X y espacios vacíos.
 */
package E4SalaDeCineService;

import E4SalaDeCine.Cine;
import E4SalaDeCine.Espectador;
import E4SalaDeCine.Pelicula;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class CineService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Cine crearFuncion() {
        PeliculaService ps = new PeliculaService();
        ArrayList<Pelicula> listaPelis = ps.crearPeliculas();
        Cine funcion = new Cine();
        String[][] sala = new String[8][6];
        boolean flag = true;

        //SETEO DE PELICULA
        do {
            System.out.println("Elige una pelicula de la lista y escribe su nombre: ");
            System.out.println(listaPelis);
            String nombreP = leer.nextLine();
            for (Pelicula aux : listaPelis) {
                if (aux.getFilmName().equalsIgnoreCase(nombreP)) {
                    funcion.setFilm(aux);
                    flag = false;
                    break;

                }
            }
            if (flag) {
                System.out.println("Título ingresado inválido. Intenta nuevamente");
            }
        } while (flag);

        //SETEO DEL COSTO DE LA ENTRADA
        funcion.setMovieTicketCost(Math.random() * 20);
        System.out.println("Se está cargando el costo de la entrada..."
                + "\n El costo de la entrada a esta función es $" + funcion.getMovieTicketCost());

        //SETEO DE LA MATRIZ CON LA NUMERACION DE LAS SILLAS 
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < 6; j++) {
                sala[i][j] = (8 - i) + "" + (char) ('A' + j) + "_";
            }
        }
        funcion.setAudience(sala);
        System.out.println("--------------------------------------");

        return funcion;
    }

    public boolean imprimirSala(String[][] matrizSala) { //Devuelve true si encuentra asientos vacíos
        boolean flag = false;
        for (String[] matrizSala1 : matrizSala) {
            for (int j = 0; j < 6; j++) {
                if (matrizSala1[j].endsWith("_")) {
                    System.out.print(matrizSala1[j] + " | ");
                    flag = true;
                } else {
                    System.out.print(matrizSala1[j] + "| ");
                }
            }
            System.out.println("");
        }
        return flag;
    }

    public String[][] asignarAsiento(String[][] matrizSala) {//Devuelve la Matriz Sala con el asiento asignado o marcado con X
        int posI, posJ;
        System.out.println("El sistema escogerá un asiento para ti...");
        boolean flag, ocupado;
        do {
            posI = (int) (Math.random() * 8);
            posJ = (int) (Math.random() * 6);
            System.out.println("Posible asiento: " + matrizSala[posI][posJ]);
            ocupado =  matrizSala[posI][posJ].endsWith("X");
            System.out.println("El asiento está ocupado? " +ocupado);
            if (!matrizSala[posI][posJ].endsWith("X")) {
                System.out.println("El asiento asignado es: " + matrizSala[posI][posJ]);
                matrizSala[posI][posJ] = matrizSala[posI][posJ] + "X";
                flag = true;                
            } else {
                System.out.println("El sistema te buscará otro asiento");
                flag = false;
            }
        } while (!flag);
        return matrizSala;

    }

    public void llenarSala(Cine funcion) { //Llena la sala con su código y llamando a los otros métodos
        EspectadorService es = new EspectadorService();
        ArrayList<Espectador> listaEspectadores = es.crearEspectadores();
        System.out.println(listaEspectadores.size());
        String[][] matrizAux = funcion.getAudience();
        boolean asientosVacios;
        boolean salir = false;
        int cont = 0;
        int contA = 0;
        int contB = 0;

        for (Espectador aux : listaEspectadores) {

            if (aux.getMoney() >= funcion.getMovieTicketCost() && aux.getAge() >= funcion.getFilm().getMinAge()) {
                contA++;
                System.out.println("¡Hola " + aux.getName() + "! Esta es la sala, los asientos libres estan marcados con _ ");
                asientosVacios = imprimirSala(matrizAux);
                if (asientosVacios) {
                    funcion.setAudience(asignarAsiento(matrizAux));
                    contB++;
                    System.out.println("--------------------------------------");
                } else {
                    System.out.println("Lo siento, no quedan asientos disponibles...");
                    salir = true;
                }
            } else {
                System.out.print("Lo siento " + aux.getName() + ", no puedes ingresar a la sala porque");
                cont++;
                if (aux.getAge() < funcion.getFilm().getMinAge()) {
                    System.out.println(" no tienes suficiente edad para ver esta película :( ");
                }
                if (aux.getMoney() < funcion.getMovieTicketCost()) {
                    System.out.println(" no tienes suficiente dinero :( ");
                }
                System.out.println("--------------------------------------");
            }

            if (salir) {
                break;
            }
        }

        System.out.println("Así quedó la sala antes de iniciar la función:");
        imprimirSala(funcion.getAudience());
        System.out.println("Personas que cumplen con las condiciones para entrar: " + contA 
                + "\nPersonas que no pudieron ingresar: " + cont
                + "\nContador de sillas ocupadas: " + contB
                +"\n*********************");
        
              
    }

}


