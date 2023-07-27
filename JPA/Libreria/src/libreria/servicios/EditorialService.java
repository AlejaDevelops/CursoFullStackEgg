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

    public Editorial crearEditorial() throws Exception {
        try {
            System.out.println("*** Registro de una editorial ***");
            System.out.println("Ingrese el nombre de la editorial");
            editorial.setNombre(leer.next());
            editorial.setAlta(Boolean.TRUE);
            ejc.create(editorial);
            return editorial;
        } catch (Exception e) {
            System.out.println("Error del sistema. " + e);
            throw e;
        }
    }

    public void eliminarEditorial() {
        try {
            System.out.println("Estos son las editoriales registradas en la base de datos: ");
            System.out.println(traerListaEditorial().toString());
            System.out.println("                   ***                           ");
            System.out.println("Ingresa el ID de la editorial que deseas eliminar");
            Integer idEliminar;

            while (true) {
                try {
                    idEliminar = leer.nextInt();
                    break;//Si no se genera la excepción, entonces se sale del bucle

                } catch (InputMismatchException e) {
                    System.out.println("Ingresa un ID válido: ");
                    leer.next(); // Limpia el búfer de lectura para evitar un ciclo infinito
                }
            }
            ejc.destroy(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EditorialService.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    public Editorial traerEditorial() {
        System.out.println("Ingrese el id de la editorial");
        int id = leer.nextInt();
        return ejc.findEditorial(id);
    }

    public ArrayList<Editorial> traerListaEditorial() {
        List<Editorial> listaEditorial = ejc.findEditorialEntities();
        ArrayList<Editorial> arrayEditorial = new ArrayList<>(listaEditorial);
        return arrayEditorial;
    }

    public void editarEditorial() throws Exception {
        System.out.println("Ingresa el ID de la editorial que deseas editar");
        int id = leer.nextInt();
        Editorial editorial = ejc.findEditorial(id);
        System.out.println("Esta es la editorial que vas a editar: " + editorial);
        System.out.println("                   ***                           ");
        if (editorial != null) {
            System.out.println("Ingresa el nuevo nombre de la editorial");
            editorial.setNombre(leer.next());
            ejc.edit(editorial);
            System.out.println("Editorial editada exitosamente");
        }

    }

}
