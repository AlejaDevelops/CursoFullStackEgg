/*
 *  RECOLECCIÓN Y VALIDACION DE LOS DATOS ANTES DE ACCEDER A LA BASE DE DATOS
 */

package Tienda.servicios;

import Tienda.entidades.Fabricantes;
import Tienda.persistencia.FabricantesDAO;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class FabricantesServicio {
    
    FabricantesDAO fdao = new FabricantesDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    
    public void crearFabricante(String nombre) throws Exception{ // Los atributos deben ingresar como String?
        try {
            //VALIDACIONES DE LOS DATOS INGRESADOS
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre de producto");  
            }            
             // se debe revisar que el fabricante no esté ya registrado
             
            Fabricantes fabricante = new Fabricantes();
            fabricante.setNombre(nombre);
            
            fdao.ingresarFabricante(fabricante);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Fabricantes leerDatosFabricante(){
        Fabricantes fabricante = new Fabricantes();
        System.out.println("Ingresa el nombre del fabricante");
        fabricante.setNombre(leer.next());        
        return fabricante; 
    }
}
