    /*
Crea una clase Auto. Como atributos tendrá nombre del dueño, fecha vencimiento carnet, color del
vehículo, modelo y KM en motor (deberá ser inicializado por defecto en 7500km),
Crear métodos que permitan:
● Que un usuario cargue su ficha del auto.
● Que el usuario, modifique la titularidad del vehículo.
● Indicar un trayecto recorrido, modificando de este modo los KM del motor
● Crear un método que indique si es necesario realizar Service al vehículo, considerando que
al llegar a los 10.000km corresponde realizarlo.
 */
package E13_7Auto;

import java.util.Date;

/**
 *
 * @author AlejaDevelops
 */
public class Auto {
    private String nombre;
    private Date fechaVencLicencia;
    private String color;
    private int modelo;
    private int km = 7500;

    public Auto() {
    }

    public Auto(String nombre, Date fechaVencLicencia, String color, int modelo) {
        this.nombre = nombre;
        this.fechaVencLicencia = fechaVencLicencia;
        this.color = color;
        this.modelo = modelo;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaVencLicencia() {
        return fechaVencLicencia;
    }

    public void setFechaVencLicencia(Date fechaVencLicencia) {
        this.fechaVencLicencia = fechaVencLicencia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
    
    
}
