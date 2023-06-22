
package E3OperacionesMatematicas;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class OperacionesMatServicio {
    
    public OperacionesMat crearOperacion (){
        OperacionesMat n = new OperacionesMat();
        
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el primer número");
        n.setNumero1(leer.nextInt());
        System.out.println("Ingrese el segundo número");
        n.setNumero2(leer.nextInt());
        
        return n;
    }
    
    public int suma(OperacionesMat n){
        n.setSuma(n.getNumero1()+n.getNumero2());
        return n.getSuma();
    }
    
    public int resta(OperacionesMat n){
        n.setResta(n.getNumero1()- n.getNumero2());
        return n.getResta();
    }
    
    public int multiplicacion(OperacionesMat n){
        
        n.setMultiplicacion(n.getNumero1()*n.getNumero2());
        
        if (n.getNumero1()==0 || n.getNumero2()==0) {
            System.out.println("ERROR - Uno de los operadores ingresados es cero.");
        } 
        
        return n.getMultiplicacion();
    }
    
    public int division(OperacionesMat n){
        if (n.getNumero2()==0) {
            System.out.println("ERROR - El denominador ingresado es 0 (cero");
            System.out.println("No se puede realizar la división entre 0");
            return 0;
        } else {
            n.setDivision(n.getNumero1()/ n.getNumero2());
            return n.getDivision();  
        }
        
    }
}
