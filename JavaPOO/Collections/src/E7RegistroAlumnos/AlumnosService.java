/*
Crea una clase Alumnos, donde tendrá como Atributos el nombre, apellido, la nacionalidad y su fecha de nacimiento. La nacionalidad podrá ser ARGENTINA – CHILENA – VENEZOLANA solamente.
Necesidades:
 Crear los métodos de A – B -M (Alta – Baja – modificación ) que manipulen los objetos de este tipo.
 Crear una lista de 20 alumnos (hacer uso del constructor que recibe parámetros , para no hacer carga manual de los datos)
 Ordenar y mostrar la lista de alumnos ordenados por orden alfabético según su apellido de forma ascendente.
 Ordenar y mostrar la lista de alumnos ordenados por orden alfabético según su nombre de forma descendente.
 Con un alumno especifico (suponiendo que no existen dos alumnos con el mismo nombre y apellido), mostrar por pantalla su edad. Considerar, el manejo de fechas, utilizando el atributo fecha de nacimiento.
 Crear listas paralelas de Alumnos, según la nacionalidad.

 Realizar un reporte final de datos que informe:
o Cuantos alumnos son mayores de 25 años. ok
o Cuantos alumnos tiene su apellido que comienzan con letra L o P
o Cuantos alumnos hay de nacionalidad ARGENTINA – CHILENA – VENEZOLANA.
Recordar:
 Hacer uso de paquetes y clases correspondientes para buena estructura de nuestro proyecto.
 Todos los métodos deben ser pensados para reutilizar y adaptarse a futuros cambios (por ejemplo, mañana quiero carga de 30 alumnos, y las instrucciones deben prevenir esta modificación)
 */
package E7RegistroAlumnos;

import E7RegistroAlumnos.utilidades.Comparadores;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author AlejaDevelops
 */
public class AlumnosService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public ArrayList<Alumnos> crearListaAlumnos(ArrayList<Alumnos> listaAlumnos) {

        Alumnos alumno1 = new Alumnos("Erick", "Garcia", "Argentina", 1, 12, 1995);
        Alumnos alumno2 = new Alumnos("Ana", "Pérez", "Chile", 10, 5, 1998);
        Alumnos alumno3 = new Alumnos("Carlos", "López", "Argentina", 3, 9, 1997);
        Alumnos alumno4 = new Alumnos("Laura", "Martínez", "Chile", 22, 7, 1996);
        Alumnos alumno5 = new Alumnos("Diego", "Rodríguez", "Argentina", 14, 3, 1999);
        Alumnos alumno6 = new Alumnos("Isabella", "Gómez", "Chile", 5, 11, 1997);
        Alumnos alumno7 = new Alumnos("Luis", "Fernández", "Argentina", 17, 2, 1998);
        Alumnos alumno8 = new Alumnos("Camila", "Silva", "Venezuela", 9, 6, 1996);
        Alumnos alumno9 = new Alumnos("Javier", "Torres", "Argentina", 12, 10, 1999);
        Alumnos alumno10 = new Alumnos("Valentina", "Morales", "Chile", 8, 4, 1997);
        Alumnos alumno11 = new Alumnos("Martín", "Hernández", "Argentina", 25, 1, 1995);
        Alumnos alumno12 = new Alumnos("Gabriela", "Lara", "Venezuela", 6, 7, 1998);
        Alumnos alumno13 = new Alumnos("Santiago", "Mendoza", "Argentina", 19, 11, 1997);
        Alumnos alumno14 = new Alumnos("Carolina", "González", "Chile", 2, 3, 1999);
        Alumnos alumno15 = new Alumnos("Matías", "Pérez", "Argentina", 14, 8, 1996);
        Alumnos alumno16 = new Alumnos("Alejandra", "Sánchez", "Venezuela", 7, 5, 1997);
        Alumnos alumno17 = new Alumnos("Pablo", "Díaz", "Argentina", 23, 9, 1995);
        Alumnos alumno18 = new Alumnos("Florencia", "Rojas", "Chile", 10, 12, 1998);
        Alumnos alumno19 = new Alumnos("Ignacio", "Gutierrez", "Argentina", 5, 6, 1999);
        Alumnos alumno20 = new Alumnos("María", "Chavez", "Venezuela", 30, 4, 1996);
        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);
        listaAlumnos.add(alumno4);
        listaAlumnos.add(alumno5);
        listaAlumnos.add(alumno6);
        listaAlumnos.add(alumno7);
        listaAlumnos.add(alumno8);
        listaAlumnos.add(alumno9);
        listaAlumnos.add(alumno10);
        listaAlumnos.add(alumno11);
        listaAlumnos.add(alumno12);
        listaAlumnos.add(alumno13);
        listaAlumnos.add(alumno14);
        listaAlumnos.add(alumno15);
        listaAlumnos.add(alumno16);
        listaAlumnos.add(alumno17);
        listaAlumnos.add(alumno18);
        listaAlumnos.add(alumno19);
        listaAlumnos.add(alumno20);

        return listaAlumnos;

    }

    public void imprimirArrayList(ArrayList<Alumnos> a) {
        for (Alumnos aux : a) {
            System.out.println("NOMBRE: " + aux.getNombre() + " - APELLIDO: " + aux.getApellido() + " - NACIONALIDAD: " + aux.getNacionalidad() + " - FECHA NACIMIENTO: " + aux.getDia() + "/" + aux.getMes() + "/" + aux.getAnio());
        }
    }

    public Alumnos validarEstudiante(ArrayList<Alumnos> b) {
        System.out.println("Ingresa el nombre de un estudiante");
        String nombre = leer.next();
        boolean flag = false;
        Alumnos alumno = new Alumnos();

        for (Alumnos aux : b) {
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                alumno = aux;
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("El estudiante no se encuentra en la lista");
        }
        return alumno;
    }

    public int calculadoraEdad(Alumnos c) {

        Date fechaNac = new Date(c.getAnio() - 1900, c.getMes() - 1, c.getDia());
        Date hoy = new Date();
        Date edad = new Date(hoy.getYear() - fechaNac.getYear(), hoy.getMonth() - fechaNac.getMonth(), hoy.getDate() - fechaNac.getDate());

        return edad.getYear();
    }

    public void clasificacionNacionalidad(ArrayList<Alumnos> d) {
        ArrayList<Alumnos> a = new ArrayList();
        ArrayList<Alumnos> c = new ArrayList();
        ArrayList<Alumnos> v = new ArrayList();

        for (Alumnos aux : d) {
            if (aux.getNacionalidad().equalsIgnoreCase("argentina")) {
                a.add(aux);
            }
            if (aux.getNacionalidad().equalsIgnoreCase("chile")) {
                c.add(aux);
            }
            if (aux.getNacionalidad().equalsIgnoreCase("venezuela")) {
                v.add(aux);
            }
        }
        System.out.println("Cantidad de estudiantes argentinos: " + a.size()
                + "\n Listado:");
        imprimirArrayList(a);
        System.out.println("Cantidad de estudiantes chilenos: " + c.size()
                + "\n Listado:");
        imprimirArrayList(c);
        System.out.println("Cantidad de estudiantes venezolanos: " + v.size()
                + "\n Listado:");
        imprimirArrayList(v);

    }

    public void alumnosMayores25(ArrayList<Alumnos> e) {
        int edad;
        int cont = 0;
        for (Alumnos aux : e) {
            edad = calculadoraEdad(aux);
            if (edad > 25) {
                cont += 1;
            }
        }
        System.out.println("la cantidad de estudiantes con mas de 25 años son: " + cont);
    }

    public void inicialesAlumnos(ArrayList<Alumnos> f) {
        int cont = 0;
        for (Alumnos aux : f) {
            if (aux.getApellido().startsWith("P") || aux.getApellido().startsWith("L")) {
                cont += 1;
            }
        }
        System.out.println("Exiten " + cont + " estudiantes cuyos apellidos inician por P o L");
    }

    public void altaAlumno(ArrayList<Alumnos> f) {
        Alumnos alumnoNuevo = new Alumnos();
        System.out.println("Ingresa los datos del estudiante "
                + "\n Nombre:");
        alumnoNuevo.setNombre(leer.next());
        System.out.println("Apellido");
        alumnoNuevo.setApellido(leer.next());
        System.out.println("Nacionalidad: ");
        alumnoNuevo.setNacionalidad(leer.next());
        System.out.println("Fecha de nacimiento: "
                + "\n Dia");
        alumnoNuevo.setDia(leer.nextInt());
        System.out.println("Mes");
        alumnoNuevo.setMes(leer.nextInt());
        System.out.println("Año");
        alumnoNuevo.setAnio(leer.nextInt());
        f.add(alumnoNuevo);
    }

    public void editarDatos(ArrayList<Alumnos> f) {
        System.out.println("Ingresa el nombre del estudiante");
        String nombre = leer.next();
        int option;

        for (Alumnos aux : f) {
            if (aux.getNombre().equalsIgnoreCase(nombre)) {

                do {
                    System.out.println("Selecciona el dato que deseas modificar de acuerdo al siguiente menú: "
                            + "\n 1 - Nombre"
                            + "\n 2 - Apellido"
                            + "\n 3 - Nacionalidad"
                            + "\n 4 - Dia de nacimiento"
                            + "\n 5 - Mes de nacimiento"
                            + "\n 6 - Año de nacimiento"
                            + "\n 7 - Salir");
                    option = leer.nextInt();

                    switch (option) {
                        case 1:
                            System.out.println("Ingresa el nuevo nombre");
                            aux.setNombre(leer.next());
                            break;
                        case 2:
                            System.out.println("Ingresa el nuevo apellido");
                            aux.setApellido(leer.next());
                            break;
                        case 3:
                            System.out.println("Ingresa el nuevo nacionalidad");
                            aux.setNacionalidad(leer.next());
                            break;
                        case 4:
                            System.out.println("Ingresa el nuevo dia de nacimiento");
                            aux.setDia(leer.nextInt());
                            break;
                        case 5:
                            System.out.println("Ingresa el nuevo mes de nacimiento");
                            aux.setMes(leer.nextInt());
                            break;
                        case 6:
                            System.out.println("Ingresa el nuevo año de nacimiento");
                            aux.setAnio(leer.nextInt());
                            break;
                        case 7:
                            System.out.println("Edición terminada. Bye!");                            
                            break;
                        default:
                            System.out.println("Elección no válida, intenta nuevamente");
                    }
                } while (option != 7);
                //f.add(aux);//ESTA ADICIÓN SOLO SIRVE CUANDO EL 

            }
        }
    }
    
    public void eliminarEstudiante(ArrayList<Alumnos> g){
        System.out.println("Escribe el nombre del estudiante que deseas eliminar");
        String nombre = leer.next();
        Iterator<Alumnos> it = g.iterator();
        
        while (it.hasNext()) {
            if (it.next().getNombre().equalsIgnoreCase(nombre)) {
                it.remove();                
            }           
        }      
       
    }

    public void menu() {
        ArrayList<Alumnos> listaAlumnos = new ArrayList();
        int option;

        do {
            System.out.println("--------------------------------------------");
            System.out.println("Elige una opción del menú: "
                    + "\n 1 - Cargar primeros 20 estudiantes "
                    + "\n 2 - Agregar un nuevo estudiante"
                    + "\n 3 - Editar los datos de un estudiante"
                    + "\n 4 - Eliminar un estudiante"
                    + "\n 5 - Ordenar estudiantes por apellido, forma ascendente"
                    + "\n 6 - Ordenar estudiantes por nombre, forma descendente"
                    + "\n 7 - Validar la edad de un estudiante"
                    + "\n 8 - Solicitar un reporte final "
                    + "\n 9 - Imprimir listado de estudiantes"
                    + "\n 10 - Salir");
            option = leer.nextInt();

            switch (option) {
                case 1:
                    System.out.println("--------------------------------------------");
                    System.out.println("Cargando lista... "
                            + "\n ...");
                    crearListaAlumnos(listaAlumnos);
                    System.out.println("Lista cargada...");
                    break;
                case 2:
                    System.out.println("--------------------------------------------");
                    altaAlumno(listaAlumnos);
                    System.out.println("Alumno nuevo ingresado...");
                    break;
                case 3:
                    System.out.println("--------------------------------------------");
                    editarDatos(listaAlumnos);
                    break;
                case 4:
                    System.out.println("--------------------------------------------");
                    eliminarEstudiante(listaAlumnos);
                    System.out.println("Estudiante eliminado...");
                    break;
                case 5:
                    System.out.println("--------------------------------------------");
                    Collections.sort(listaAlumnos, Comparadores.ordenPorApellidoAsce);
                    System.out.println("Lista ordenada...");
                    break;
                case 6:
                    System.out.println("--------------------------------------------");
                    Collections.sort(listaAlumnos, Comparadores.ordenPorNombreDescen);
                    System.out.println("Lista ordenada...");
                    break;
                case 7:
                    System.out.println("--------------------------------------------");
                    Alumnos alumno = validarEstudiante(listaAlumnos);
                    System.out.println("La edad de " + alumno.getNombre() + " es " + calculadoraEdad(alumno) + " años");
                    break;
                case 8:
                    System.out.println("--------------------------------------------");
                    System.out.println("*** Reporte final ***");
                    alumnosMayores25(listaAlumnos);
                    inicialesAlumnos(listaAlumnos);
                    clasificacionNacionalidad(listaAlumnos);
                    break;
                case 9:
                    System.out.println("--------------------------------------------");
                    imprimirArrayList(listaAlumnos);
                    break;
                case 10:
                    System.out.println("--------------------------------------------");
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("--------------------------------------------");
                    System.out.println("Opción no válida. Intente nuevamente");
            }

        } while (option != 10);
    }

}
