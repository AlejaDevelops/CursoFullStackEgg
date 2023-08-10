/*
MENU DE OPCIONES
 */
package Tienda.servicios;

import Tienda.entidades.Fabricantes;
import Tienda.entidades.Producto;
import Tienda.persistencia.FabricantesDAO;
import Tienda.persistencia.ProductosDAO;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class TiendaServicios {

    public void menu() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ProductosDAO dao = new ProductosDAO();
        ProductoServicio ps = new ProductoServicio();
        FabricantesServicio fs = new FabricantesServicio();
        FabricantesDAO fdao = new FabricantesDAO();
        int n;

        do {
            System.out.println("Seleccionar una opción del menú \n"
                    + "\n 1 - Realizar una consulta en la base de datos de los productos."
                    + "\n 2 - Ingresar un producto a la base de datos"
                    + "\n 3 - Ingresar un fabricante a la base de datos"
                    + "\n 4 - Editar un producto con datos a elección"
                    + "\n 5 - Listar los fabricantes"
                    + "\n 6 - Salir");
            n = leer.nextInt();

            switch (n) {
                case 1:
                    dao.consultas();
                    System.out.println("----------------------------------------");
                    break;
                case 2:
                    Producto producto = ps.leerDatosProducto();
                    ps.crearProducto(producto.getNombre(), producto.getPrecio(), producto.getCodigo_fabricante());
                    System.out.println("Producto registrado exitosamente");
                    System.out.println("----------------------------------------");
                    break;
                case 3:
                    Fabricantes fabricante = fs.leerDatosFabricante();
                    fs.crearFabricante(fabricante.getNombre());
                    System.out.println("Fabricante registrado exitosamente");
                    System.out.println("----------------------------------------");
                    break;
                case 4:
                    dao.editarProducto();
                    System.out.println("----------------------------------------");
                    break;
                case 5:
                    fdao.listaFabricantes();
                    System.out.println("----------------------------------------");
                    break;
                case 6:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Opción no válida, intenta nuevamente");
            }
        } while (n != 10);
    }

}
