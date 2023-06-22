/*
Crear una clase llamada fracción que contenga 4 atributos (denominador y numerador de cada
fracción). Crear la clase servicio que contenga métodos para sumar, restar, multiplicar y dividir
fracciones. Mostrar por pantalla un menú de opciones para que el usuario decida que ver.
 */
package E7_1CalculadoraFracciones;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class FraccionesService {
    Scanner leer = new Scanner(System.in);
    
    public Fracciones crearFracciones(){
        Fracciones operacion1 = new Fracciones();        
        System.out.println("Ingresa el numerador del número 1");
        operacion1.setNum1(leer.nextInt());
        System.out.println("Ingresa el denominador del número 1");
        operacion1.setDenom1(leer.nextInt());
        System.out.println("Ingresa el numerador del número 2");
        operacion1.setNum2(leer.nextInt());
        System.out.println("Ingresa el denominador del número 2");
        operacion1.setDenom2(leer.nextInt());   
        
        return operacion1;         
    }
    
    public void servicio(Fracciones a){        
        int eleccion = 0;
        do {
            System.out.println("Elige una operación del menú");
            System.out.println("1 - Suma");
            System.out.println("2 - Resta");
            System.out.println("3 - Multiplicación");
            System.out.println("4 - División");
            System.out.println("5 - Ingresar unos números nuevos");
            System.out.println("6 - Salir");
            eleccion = leer.nextInt();
            
            switch(eleccion){
                case 1: suma(a);
                    break;
                case 2: resta(a);
                    break;
                case 3: multiplicacion(a);
                    break;
                case 4: division(a);
                    break;
                case 5: 
                    System.out.println("Ingresa el numerador del número 1");
                    a.setNum1(leer.nextInt());
                    System.out.println("Ingresa el denominador del número 1");
                    a.setDenom1(leer.nextInt());
                    System.out.println("Ingresa el numerador del número 2");
                    a.setNum2(leer.nextInt());
                    System.out.println("Ingresa el denominador del número 2");
                    a.setDenom2(leer.nextInt());
                    break;
                case 6: System.out.println("Bye!");
                
                default:    
                    System.out.println("Elección no válida, intenta nuevamente!");
            }             

        } while (eleccion!=6);  
 
    }
    
    private void suma(Fracciones b){
        int numSuma = (b.getNum1()*b.getDenom2())+(b.getDenom1()*b.getNum2());
        int denSuma = b.getDenom1()*b.getDenom2();
        
        System.out.println("La suma de los fraccionarios ingresados es:" );
        System.out.println(b.getNum1()+"/"+b.getDenom1()+"+"+b.getNum2()+"/"+b.getDenom2()+" = "+numSuma+" / "+denSuma);        
    }
    
    private void resta(Fracciones b){
        int numResta = (b.getNum1()*b.getDenom2())-(b.getDenom1()*b.getNum2());
        int denResta = b.getDenom1()*b.getDenom2();
        
        System.out.println("La resta de los fraccionarios ingresados es:" );
        System.out.println(b.getNum1()+"/"+b.getDenom1()+"-"+b.getNum2()+"/"+b.getDenom2()+" = "+numResta+" / "+denResta);        
    }
    
    private void multiplicacion(Fracciones b){
        int numMult = b.getNum1()*b.getNum2();
        int denMult = b.getDenom1()*b.getDenom2();
        
        System.out.println("La resta de los fraccionarios ingresados es:" );
        System.out.println(b.getNum1()+"/"+b.getDenom1()+"-"+b.getNum2()+"/"+b.getDenom2()+" = "+numMult+" / "+denMult);
    }
    
    private void division(Fracciones b){
        int numDiv = b.getNum1()*b.getDenom2();
        int denDiv = b.getDenom1()*b.getNum2();
        
        System.out.println("La resta de los fraccionarios ingresados es:" );
        System.out.println(b.getNum1()+"/"+b.getDenom1()+"-"+b.getNum2()+"/"+b.getDenom2()+" = "+numDiv+" / "+denDiv);
    }
}
