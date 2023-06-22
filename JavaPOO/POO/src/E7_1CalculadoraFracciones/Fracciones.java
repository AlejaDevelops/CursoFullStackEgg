/*
Crear una clase llamada fracción que contenga 4 atributos (denominador y numerador de cada
fracción). Crear la clase servicio que contenga métodos para sumar, restar, multiplicar y dividir
fracciones. Mostrar por pantalla un menú de opciones para que el usuario decida que ver.
 */
package E7_1CalculadoraFracciones;

/**
 *
 * @author AlejaDevelops
 */
public class Fracciones {
    private int num1;
    private int denom1;
    private int num2;
    private int denom2;

    public Fracciones() {
    }

    public Fracciones(int num1, int denom1, int num2, int denom2) {
        this.num1 = num1;
        this.denom1 = denom1;
        this.num2 = num2;
        this.denom2 = denom2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getDenom1() {
        return denom1;
    }

    public void setDenom1(int denom1) {
        this.denom1 = denom1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getDenom2() {
        return denom2;
    }

    public void setDenom2(int denom2) {
        this.denom2 = denom2;
    }

    @Override
    public String toString() {
        return "Fracciones{" + "num1=" + num1 + ", denom1=" + denom1 + ", num2=" + num2 + ", denom2=" + denom2 + '}';
    }
    
    
    
}
