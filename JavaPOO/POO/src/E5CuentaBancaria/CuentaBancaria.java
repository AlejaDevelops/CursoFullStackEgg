
package E5CuentaBancaria;

/**
 *
 * @author AlejaDevelops
 */
public class CuentaBancaria {
    
    private int cuentaBancaria;
    private long dni;
    private double saldoCuenta;
    private double interes;

    public CuentaBancaria() {
    }

    public CuentaBancaria(int cuentaBancaria, long dni, int saldoCuenta, double interes) {
        this.cuentaBancaria = cuentaBancaria;
        this.dni = dni;
        this.saldoCuenta = saldoCuenta;
        this.interes = interes;
    }

    public int getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(int cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + "cuentaBancaria=" + cuentaBancaria + ", dni=" + dni + ", saldoCuenta=" + saldoCuenta + ", interes=" + interes + '}';
    }
    
    
    
 
    
    
}
