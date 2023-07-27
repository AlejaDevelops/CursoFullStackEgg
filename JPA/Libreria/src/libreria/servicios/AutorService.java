/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.entidades.Autor;
import libreria.persistencia.AutorJpaController;
import libreria.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author AlejaDevelops
 */
public class AutorService {

    AutorJpaController ajc = new AutorJpaController();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Autor autor = new Autor();

    public Autor crearAutor() throws Exception {
        try {
            System.out.println("*** Registro de un autor ***");
            System.out.println("Ingrese el nombre completo del autor");
            autor.setNombre(leer.next());
            autor.setAlta(Boolean.TRUE);
            ajc.create(autor);
            return autor;
        } catch (Exception e) {
            System.out.println("Error del sistema. " + e);
            throw e;
        }
    }

    public void eliminaAutor() {
        try {
            System.out.println("Estos son los autores registrados en la base de datos: ");
            System.out.println(traerListaAutores().toString());
            System.out.println("                   ***                           ");
            System.out.println("Ingresa el ID del autor que deseas eliminar");

            int idEliminar;
            while (true) {
                try {
                    idEliminar = leer.nextInt();
                    break; //Si no se genera la excepción, entonces se sale del bucle
                } catch (InputMismatchException e) {
                    System.out.println("Ingresa un ID válido: ");
                    leer.next(); // Limpia el búfer de lectura para evitar un ciclo infinito
                }
            }
            ajc.destroy(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AutorService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public Autor traerAutorPorId(int id) {
        return ajc.findAutor(id);
    }

    public ArrayList<Autor> traerListaAutores() {
        List<Autor> listaAutores = ajc.findAutorEntities();
        ArrayList<Autor> arrayAutores = new ArrayList<>(listaAutores);
        return arrayAutores;
    }

    public ArrayList<Autor> traerAutorPorNombre() {
        System.out.println("Ingresa el nombre del autor que deseas buscar");
        String nombre = leer.next();
        List<Autor> listaAutores = ajc.findAutorByName(nombre);
        ArrayList<Autor> arrayAutores = new ArrayList<>(listaAutores);
        return arrayAutores;
    }

    public void editarAutor() throws Exception {
        System.out.println("Ingresa el ID del autor que deseas editar");
        int id = leer.nextInt();
        Autor autor = ajc.findAutor(id);
        System.out.println("Este es el autor que vas a editar: " + autor);
        System.out.println("                   ***                           ");

        if (autor != null) {
            System.out.println("Ingresa el nuevo nombre del Autor");
            autor.setNombre(leer.next());
            ajc.edit(autor);
            System.out.println("Autor editado exitosamente");
        }

    }

}
