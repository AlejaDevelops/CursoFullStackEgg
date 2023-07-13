/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private ProductosDAO dao;    

    public ProductoServicio() {
        this.dao = new ProductosDAO();
    }
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearProducto(int codigo, String nombre, double precio, int codigo_fabricante) throws Exception{
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
             // se debe revisar que el código no esté ya registrado
            Producto producto = new Producto();
            producto.setCodigo(codigo);
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
        System.out.println("Ingresa el código del producto");
        producto.setCodigo(leer.nextInt());
        System.out.println("Ingresa el nombre del producto");
        producto.setNombre(leer.next());
        System.out.println("Ingresa su precio");
        producto.setPrecio(leer.nextDouble());
        System.out.println("Ingresa el código del fabricante");
        producto.setCodigo_fabricante(leer.nextInt());        
        return producto; 
    }
    
    public void menu() throws Exception{       
        int n;
        Producto producto = new Producto();
        
        do {            
             System.out.println("Seleccionar una opción del menú \n"
                +"\n 1 - Listar el nombre de todos los productos que hay en la tabla producto."
                +"\n 2 - Listar los nombres y los precios de todos los productos de la tabla producto"
                +"\n 3 - Listar aquellos productos que su precio esté entre 120 y 202" 
                +"\n 4 - Buscar y listar todos los Portátiles de la tabla producto"
                +"\n 5 - Listar el nombre y el precio del producto más barato"
                +"\n 6 - Ingresar un producto a la base de datos"
                +"\n 7 - Ingresar un fabricante a la base de datos"
                +"\n 8 - Editar un producto con datos a elección"
                +"\n 9 - Salir");
        n = leer.nextInt();
        
        switch (n){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;                
            case 6:
                producto = leerDatosProducto();
                crearProducto(producto.getCodigo(),producto.getNombre(), producto.getPrecio(), producto.getCodigo_fabricante());
                System.out.println("Producto registrado exitosamente");
                System.out.println("----------------------------------------");
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Opción no válida, intenta nuevamente");
        }
        } while (n != 9);
    }
    
    
    

    
}
