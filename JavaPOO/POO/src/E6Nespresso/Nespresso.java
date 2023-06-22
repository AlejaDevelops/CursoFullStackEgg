
package E6Nespresso;

/**
 *
 * @author AlejaDevelops
 */
public class Nespresso {
    
    private int capacidadMaxCafetera;
    private int cantidadActual;

    public Nespresso() {
    }

    public Nespresso(int capacidadMaxCafetera, int cantidadActual) {
        this.capacidadMaxCafetera = capacidadMaxCafetera;
        this.cantidadActual = cantidadActual;
    }

    public int getCapacidadMaxCafetera() {
        return capacidadMaxCafetera;
    }

    public void setCapacidadMaxCafetera(int capacidadMaxCafetera) {
        this.capacidadMaxCafetera = capacidadMaxCafetera;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    @Override
    public String toString() {
        return "Nespresso{" + "capacidadMaxCafetera=" + capacidadMaxCafetera + ", cantidadActual=" + cantidadActual + '}';
    }
            
}
