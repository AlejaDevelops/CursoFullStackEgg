/*
 * METODOS QUE CONTIENEN LAS SENTENCIAS PARA ACCEDER A LA BASE DE DATOS
 */
package Tienda.persistencia;

import Tienda.entidades.Fabricantes;

/**
 *
 * @author AlejaDevelops
 */
public final class FabricantesDAO extends TiendaDAO {

    public void ingresarFabricante(Fabricantes fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe registrar un fabricante");
            }
            String sql = "INSERT INTO fabricante " + "VALUES('" + fabricante.getCodigo() + "','" + fabricante.getNombre() + "')"; //NO SE PERMITE INGRESAR EL CODIGO PORQUE LA BD LOS GENERA POR UNSIGNED AUTO_INCREMENT PRIMARY KEY
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    //Lista el nombre de todos los productos que hay en la tabla producto
    public void listaFabricantes() throws Exception {
        try {
            String sql = "SELECT * FROM fabricante";
            consultarBase(sql);

            System.out.println("*** Lista de fabricantes ***");
            while (resultado.next()) {
                Fabricantes fabricante = new Fabricantes();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                System.out.println(fabricante.toString());
            }
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    // MÉTODO PARA BUSCAR EL FABRICANTE Y VALIDAR SI YA ESTA REGISTRADO ANTES DE AGREGARLO A LA BD    
    public Fabricantes buscarFabricantePorCodigo(int codigo) throws Exception {
        Fabricantes fabricante = null;
        try {
            String sql = "SELECT * FROM fabricante WHERE codigo = '" + codigo + "'";
            consultarBase(sql);
            while (resultado.next()) {
                fabricante = new Fabricantes();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

}
