/*
Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
productos que venderemos y el precio que tendrán. Además, se necesita que la
aplicación cuente con las funciones básicas.
Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package E6ProductosTienda;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class ProductoService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    
    
    public HashMap<String, Double> crearProductos(HashMap<String, Double> b){        
        String nombre, option;
        Double precio;
        
        do {
            System.out.println("Ingresa el nombre del producto");
            nombre = leer.next();
            System.out.println("Ingresa su precio");
            precio = leer.nextDouble();
            b.put(nombre, precio);
            System.out.println("Desea ingresar otro producto?");
            option = leer.next();
        } while (option.equalsIgnoreCase("si"));
        
        return b;
    }
    
    public void imprimirMap(HashMap<String, Double> a){
        System.out.println("------ Listado de Productos ------");
        for (Map.Entry<String, Double> entry : a.entrySet()) {
            System.out.println("Nombre: "+entry.getKey()+"   -- Precio: $"+entry.getValue());         
            
        }
        
    }
    
    public void menu(){
        HashMap<String, Double> mapaProductos = new HashMap();
        int option;
        do {
            System.out.println("----------------------------");
            System.out.println("Elige una opción del menú: "
                + "\n 1 - Agregar productos"
                + "\n 2 - Modificar un precio"
                + "\n 3 - Eliminar un producto"
                + "\n 4 - Ver listado de productos"
                + "\n 5 - Salir");
        option = leer.nextInt();
        
        switch (option){
            case 1:                
                crearProductos(mapaProductos);
                break;
            case 2:
                modificarPrecio(mapaProductos);
                break;
            case 3:
                eliminarProducto(mapaProductos);
                break;
            case 4:
                imprimirMap(mapaProductos);
                break;
            case 5:
                System.out.println("Bye!");
            
            default:
                System.out.println("Opción inválida, intenta nuevamente");           
                
        }
            
        } while (option!=5);
        
    }
    
    private void modificarPrecio(HashMap<String, Double> c){
        System.out.println("----------------------------");
        System.out.println("Ingresa el nombre del producto al que deseas modificar su precio");
        String nombre = leer.next();
        boolean flag = false;
        
        for (Map.Entry<String, Double> entry : c.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(nombre)) {
                System.out.println("Ingresa el nuevo precio");
                entry.setValue(leer.nextDouble());
                flag = true;
            }         
        }
        if (!flag) {
            System.out.println("El producto no se encuentra en la lista");
        }
    }
    
    private void eliminarProducto(HashMap<String, Double> d){
        System.out.println("----------------------------");
        System.out.println("Ingresa el nombre del producto que deseas eliminar");
        String nombre = leer.next();
        boolean flag = false;
        
        for (Map.Entry<String, Double> entry : d.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(nombre)) {
                d.remove(nombre);
                System.out.println("Producto eliminado");
                flag = true;
                break;
            }           
        }
        if (!flag) {
            System.out.println("El producto no se encuentra en la lista");
        }
    }
    
    
}
