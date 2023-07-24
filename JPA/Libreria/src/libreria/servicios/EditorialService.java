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
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialJpaController;
import libreria.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author AlejaDevelops
 */
public class EditorialService {
    EditorialJpaController ejc = new EditorialJpaController();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");    
    Editorial editorial = new Editorial(); 
    
    public Editorial registrarDatos(){               
        System.out.println("*** Registro de una editorial ***");
        System.out.println("Ingrese el nombre de la editorial");
        editorial.setNombre(leer.next());
        editorial.setAlta(Boolean.TRUE); 
        return editorial;
    }
    
    public Editorial crearEditorial() throws Exception{     
        editorial = registrarDatos();
        ejc.create(editorial);
        System.out.println("Editorial registrada exitosamente");
        return editorial;
    }
    
     public void eliminarEditorial(){
       System.out.println("Estos son las editoriales registradas en la base de datos: ");
            //listar editoriales registradas en la BD
            System.out.println("Ingresa el ID de la editorial que deseas eliminar");
            Integer idEliminar = leer.nextInt();
        try {
            ejc.destroy(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EditorialService.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public Editorial traerEditorial(){
        System.out.println("Ingrese el id de la editorial");
        int id = leer.nextInt();
        return ejc.findEditorial(id); 
    }
    
    public ArrayList<Editorial> traerListaEditorial(){
        List<Editorial> listaEditorial = ejc.findEditorialEntities();
        ArrayList<Editorial> arrayEditorial = new ArrayList<>(listaEditorial);
        return arrayEditorial;
    }
    
    public void editarEditorial() throws Exception{
        System.out.println("Ingresa el ID de la editorial que deseas editar");
        int id = leer.nextInt();
        Editorial editorial = ejc.findEditorial(id);
        
        if (editorial!= null) {
            System.out.println("Ingresa el nuevo nombre de la editorial");
            editorial.setNombre(leer.next());
            ejc.edit(editorial);
            System.out.println("Editorial editada exitosamente");            
        }
    
    }
    
}
