/*
 * RECOLECCIÓN Y VALIDACION DE LOS DATOS ANTES DE ACCEDER A LA BASE DE DATOS
 */

package Tienda.servicios;

import Tienda.entidades.Producto;
import Tienda.persistencia.ProductosDAO;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class ProductoServicio {
    
    private ProductosDAO dao = new ProductosDAO();    

    //public ProductoServicio() {
    //    this.dao = new ProductosDAO();
    //}
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearProducto(String nombre, double precio, int codigo_fabricante) throws Exception{ // Los atributos deben ingresar como String?
        try {
            //VALIDACIONES DE LOS DATOS INGRESADOS
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre de producto");                
            }
            if (dao.buscarProductoPorNombre(nombre) != null) {
                throw new Exception("El nombre ingresado ya existe");
            }
            if (precio < 0) {
                throw new Exception("Debe ingresar un número válido"); //PENDIENTE REVISIÓN DE LA CONVERSION DE LA COMA QUE SEPARA EL DECIMAL EN BD DEBE ESTAR CON PUNTO QU
            } 
             if (codigo_fabricante < 0) {
                throw new Exception("Debe indicar un código válido");                
            }
             // se debe revisar que el código no esté ya registrado
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigo_fabricante(codigo_fabricante);
            
            dao.ingresarProducto(producto);
            
        } catch (Exception e) {
            throw e;
        }
         
    }
    
    public Producto leerDatosProducto(){
        Producto producto = new Producto();
        System.out.println("Ingresa el nombre del producto");
        producto.setNombre(leer.next());
        System.out.println("Ingresa su precio");
        producto.setPrecio(leer.nextDouble());
        System.out.println("Ingresa el código del fabricante");
        producto.setCodigo_fabricante(leer.nextInt());        
        return producto; 
    }
    
    
    
    

    
}
