
package Tienda.entidades;

/**
 *
 * @author AlejaDevelops
 */
public class Producto {
    
    private int codigo;
    private String nombre;
    private double precio;
    private int codigo_fabricante; //OJO ES LA LLAVE FORANEA PARA ACCEDER A LA TABLA FABRICANTE

    public Producto() {
    }   

    public Producto(int codigo, String nombre, double precio, int codigo_fabricante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.codigo_fabricante = codigo_fabricante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo_fabricante() {
        return codigo_fabricante;
    }

    public void setCodigo_fabricante(int codigo_fabricante) {
        this.codigo_fabricante = codigo_fabricante;
    }

    @Override
    public String toString() {
        return "Producto{" + "Codigo: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio + ", Codigo_fabricante: " + codigo_fabricante + '}';
    }
    
   
    
}
