/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroJpaController;
import libreria.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author AlejaDevelops
 */
public class LibroService {

    LibroJpaController ljc = new LibroJpaController();
    AutorService as = new AutorService();
    EditorialService es = new EditorialService();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearLibro() throws Exception {
        try {
            Libro libro = new Libro();
            System.out.println("*** Registro de un libro ***");
            System.out.println("Ingrese el ISBN del libro");
            libro.setIsbn(leer.next());
            System.out.println("Título");
            libro.setTitulo(leer.next());
            System.out.println("Año");
            libro.setAnio(leer.nextInt());
            System.out.println("Cantidad de ejemplares");
            libro.setEjemplares(leer.nextInt());
            System.out.println("Ejemplares prestados");
            libro.setEjemplaresPrestados(leer.nextInt());
            System.out.println("Ejemplares restantes");
            libro.setEjemplaresRestantes(leer.nextInt());
            libro.setAlta(Boolean.TRUE);

            //SETEO DEL AUTOR
            System.out.println("Nombre completo del Autor");
            String nombreAutorBuscado = leer.next();
            ArrayList<Autor> listaAutores = as.traerListaAutores();  //Carga todos los autores de la BD 
            boolean flag = true;
            for (Autor aux : listaAutores) {
                if (nombreAutorBuscado.equalsIgnoreCase(aux.getNombre())) { // Autor existe en la BD
                    libro.setAutor(aux);
                    flag = false;
                    break;
                }
            }
            if (flag == true) { //Autor no existe en la BD                
                System.out.println("Autor no existe en la base de datos, debes crearlo primero");
                libro.setAutor(as.crearAutor());
            }

            //SETEO DE LA EDITORIAL
            System.out.println("Nombre completo de la editorial");
            String nombreEditorialBuscada = leer.next();
            ArrayList<Editorial> listaEditorial = es.traerListaEditorial(); //Carga todas las editoriales de la BD
            flag = true;
            for (Editorial aux2 : listaEditorial) {
                if (nombreEditorialBuscada.equalsIgnoreCase(aux2.getNombre())) { //Editorial existe en la BD
                    libro.setEditorial(aux2);
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                System.out.println("La editorial no existe en la base de datos, debes crearla primero");
                libro.setEditorial(es.crearEditorial());
            }

            ljc.create(libro);
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminarLibro() {

        try {
            System.out.println("Estos son los libros registrados en la base de datos: ");
            System.out.println(traerListaLibros());
            System.out.println("                   ***                           ");
            System.out.println("Ingresa el ID del libro que deseas eliminar");

            Integer idEliminar;
            while (true) {
                try {
                    idEliminar = leer.nextInt();
                    break; //Si no se genera la excepción, entonces se sale del bucle
                } catch (InputMismatchException e) {
                    System.out.println("Ingresa un ID válido: ");
                    leer.next(); // Limpia el búfer de lectura para evitar un ciclo infinito
                }
            }
            ljc.destroy(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AutorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Libro traerLibro() {
        System.out.println("Ingresa el número del ID del libro"); // SE DEBEN ESTABLECER LAS EXEPCIONES
        Integer id = leer.nextInt();
        return ljc.findLibro(id);
    }

    public ArrayList<Libro> traerLibroPorTitulo() {
        System.out.println("Título del libro que desea buscar");
        String titulo = leer.next();
        List<Libro> listaLibro = ljc.findLibroByTitulo(titulo);
        ArrayList<Libro> arrayLibro = new ArrayList<>(listaLibro);
        return arrayLibro;
    }

    public ArrayList<Libro> traerListaLibros() {
        List<Libro> listaLibros = ljc.findLibroEntities();
        ArrayList<Libro> arrayLibros = new ArrayList<>(listaLibros);
        return arrayLibros;
    }

    public ArrayList<Libro> traerLibroPorNombreAutor() {
        System.out.println("Ingresa el nombre del autor del libro");
        String nombreAutor = leer.next();
        List<Libro> listaLibros = ljc.findLibrosByAutorName(nombreAutor);
        ArrayList<Libro> arrayLibros = new ArrayList<>(listaLibros);
        return arrayLibros;
    }

    public ArrayList<Libro> traerLibroPorNombreEditorial() {
        System.out.println("Ingresa el nombre de la Editorial del libro");
        String nombreEditorial = leer.next();
        List<Libro> listaLibros = ljc.findLibrosByEditorialName(nombreEditorial);
        ArrayList<Libro> arrayLibros = new ArrayList<>(listaLibros);
        return arrayLibros;
    }

    public void editarLibroPorTitulo() {
        try {
            System.out.println("Estos son los libros registrados en la base de datos: ");
            System.out.println(traerListaLibros());
            System.out.println("                      ***               ");
            System.out.println("Ingresa el ISBN del libro que deseas editar");
            Long idEditar = leer.nextLong();

            ArrayList<Libro> arrayLibro = traerListaLibros(); //Guardo lista de libros // Y SI ESTÁ VACÍA??? SE EJECUTA EL CATCH??
            boolean flag = false;
            for (Libro aux : arrayLibro) {
                if (Objects.equals(aux.getIsbn(), idEditar)) { //EL LIBRO SI EXISTE EN LA BASE DE DATOS
                    Libro libro = aux;
                    System.out.println("Ingrese el nuevo título del libro");
                    libro.setTitulo(leer.next());
                    ljc.edit(libro);
                    System.out.println("Edición realizada exitosamente");
                    flag = true;
                    break;
                }
            }
            if (flag = false) {
                System.out.println("No se encontró el ID ingresado en la base de datos");
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error. No se pudo editar el nombre del libro. Tipo de error: " + e);
        }

    }

    public void editarLibroPorAnio() {
        try {
            System.out.println("Estos son los libros registrados en la base de datos: ");
            System.out.println(traerListaLibros());
            System.out.println("                      ***               ");
            System.out.println("Ingresa el ISBN del libro que deseas editar");
            Long idEditar = leer.nextLong();

            ArrayList<Libro> arrayLibro = traerListaLibros(); //Guardo lista de libros // Y SI ESTÁ VACÍA??? SE EJECUTA EL CATCH??
            boolean flag = false;
            for (Libro aux : arrayLibro) {
                if (Objects.equals(aux.getIsbn(), idEditar)) { //EL LIBRO SI EXISTE EN LA BASE DE DATOS
                    Libro libro = aux;
                    System.out.println("Ingrese el nuevo año del libro");
                    libro.setAnio(leer.nextInt());
                    ljc.edit(libro);
                    System.out.println("Edición realizada exitosamente");
                    flag = true;
                    break;
                }
            }
            if (flag = false) {
                System.out.println("No se encontró el ID ingresado en la base de datos");
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error. No se pudo editar el año del libro. Tipo de error: " + e);
        }

    }

    public void editarLibroPorEjemplaresIniciales() {
        try {
            System.out.println("Estos son los libros registrados en la base de datos: ");
            System.out.println(traerListaLibros());
            System.out.println("                      ***               ");
            System.out.println("Ingresa el ISBN del libro que deseas editar");
            Long idEditar = leer.nextLong();

            ArrayList<Libro> arrayLibro = traerListaLibros(); //Guardo lista de libros // Y SI ESTÁ VACÍA??? SE EJECUTA EL CATCH??
            boolean flag = false;
            for (Libro aux : arrayLibro) {
                if (Objects.equals(aux.getIsbn(), idEditar)) { //EL LIBRO SI EXISTE EN LA BASE DE DATOS
                    Libro libro = aux;
                    System.out.println("Ingrese la nueva cantidad de ejemplares iniciales del libro");
                    libro.setEjemplares(leer.nextInt());
                    ljc.edit(libro);
                    System.out.println("Edición realizada exitosamente");
                    flag = true;
                    break;
                }
            }
            if (flag = false) {
                System.out.println("No se encontró el ID ingresado en la base de datos");
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error. No se pudo editar la cantidad de ejemplares iniciales del libro. Tipo de error: " + e);
        }

    }

    public void editarLibroPorEjemplaresPrestados() {
        try {
            System.out.println("Estos son los libros registrados en la base de datos: ");
            System.out.println(traerListaLibros());
            System.out.println("                      ***               ");
            System.out.println("Ingresa el ISBN del libro que deseas editar");
            Long idEditar = leer.nextLong();

            ArrayList<Libro> arrayLibro = traerListaLibros(); //Guardo lista de libros // Y SI ESTÁ VACÍA??? SE EJECUTA EL CATCH??
            boolean flag = false;
            for (Libro aux : arrayLibro) {
                if (Objects.equals(aux.getIsbn(), idEditar)) { //EL LIBRO SI EXISTE EN LA BASE DE DATOS
                    Libro libro = aux;
                    System.out.println("Ingrese la nueva cantidad de ejemplares prestados");
                    libro.setEjemplaresPrestados(leer.nextInt());
                    ljc.edit(libro);
                    System.out.println("Edición realizada exitosamente");
                    flag = true;
                    break;
                }
            }
            if (flag = false) {
                System.out.println("No se encontró el ID ingresado en la base de datos");
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error. No se pudo editar la cantidad de ejemplares prestados. Tipo de error: " + e);
        }

    }

    public void editarLibroPorEjemplaresRestantes() {
        try {
            System.out.println("Estos son los libros registrados en la base de datos: ");
            System.out.println(traerListaLibros());
            System.out.println("                      ***               ");
            System.out.println("Ingresa el ISBN del libro que deseas editar");
            Long idEditar = leer.nextLong();

            ArrayList<Libro> arrayLibro = traerListaLibros(); //Guardo lista de libros // Y SI ESTÁ VACÍA??? SE EJECUTA EL CATCH??
            boolean flag = false;
            for (Libro aux : arrayLibro) {
                if (Objects.equals(aux.getIsbn(), idEditar)) { //EL LIBRO SI EXISTE EN LA BASE DE DATOS
                    Libro libro = aux;
                    System.out.println("Ingrese la nueva cantidad de ejemplares restantes");
                    libro.setEjemplaresRestantes(leer.nextInt());
                    ljc.edit(libro);
                    System.out.println("Edición realizada exitosamente");
                    flag = true;
                    break;
                }
            }
            if (flag = false) {
                System.out.println("No se encontró el ID ingresado en la base de datos");
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error. No se pudo editar la cantidad de ejemplares restantes. Tipo de error: " + e);
        }

    }

    public void editarLibroPorAlta() {
        try {
            System.out.println("Estos son los libros registrados en la base de datos: ");
            System.out.println(traerListaLibros());
            System.out.println("                      ***               ");
            System.out.println("Ingresa el ISBN del libro que deseas editar");
            Long idEditar = leer.nextLong();

            ArrayList<Libro> arrayLibro = traerListaLibros(); //Guardo lista de libros // Y SI ESTÁ VACÍA??? SE EJECUTA EL CATCH??
            boolean flag = false;
            for (Libro aux : arrayLibro) {
                if (Objects.equals(aux.getIsbn(), idEditar)) { //EL LIBRO SI EXISTE EN LA BASE DE DATOS
                    Libro libro = aux;
                    System.out.println("El estado del Alta del libro es: " + aux.getAlta());
                    System.out.println("Se cambiará a: " + (!aux.getAlta()));
                    libro.setAlta(!aux.getAlta());
                    ljc.edit(libro);
                    System.out.println("Edición realizada exitosamente");
                    flag = true;
                    break;
                }
            }
            if (flag = false) {
                System.out.println("No se encontró el ID ingresado en la base de datos");
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error. No se pudo editar el Alta del libro. Tipo de error: " + e);
        }

    }

    public void editarLibroPorAutor() {
        try {
            System.out.println("Estos son los libros registrados en la base de datos: ");
            System.out.println(traerListaLibros());
            System.out.println("                      ***               ");
            System.out.println("Ingresa el ISBN del libro que deseas editar");
            Long idEditar = leer.nextLong();

            ArrayList<Libro> arrayLibro = traerListaLibros(); //Guardo lista de libros // Y SI ESTÁ VACÍA??? SE EJECUTA EL CATCH??
            boolean flag = false;
            for (Libro aux : arrayLibro) {
                if (Objects.equals(aux.getIsbn(), idEditar)) { //EL LIBRO SI EXISTE EN LA BASE DE DATOS
                    Libro libro = aux;
                    Autor autor = as.registrarDatos(); // LLENADO DE DATOS DEL AUTOR PRIMERO VALIDANDO QUE NO EXISTA EN LA BD  
                    libro.setAutor(autor);
                    ljc.edit(libro);
                    System.out.println("Edición realizada exitosamente");
                    flag = true;
                    break;
                }
            }
            if (flag = false) {
                System.out.println("No se encontró el ID ingresado en la base de datos");
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error. No se pudo editar el autor del libro. Tipo de error: " + e);
        }

    }

    public void editarLibroPorEditorial() {
        try {
            System.out.println("Estos son los libros registrados en la base de datos: ");
            System.out.println(traerListaLibros());
            System.out.println("                      ***               ");
            System.out.println("Ingresa el ISBN del libro que deseas editar");
            Long idEditar = leer.nextLong();

            ArrayList<Libro> arrayLibro = traerListaLibros(); //Guardo lista de libros // Y SI ESTÁ VACÍA??? SE EJECUTA EL CATCH??
            boolean flag = false;
            for (Libro aux : arrayLibro) {
                if (Objects.equals(aux.getIsbn(), idEditar)) { //EL LIBRO SI EXISTE EN LA BASE DE DATOS
                    Libro libro = aux;
                    Editorial editorial = es.registrarDatos(); // LLENADO DE DATOS DEL AUTOR PRIMERO VALIDANDO QUE NO EXISTA EN LA BD  
                    libro.setEditorial(editorial);
                    ljc.edit(libro);
                    System.out.println("Edición realizada exitosamente");
                    flag = true;
                    break;
                }
            }
            if (flag = false) {
                System.out.println("No se encontró el ID ingresado en la base de datos");
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error. No se pudo editar la editorial del libro. Tipo de error: " + e);
        }

    }
}
