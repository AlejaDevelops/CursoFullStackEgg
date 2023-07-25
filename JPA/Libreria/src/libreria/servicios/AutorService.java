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
    
    public Autor registrarDatos(){               
        System.out.println("*** Registro de un autor ***");
        System.out.println("Ingrese el nombre del autor");
        autor.setNombre(leer.next()); //validar que el autor no esté registrado en la BD
        autor.setAlta(Boolean.TRUE); 
        return autor;
    }
    
    public Autor crearAutor() throws Exception{
        autor = registrarDatos();
        // CREAR VERIFICACION DEL AUTOR EN LA BD
        ajc.create(autor);
        System.out.println("Autor registrado exitosamente");
        return autor;
    }
    
    public void eliminaAutor() {
        try {
            System.out.println("Estos son los autores registrados en la base de datos: ");
            System.out.println(traerListaAutores().toString());
            System.out.println("Ingresa el ID del autor que deseas eliminar");
            int idEliminar = leer.nextInt();
            ajc.destroy(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AutorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Autor traerAutorPorId(int id){ 
        return ajc.findAutor(id); 
    }
    
    public ArrayList<Autor> traerListaAutores(){
        List<Autor> listaAutores = ajc.findAutorEntities();
        ArrayList<Autor> arrayAutores = new ArrayList<>(listaAutores);
        return arrayAutores;
    }
    
    public ArrayList<Autor> traerAutorPorNombre(){
        System.out.println("Ingresa el nombre del autor que deseas buscar");
        String nombre = leer.next();
        List<Autor> listaAutores = ajc.findAutorByName(nombre);        
        ArrayList<Autor> arrayAutores = new ArrayList<>(listaAutores);
        return arrayAutores;
    }
    
    
    public void editarAutor() throws Exception{
        System.out.println("Ingresa el ID del autor que deseas editar");
        int id = leer.nextInt();
        Autor autor = ajc.findAutor(id);
        
        if (autor!= null) {
            System.out.println("Ingresa el nuevo nombre del Autor");
            autor.setNombre(leer.next());
            ajc.edit(autor);
            System.out.println("Autor editado exitosamente");            
        }
    
    }
            

    
    
     
}
