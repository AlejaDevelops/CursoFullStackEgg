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
import libreria.entidades.Cliente;
import libreria.persistencia.ClienteJpaController;
import libreria.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author AlejaDevelops
 */
public class ClienteService {

    ClienteJpaController cjc = new ClienteJpaController();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Cliente cliente = new Cliente();

    public Cliente crearCliente() throws Exception {
        try {
            System.out.println("*** Registro de un cliente ***");
            System.out.println("Ingrese el documento del cliente");
            cliente.setDocumento(leer.nextLong());
            System.out.println("Ingrese el nombre");
            cliente.setNombre(leer.next());
            System.out.println("Ingrese el apellido");
            cliente.setApellido(leer.next());
            System.out.println("Ingrese el teléfono");
            cliente.setTelefono(leer.next());
            cjc.create(cliente);
            return cliente;
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarCliente() {
        
        try {
            System.out.println("Estos son los clientes registrados en la base de datos: ");
            System.out.println(traerListaClientes().toString());
            System.out.println("                   ***                           ");
            System.out.println("Ingresa el ID del cliente que deseas eliminar");

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
            cjc.destroy(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AutorService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
   

    public Cliente traerClientePorDocumento() {
        try {
            System.out.println("Ingresa el documento del cliente");
            Long doc = leer.nextLong();
            return cjc.findClienteByDocumento(doc);            
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Cliente> traerListaClientes() {
        List<Cliente> listaClientes = cjc.findClienteEntities();
        ArrayList<Cliente> arrayAutores = new ArrayList<>(listaClientes);
        return arrayAutores;
    }

    public void editarDocumentoCliente() throws Exception {
        try {
            System.out.println("Esta es la lista de clientes registrados");
            System.out.println(traerListaClientes());
            System.out.println("Ingresa el ID del cliente que deseas editar");
            int idCliente = leer.nextInt();
            Cliente cliente = cjc.findCliente(idCliente);
            if (cliente != null) { //Si se cumple la condición quiere decir que el cliente si está registrado en la BD
                System.out.println("Ingrese el nuevo documento del cliente");
                cliente.setDocumento(leer.nextLong());
                cjc.edit(cliente);
                System.out.println("Documento editado exitosamente");
            }else
                System.out.println("El ID ingresado no se encuentra en la base de datos");
                        
            
        } catch (Exception e) {
            throw e;
        }
        
        
    }

    public void editarNombreCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editarApellidoCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editarTelefonoCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
