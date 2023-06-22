/*
Definir una Clase que contenga algún tipo de dato de tipo array y agregue el código para
generar y capturar una excepción ArrayIndexOutOfBoundsException (índice de arreglo fuera
de rango).
 */

package E2ArrayIndexOutOfBoundsException;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author AlejaDevelops
 */
public class ClaseConArray {
    private String nombrePlanilla;
    private int numPlanilla;
    private LocalDate fechaLlenado;
    private ArrayList<String> listaPersonas;

    public ClaseConArray() {
    }

    public ClaseConArray(String nombrePlanilla, int numPlanilla, LocalDate fechaLlenado, ArrayList<String> listaPersonas) {
        this.nombrePlanilla = nombrePlanilla;
        this.numPlanilla = numPlanilla;
        this.fechaLlenado = fechaLlenado;
        this.listaPersonas = listaPersonas;
    }

    public String getNombrePlanilla() {
        return nombrePlanilla;
    }

    public void setNombrePlanilla(String nombrePlanilla) {
        this.nombrePlanilla = nombrePlanilla;
    }

    public int getNumPlanilla() {
        return numPlanilla;
    }

    public void setNumPlanilla(int numPlanilla) {
        this.numPlanilla = numPlanilla;
    }

    public LocalDate getFechaLlenado() {
        return fechaLlenado;
    }

    public void setFechaLlenado(LocalDate fechaLlenado) {
        this.fechaLlenado = fechaLlenado;
    }

    public ArrayList<String> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<String> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @Override
    public String toString() {
        return "Clase {" + "Titulo planilla: " + nombrePlanilla + ", Numero planilla: " + numPlanilla + ", Fecha de llenado: " + fechaLlenado;
    }

    
    
    

}
