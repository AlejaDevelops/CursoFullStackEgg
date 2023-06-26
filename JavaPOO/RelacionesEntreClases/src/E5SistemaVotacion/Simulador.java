/*
Desarrollar un simulador del sistema de votación de facilitadores en Egg-
El sistema de votación de Egg tiene una clase llamada Alumno con los siguientes atributos:
nombre completo, DNI y cantidad de votos. 

Además, crearemos una clase Simulador que va a
tener los métodos para manejar los alumnos y sus votaciones. Estos métodos serán llamados
desde el main.
• La clase Simulador debe tener un método que genere un listado de alumnos manera
aleatoria y lo retorne. Las combinaciones de nombre y apellido deben ser generadas de
manera aleatoria. Nota: usar listas de tipo String para generar los nombres y los apellidos.
• Ahora hacer un generador de combinaciones de DNI posibles, deben estar dentro de un
rango real de números de documentos. Y agregar a los alumnos su DNI. Este método
debe retornar la lista de dnis.
• Ahora tendremos un método que, usando las dos listas generadas, cree una cantidad de
objetos Alumno, elegidos por el usuario, y le asigne los nombres y los dnis de las dos
listas a cada objeto Alumno. No puede haber dos alumnos con el mismo dni, pero si con el
mismo nombre.
• Se debe imprimir por pantalla el listado de alumnos.
• Una vez hecho esto debemos generar una clase Voto, esta clase tendrá como atributos,
un objeto Alumno que será el alumno que vota y una lista de los alumnos a los que votó.
• Crearemos un método votación en la clase Simulador que, recibe el listado de alumnos y
para cada alumno genera tres votos de manera aleatoria. En este método debemos
guardar a el alumno que vota, a los alumnos a los que votó y sumarle uno a la cantidad de
votos a cada alumno que reciba un voto, que es un atributo de la clase Alumno.
Tener en cuenta que un alumno no puede votarse a sí mismo o votar más de una vez al
mismo alumno. Utilizar un hashset para resolver esto.
• Se debe crear un método que muestre a cada Alumno con su cantidad de votos y cuales
fueron sus 3 votos.
• Se debe crear un método que haga el recuento de votos, este recibe la lista de Alumnos y
comienza a hacer el recuento de votos.



• Se deben crear 5 facilitadores con los 5 primeros alumnos votados y se deben crear 5
facilitadores suplentes con los 5 segundos alumnos más votados. A continuación, mostrar
los 5 facilitadores y los 5 facilitadores suplentes.
 */
package E5SistemaVotacion;

import E5SstemaVotacionComparadores.Comparadores;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class Simulador {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Random r = new Random();

    public ArrayList<Alumno> crearListaAlumnos() {
        ArrayList<Alumno> listaAlumnos = new ArrayList();

        System.out.println("Qué cantidad de alumnos deseas generar?");
        int n = leer.nextInt();

        ArrayList<String> listaNombres = crearNombre(n);
        ArrayList<Long> listaDnis = crearDnis(n);

        for (Long aux : listaDnis) {
            Alumno alumno = new Alumno();
            alumno.setDni(aux);
            alumno.setNombreCompleto(listaNombres.get(r.nextInt(listaNombres.size())));
            alumno.setCantVotos(0);
            listaAlumnos.add(alumno);
        }

        return listaAlumnos;
    }

    public ArrayList<String> crearNombre(int n) {
        String[] Nombres = {"Juan", "María", "Carlos", "Ana", "Pedro", "Laura", "Luis", "Sofía", "Miguel", "Elena"};
        String[] Apellidos = {"González", "Rodríguez", "López", "Martínez", "Pérez", "García", "Sánchez", "Romero", "Fernández", "Torres"};
        ArrayList<String> listaNombres = new ArrayList();
        String nombre, apellido;
        for (int i = 0; i < n; i++) {
            nombre = Nombres[r.nextInt(Nombres.length)];
            apellido = Apellidos[r.nextInt(Apellidos.length)];
            listaNombres.add(nombre + " " + apellido);
        }
        return listaNombres;
    }

    public ArrayList<Long> crearDnis(int n) {
        long dni;
        HashSet<Long> dniSet = new HashSet();
        ArrayList<Long> dniList = new ArrayList();

        while (dniSet.size() < n) {
            dni = r.nextInt(90000000) + 42000000;
            dniSet.add(dni);
        }
        dniList.addAll(dniSet);

        return dniList;
    }

    public void imprimirListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        for (Alumno aux : listaAlumnos) {
            System.out.println(aux);
        }

    }

    public void votacionManual(ArrayList<Alumno> listaAlumnos) {

        for (Alumno alumno : listaAlumnos) {//Recorriendo uno a uno la lista de alumnos
            System.out.println("Hola " + alumno.getNombreCompleto() + " DNI: " + alumno.getDni() + ", es tu turno de votar. Recuerda que debes votar por 3 personas diferentes. "
                    + "\n Esta es la lista de los alumnos por los que puedes votar: ");
            ArrayList<Alumno> listaAlumnoAux = new ArrayList(listaAlumnos); //Guardando la lista de alumnos completa                               
            listaAlumnoAux.remove(alumno); //Removiendo el alumno que está votando de la lista auxiliar
            imprimirListaAlumnos(listaAlumnoAux);
            System.out.println("");

            Voto voto = new Voto();
            voto.setAlumnoVotante(alumno);
            ArrayList<Alumno> alumnosVotadosLista = new ArrayList();
            int cont = 0;

            do {
                System.out.println("Escribe el DNI de la persona por la que deseas votar");
                long dniParaVotar = leer.nextLong();
                boolean flag = true;

                for (Alumno aux1 : listaAlumnoAux) { //Recorriendo la lista auxiliar, que no contiene el alumno que está votando 
                    if (aux1.getDni() == dniParaVotar) {
                        aux1.setCantVotos(aux1.getCantVotos() + 1); //Actualizo la cantidad de votos en aux1                                             
                        alumnosVotadosLista.add(aux1);//Se acumulan las personas por las que vota en alumnosVotadosLista
                        listaAlumnoAux.remove(aux1); // y es elimina la persona por la que se votó de listaAlumnoAux para evitar votar por la misma persona varias veces                        
                        cont++; //Contador para controlar la salida del do-while que se encarga de controlar el numero de votación por persona
                        flag = false;
                        break; //Una vez se vota, es decir cuando se cumple la condición del if línea 134, se sale del For linea 132 y deja de recorrer la listaAlumnoAux
                    }
                }
                if (flag) {
                    System.out.println("El DNI ingresado no es válido, porque no es Alumno registrado o porque ya votaste por él... intenta nuevamente");
                }
            } while (cont < 3);
            voto.setAlumnosConVotos(alumnosVotadosLista); //Se setea la lista de personas por las que votó
            imprimirVotosIndividuales(voto.getAlumnosConVotos());
            for (Alumno alumnosConVoto : voto.getAlumnosConVotos()) { //Se actualizan los votos en la listaAlumnos
                for (Alumno alumno2 : listaAlumnos) {
                    if (alumno2.getDni() == alumnosConVoto.getDni()) {
                        alumno2.setCantVotos(alumnosConVoto.getCantVotos());
                        break;
                    }
                }
            }
        }
    }

    public void votacionAutomatica(ArrayList<Alumno> listaAlumnos) {
        for (Alumno alumno : listaAlumnos) {//Recorriendo uno a uno la lista de alumnos
            System.out.println("Hola " + alumno.getNombreCompleto() + " DNI: " + alumno.getDni() + ", es tu turno de votar. Recuerda que debes votar por 3 personas diferentes. "
                    + "\n Esta es la lista de los alumnos por los que puedes votar: ");
            ArrayList<Alumno> listaAlumnoAux = new ArrayList(listaAlumnos); //Guardando la lista de alumnos completa                               
            listaAlumnoAux.remove(alumno); //Removiendo el alumno que está votando de la lista auxiliar
            imprimirListaAlumnos(listaAlumnoAux);
            System.out.println("");

            Voto voto = new Voto();
            voto.setAlumnoVotante(alumno);
            ArrayList<Alumno> alumnosVotadosLista = new ArrayList();
            int cont = 0;

            do {
                System.out.println("El sistema está eligiendo el DNI de la personaa a votar...");                
                long dniParaVotar = listaAlumnoAux.get(r.nextInt(listaAlumnoAux.size())).getDni();
                boolean flag = true;

                for (Alumno aux1 : listaAlumnoAux) { //Recorriendo la lista auxiliar, que no contiene el alumno que está votando 
                    if (aux1.getDni() == dniParaVotar) {
                        aux1.setCantVotos(aux1.getCantVotos() + 1); //Actualizo la cantidad de votos en aux1                                             
                        alumnosVotadosLista.add(aux1);//Se acumulan las personas por las que vota en alumnosVotadosLista
                        listaAlumnoAux.remove(aux1); // y es elimina la persona por la que se votó de listaAlumnoAux para evitar votar por la misma persona varias veces                        
                        cont++; //Contador para controlar la salida del do-while que se encarga de controlar el numero de votación por persona
                        flag = false;
                        break; //Una vez se vota, es decir cuando se cumple la condición del if línea 1, se sale del For linea 178 y deja de recorrer la listaAlumnoAux
                    }
                }
                if (flag) {
                    System.out.println("El DNI ingresado no es válido, porque no es Alumno registrado o porque ya votaste por él... intenta nuevamente");
                }
            } while (cont < 3);
            voto.setAlumnosConVotos(alumnosVotadosLista); //Se setea la lista de personas por las que votó
            imprimirVotosIndividuales(voto.getAlumnosConVotos());
            for (Alumno alumnosConVoto : voto.getAlumnosConVotos()) { //Se actualizan los votos en la listaAlumnos
                for (Alumno alumno2 : listaAlumnos) {
                    if (alumno2.getDni() == alumnosConVoto.getDni()) {
                        alumno2.setCantVotos(alumnosConVoto.getCantVotos());
                        break;
                    }
                }
            }
        }
    }

    public void imprimirVotosIndividuales(ArrayList<Alumno> AlumnosConVotos) {
        System.out.println("Te confirmo que has votado por: ");
        imprimirListaAlumnos(AlumnosConVotos);
        System.out.println("-----------------------------------------------------------------");
    }

    public void recuentoVotos(ArrayList<Alumno> listaAlumnos) {
        Collections.sort(listaAlumnos, Comparadores.ordenarPorCantVotos);
        System.out.println("Todos los alumnos han votado, este es el resultado final: ");
        imprimirListaAlumnos(listaAlumnos);
        ArrayList<Alumno> facilitadores = new ArrayList();
        ArrayList<Alumno> facilitadoresSuplentes = new ArrayList();

        System.out.println("\n*** Los Facilitadores son: ");
        facilitadores.addAll(listaAlumnos.subList(0, 5));
        imprimirListaAlumnos(facilitadores);
        System.out.println("\n*** Los Facilitadores Suplentes son: ");
        facilitadoresSuplentes.addAll(listaAlumnos.subList(5, 10));
        imprimirListaAlumnos(facilitadoresSuplentes);
    }

}
