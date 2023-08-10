/*
 * METODOS QUE CONTIENEN LAS SENTENCIAS PARA ACCEDER A LA BASE DE DATOS
 */
package Tienda.persistencia;

import Tienda.entidades.Producto;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public final class ProductosDAO extends TiendaDAO {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    FabricantesDAO fdao = new FabricantesDAO();

    //Ingresar un producto a la base de datos.
    public void ingresarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe registrar un producto");
            }

            String sql = "INSERT INTO producto VALUES('" + producto.getCodigo() + "','" + producto.getNombre() + "','" + producto.getPrecio() + "','" + producto.getCodigo_fabricante() + "');";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    //Editar un producto con datos a elección.
    public void editarProducto() throws Exception {
        Producto producto = null;

        try {
            System.out.println("Ingresa el código del producto que deseas editar ");
            int codigo = leer.nextInt();
            producto = buscarProductoPorCodigo(codigo);

            if (codigo < 0) {
                throw new Exception("Debe indicar un código de producto válido");
            }
            if (producto == null) {
                throw new Exception("El código ingresado no se encuentra en la base de datos");
            }
        } catch (Exception e) {
            throw e;
        }

        System.out.println("Selecciona el dato que deseas editar: "
                + "\n 1 - Nombre"
                + "\n 2 - Precio"
                + "\n 3 - Código del fabricante");
        int input = leer.nextInt();

        switch (input) {
            case 1:
                editarNombreProducto(producto);
                System.out.println("Nombre cambiado exitosamente");
                break;
            case 2:
                editarPrecioProducto(producto);
                System.out.println("Precio cambiado exitosamente");
                break;
            case 3:
                editarCodFabricanteProducto(producto);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    public void editarNombreProducto(Producto producto) throws Exception {

        System.out.println("Cuál es el nuevo nombre que deseas asignarle al producto?");
        String nombreNuevo = leer.next();
        String sql = "UPDATE producto SET " + "nombre = '" + nombreNuevo + "' WHERE codigo = '" + producto.getCodigo() + "'";
        insertarModificarEliminar(sql);
    }

    public void editarPrecioProducto(Producto producto) throws Exception {

        System.out.println("Cuál es el nuevo precio del producto?");
        double nuevoPrecio = leer.nextDouble();
        String sql = "UPDATE producto SET " + "precio = '" + nuevoPrecio + "' WHERE codigo = '" + producto.getCodigo() + "' ";
        insertarModificarEliminar(sql);
    }

    public void editarCodFabricanteProducto(Producto producto) throws Exception {
        try {
            System.out.println("Cuál es el nuevo código del fabricante?");
            int nuevoCodigo = leer.nextInt();
            
            if (fdao.buscarFabricantePorCodigo(nuevoCodigo) == null) {
                throw new Exception("El código de fabricante ingresado no se encuentra registrado en la base de datos. Por favor registrarlo primero");
            }
            if (nuevoCodigo < 0) {
                throw new Exception("Por favor ingresar un código válido");
            }
            String sql = "UPDATE producto SET " + "codigo_fabricante = '" + nuevoCodigo + "' WHERE codigo = '" + producto.getCodigo() + "' ";
            insertarModificarEliminar(sql);
            System.out.println("Código de fabricante cambiado exitosamente");
        } catch (Exception e) {
            throw e; //DEBO EDITAR PARA QUE NO SE CIERRE AL ACTIVARSE LA EXCEPCION
        }

    }

    // Consultas varias
    public void consultas() throws Exception {
        ProductosDAO pdao = new ProductosDAO();

        System.out.println("Elige la consulta que deseas realizar"
                + "\n a - Listar el nombre de todos los productos que hay en la tabla producto."
                + "\n b - Listar los nombres y los precios de todos los productos de la tabla producto"
                + "\n b - Listar aquellos productos que su precio esté entre 120 y 202"
                + "\n d - Buscar y listar todos los Portátiles de la tabla producto"
                + "\n e - Listar el nombre y el precio del producto más barato");
        String n = leer.next();

        switch (n) {
            case "a":
                pdao.listaNombreProductos();
                System.out.println("----------------------------------------");
                break;
            case "b":
                pdao.listaNombrePrecioProductos();
                System.out.println("----------------------------------------");
                break;
            case "c":
                pdao.listaProductos();
                System.out.println("----------------------------------------");
                break;
            case "d":
                pdao.listaPortatiles();
                break;
            case "e":
                pdao.ProductoMasBarato();
                System.out.println("----------------------------------------");
                break;
            default:
                System.out.println("Opción no válida");
        }

    }
    
    public void listaNombreProductos() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto";
            consultarBase(sql);

            System.out.println("*** Lista de productos ***");
            while (resultado.next()) {
                Producto producto = new Producto();
                producto.setNombre(resultado.getString(1));
                System.out.println(producto.getNombre());
            }
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public void listaNombrePrecioProductos() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto";
            consultarBase(sql);

            System.out.println("*** Lista de productos y precios ***");
            while (resultado.next()) {
                Producto producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                System.out.println("NOMBRE: " + producto.getNombre() + ",  PRECIO: $" + producto.getPrecio());
            }
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
   
    public void listaProductos() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio>=120 and precio<=202";
            consultarBase(sql);

            System.out.println("** Productos con precios entre $120 y $202 ***");
            while (resultado.next()) {
                Producto producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                System.out.println(producto.toString());
            }
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    public void listaPortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE nombre like '%portátil%'";
            consultarBase(sql);

            while (resultado.next()) {
                Producto producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                System.out.println(producto.toString());
            }
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    public void ProductoMasBarato() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto WHERE precio = (SELECT min(precio) FROM producto)";
            consultarBase(sql);

            while (resultado.next()) {
                Producto producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getInt(2));
                System.out.println("NOMBRE: " + producto.getNombre() + ", PRECIO: $" + producto.getPrecio());
            }
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

    public Producto buscarProductoPorNombre(String nombre) throws Exception {
        try {
            String sql = "SELECT * FROM producto where nombre = '" + nombre + "'";
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

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {

        try {
            String sql = "SELECT * FROM producto WHERE codigo = '" + codigo + "'";
            consultarBase(sql);
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
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
