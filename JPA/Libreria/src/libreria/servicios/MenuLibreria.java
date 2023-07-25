/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Scanner;


/**
 *
 * @author AlejaDevelops
 */
public class MenuLibreria {    
    
    AutorService as = new AutorService();
    EditorialService es = new EditorialService();
    LibroService ls = new LibroService();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void menu() throws Exception {

        int input;

        do {
            System.out.println("Escoge una tarea del siguiente menú:  "
                    + "\n 1 - Registrar"
                    + "\n 2 - Eliminar"
                    + "\n 3 - Editar"
                    + "\n 4 - Buscar"
                    + "\n 5 - Ver registros"
                    + "\n 6- Salir");
            input = leer.nextInt(); /////////////SE DEBE CREAR UNA EXCEPCIÓN PARA LA ENTRADA DE DATOS DISTINTOS A INT
            
            if (input == 6) {
                System.out.println("Adios!");
                break;
            }
            int input2 = eleccionDeRegistro();
            
            switch (input) {
                case 1: //REGISTRAR UNA NUEVA ENTRADA
                    switch (input2) {
                        case 1:                                                       
                            as.crearAutor();
                            System.out.println("-----------------------------------");
                            break;
                        case 2:
                            es.crearEditorial();
                            System.out.println("-----------------------------------");
                            break;
                        case 3:
                            ls.crearLibro(); 
                            System.out.println("-----------------------------------");
                            break;
                        default:
                            System.out.println("Opción inválida");
                    }
                    break;
                    
                case 2: //ELIMINAR UN REGISTRO  
                    switch (input2) {
                        case 1:
                            as.eliminaAutor();
                            System.out.println("-----------------------------------");
                            break;
                        case 2:
                            es.eliminarEditorial();
                            System.out.println("-----------------------------------");
                            break;
                        case 3:
                            ls.eliminarLibro();
                            System.out.println("-----------------------------------");
                            break;
                        default:
                            System.out.println("Opción inválida");
                    }
                    break;
                    
                case 3: //MODIFICAR UN REGISTRO
                    
                    switch (input2) {
                        case 1:
                            as.editarAutor();
                            System.out.println("-----------------------------------");
                            break;
                        case 2:
                            es.editarEditorial();
                            System.out.println("-----------------------------------");
                            break;
                        case 3:
                            //modificar libro
                            System.out.println("-----------------------------------");
                            break;
                        default:
                            System.out.println("Opción inválida");
                    }
                    break;
                case 4: //BUSQUEDA
                    
                    switch (input2) {
                        case 1:
                            System.out.println(as.traerAutorPorNombre());                            
                            System.out.println("-----------------------------------");
                            break;
                        case 2:
                            System.out.println(es.traerEditorial());
                            System.out.println("-----------------------------------");
                            break;
                        case 3:
                            int input3 = eleccionTipoDeBusquedaLibro();
                            switch (input3){
                                case 1:
                                    System.out.println(ls.traerLibro());                                    
                                    System.out.println("-----------------------------------");
                                    break;
                                case 2:
                                    System.out.println(ls.traerLibroPorTitulo());
                                    System.out.println("-----------------------------------");
                                    break;
                                case 3:
                                    System.out.println(ls.traerLibroPorNombreAutor());
                                    System.out.println("-----------------------------------");
                                    break;
                                case 4:
                                    System.out.println(ls.traerLibroPorNombreEditorial());
                                    System.out.println("-----------------------------------");
                                    break;
                                default:
                                    System.out.println("Opción inválida"); 
                            }
                            break;
                        default:
                            System.out.println("Opción inválida");
                            System.out.println("-----------------------------------");
                    }
                    break; 
                case 5: // Ver registros
                    switch (input2) {
                        case 1:
                            System.out.println(as.traerListaAutores().toString());                            
                            System.out.println("-----------------------------------");
                            break;
                        case 2:
                            System.out.println(es.traerListaEditorial().toString());
                            System.out.println("-----------------------------------");
                            break;
                        case 3:
                            System.out.println(ls.traerListaLibros().toString());
                            System.out.println("-----------------------------------");
                            break;
                        default:
                            System.out.println("Opción inválida");
                    }                    
                    break;
                default:
                    System.out.println("Opción inválida, intenta nuevamente");
                    System.out.println("-----------------------------------");
            }
        } while (input != 6);
    }

    
    public int eleccionDeRegistro() {

        System.out.println("Escoge el tipo registro "
                + "\n 1 - Autor"
                + "\n 2 - Editorial"
                + "\n 3 - Libro");
        int input = leer.nextInt(); /////////////SE DEBE CREAR UNA EXCEPCIÓN PARA LA ENTRADA DE DATOS DISTINTOS A INT

        return input;
    }   
    
    
    public int eleccionTipoDeBusquedaLibro(){
        System.out.println("Deseas realizar la búsqueda por: "
                + "\n 1 - ISBN"
                + "\n 2 - Título"
                + "\n 3 - Nombre del autor"
                + "\n 4 - Editorial");
        int input = leer.nextInt(); /////////////SE DEBE CREAR UNA EXCEPCIÓN PARA LA ENTRADA DE DATOS DISTINTOS A INT

        return input;
    }
    
     public int eleccionTipoDeModificacionLibro(){
        System.out.println("Deseas realizar la modificacion de: "
                + "\n 1 - ISBN"
                + "\n 2 - Título"
                + "\n 3 - Nombre del autor"
                + "\n 4 - Editorial");
        int input = leer.nextInt(); /////////////SE DEBE CREAR UNA EXCEPCIÓN PARA LA ENTRADA DE DATOS DISTINTOS A INT

        return input;
    }
    
}

