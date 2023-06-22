
package E3OperacionesMatematicas;

/**
 *
 * @author AlejaDevelops
 */
public class OperacionesMat {
    private int numero1;
    private int numero2;
    private int suma;
    private int resta;
    private int multiplicacion;
    private int division;

    public OperacionesMat() {
    }

    public OperacionesMat(int numero1, int numero2, int suma, int resta, int multiplicacion, int division) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.suma = suma;
        this.resta = resta;
        this.multiplicacion = multiplicacion;
        this.division = division;
    }

    public int getNumero1() {
        return numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public int getSuma() {
        return suma;
    }

    public int getResta() {
        return resta;
    }

    public int getMultiplicacion() {
        return multiplicacion;
    }

    public int getDivision() {
        return division;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public void setResta(int resta) {
        this.resta = resta;
    }

    public void setMultiplicacion(int multiplicacion) {
        this.multiplicacion = multiplicacion;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "OperacionesMat{" + "numero1=" + numero1 + ", numero2=" + numero2 + ", suma=" + suma + ", resta=" + resta + ", multiplicacion=" + multiplicacion + ", division=" + division + '}';
    }
    
    
}
