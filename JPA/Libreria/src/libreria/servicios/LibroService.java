/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
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

    public Libro registrarDatos() throws Exception {
        Libro libro = new Libro();
        System.out.println("*** Registro de un libro ***");
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
        
        System.out.println("Nombre completo del Autor");
        String nombreAutorBuscado = leer.next();
        
        ArrayList<Autor> listaAutores = as.traerAutorPorNombre();  //Carga todos los autores de la BD        
        
        for (Autor aux : listaAutores) { //OJO CON ERRORES POR REVISAR
            // Autor existe en la BD
            if (nombreAutorBuscado.equalsIgnoreCase(aux.getNombre())) {
                libro.setAutor(aux);
            } else{
                //Autor no existe en la BD
            libro.setAutor(as.crearAutor());
            }
            
        }
        
        System.out.println("Nombre completo de la editorial");
        String nombreEditorialBuscada = leer.next();
        
        ArrayList<Editorial> listaEditorial = es.traerListaEditorial(); //Carga todas las editoriales de la BD
        
        for (Editorial aux2 : listaEditorial) { //OJO CON ERRORES POR REVISAR
            //Editorial existe en la BD
            if (nombreEditorialBuscada.equalsIgnoreCase(aux2.getNombre())) {
                libro.setEditorial(aux2);
            } else{
                libro.setEditorial(es.crearEditorial());
            }
        }
        
        return libro;
    }

    public void crearLibro() throws Exception {
        ljc.create(registrarDatos());
        System.out.println("Libro registrado exitosamente");
    }
    
    public void eliminarLibro(){
       System.out.println("Estos son los libros registrados en la base de datos: ");
            System.out.println(traerListaLibros());
            System.out.println("");
            System.out.println("Ingresa el ID del libro que deseas eliminar");
            Long idElimina = leer.nextLong();
        try {
            ljc.destroy(idElimina);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(LibroService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Libro traerLibro(){ 
        System.out.println("Ingresa el número del ISBN del libro"); // SE DEBEN ESTABLECER LAS EXEPCIONES
        Long id = leer.nextLong();
        return ljc.findLibro(id); 
    }
    
    public ArrayList<Libro> traerLibroPorTitulo(){
        System.out.println("Título del libro que desea buscar");
        String titulo = leer.next();
        List<Libro> listaLibro = ljc.findLibroByTitulo(titulo);        
        ArrayList<Libro> arrayLibro = new ArrayList<>(listaLibro);
        return arrayLibro;
    }
    
    
    
    public ArrayList<Libro> traerListaLibros(){
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
    
    
}
