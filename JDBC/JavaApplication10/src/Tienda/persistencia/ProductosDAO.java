/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda.persistencia;

import Tienda.entidades.Producto;
import java.util.ArrayList;

/**
 *
 * @author AlejaDevelops
 */
public final class ProductosDAO extends TiendaDAO {
    
    //Ingresar un producto a la base de datos.
    public void ingresarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe registrar un producto");
            }
            // INSERT INTO producto VALUES(1, 'Disco duro SATA3 1TB', 86.99, 5);
            //String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante)" + "VALUES('"+producto.getCodigo()+"','" + producto.getNombre() + "', '" + producto.getPrecio() + "', '" + producto.getCodigo_fabricante() + "')"; 
            String sql = "INSERT INTO producto (codigo,nombre,precio,codigo_fabricante)values('"
                    + producto.getCodigo() + "','" + producto.getNombre() + "','" + producto.getPrecio() + "','" + producto.getCodigo_fabricante() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    //Editar un producto con datos a elección.
    public void editarNombreProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto a editar");
            }
            String sql = "UPDATE producto SET " + "nombre = '" + producto.getNombre() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    //Editar un producto con datos a elección.
    public void editarPrecioProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto a editar");
            }
            String sql = "UPDATE producto SET " + "precio = '" + producto.getPrecio() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    //Editar un producto con datos a elección.
    public void editarCodFabricanteProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto a editar");
            }
            String sql = "UPDATE producto SET " + "codigo_fabricante = '" + producto.getCodigo_fabricante() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    //Lista el nombre de todos los productos que hay en la tabla producto
    public ArrayList<Producto> listaNombreProductos() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto";
            consultarBase(sql);

            Producto producto = null;
            ArrayList<Producto> listaProductos = new ArrayList();
            
            while (resultado.next()) {                
                producto = new Producto();                
                producto.setNombre(resultado.getString("nombre"));                
                listaProductos.add(producto);
            }
            desconectarBase();
            return listaProductos;            
            
        } catch (Exception e) {
            desconectarBase();
            throw new Exception ("Error de sistema");
        }
    }
    
    //Lista los nombres y los precios de todos los productos de la tabla producto.
    public ArrayList<Producto> listaNombrePrecioProductos() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto";
            consultarBase(sql);

            Producto producto = null;
            ArrayList<Producto> listaProductos = new ArrayList();
            
            while (resultado.next()) {                
                producto = new Producto();                
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));                
                listaProductos.add(producto);
            }
            desconectarBase();
            return listaProductos;            
            
        } catch (Exception e) {
            desconectarBase();
            throw new Exception ("Error de sistema");
        }
    }
    
    //Listar aquellos productos que su precio esté entre 120 y 202.
    public ArrayList<Producto> listaProductos() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio>=120 and precio<=202";
            consultarBase(sql);

            Producto producto = null;
            ArrayList<Producto> listaProductos = new ArrayList();
            
            while (resultado.next()) {                
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3)); 
                producto.setCodigo_fabricante(resultado.getInt(4));
                listaProductos.add(producto);
            }
            desconectarBase();
            return listaProductos;            
            
        } catch (Exception e) {
            desconectarBase();
            throw new Exception ("Error de sistema");
        }
    }
    
    //Buscar y listar todos los Portátiles de la tabla producto.
    public ArrayList<Producto> listaPortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE nombre like '%portátil%'";
            consultarBase(sql);

            Producto producto = null;
            ArrayList<Producto> listaProductos = new ArrayList();
            
            while (resultado.next()) {                
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3)); 
                producto.setCodigo_fabricante(resultado.getInt(4));
                listaProductos.add(producto);
            }
            desconectarBase();
            return listaProductos;            
            
        } catch (Exception e) {
            desconectarBase();
            throw new Exception ("Error de sistema");
        }
    }
    
    //Listar el nombre y el precio del producto más barato.
     public Producto ProductoMasBarato() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto WHERE precio = (SELECT min(precio) FROM producto)";
            consultarBase(sql);

            Producto producto = null;            
            
            while (resultado.next()) {                
                producto = new Producto();                
                producto.setNombre(resultado.getString(1));                 
                producto.setCodigo_fabricante(resultado.getInt(2));
            }
            desconectarBase();
            return producto;            
            
        } catch (Exception e) {
            desconectarBase();
            throw new Exception ("Error de sistema");
        }
    }
     
     public Producto buscarProductoPorNombre(String nombre) throws Exception{
         try {
             String sql = "SELECT * FROM producto where nombre = '"+nombre+"'";
             consultarBase(sql);
             
             Producto producto = null;
             while (resultado.next()) {                 
                 producto = new Producto();
                 producto.setCodigo(resultado.getInt(1));
                 producto.setNombre(resultado.getString(2));
                 producto.setPrecio(resultado.getDouble(3));
                 producto.setCodigo_fabricante(resultado.getInt(4));
             }
             desconectarBase();
             return producto;
         } catch (Exception e) {
             desconectarBase();
             throw e;
         }
         
     }
     
     
}
