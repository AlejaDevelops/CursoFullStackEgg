/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E7_1CalculadoraFracciones;

/**
 *
 * @author AlejaDevelops
 */
public class FraccionesMain {
    public static void main(String[] args) {
        System.out.println("*** CALCULADORA DE FRACCIONES ***");
        FraccionesService fs = new FraccionesService();
        Fracciones operacion1 = fs.crearFracciones();
        
        fs.servicio(operacion1);
        
        
        
    }
}
