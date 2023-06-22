/*
Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. 
Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase 

Persona con atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
 */
package E1AdopcionPerro;

/**
 *
 * @author AlejaDevelops
 */
public class Persona {
    private String nombreP;
    private String apellido;
    private int edadP;
    private long documento;
    private Perro perro;

    public Persona() {
    }

    public Persona(String nombreP, String apellido, int edadP, long documento, Perro perro) {
        this.nombreP = nombreP;
        this.apellido = apellido;
        this.edadP = edadP;
        this.documento = documento;
        this.perro = perro;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdadP() {
        return edadP;
    }

    public void setEdadP(int edadP) {
        this.edadP = edadP;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombreP=" + nombreP + ", apellido=" + apellido + ", edadP=" + edadP + ", documento=" + documento + ", perro=" + perro + '}';
    }
    
    
    
}
