/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tienda.persistencia;

import Tienda.entidades.Fabricantes;

/**
 *
 * @author AlejaDevelops
 */
public final class FabricantesDAO extends TiendaDAO{
    
    public void ingresarProducto(Fabricantes fabricante) throws Exception{ 
        try {
            if (fabricante == null) {
                throw new Exception("Debe registrar un fabricante");
            }            
            String sql = "INSERT INTO fabricante " + "VALUES('"+fabricante.getNombre()+"')"; //NO SE PERMITE INGRESAR EL CODIGO PORQUE LA BD LOS GENERA POR UNSIGNED AUTO_INCREMENT PRIMARY KEY
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    // SE DEBE HACER UN MÉTODO PARA BUSCAR EL FABRINCATE Y VALIDAR SI YA ESTA REGISTRADO ANTES DE AGREGARLO A LA BD
   
            
}
