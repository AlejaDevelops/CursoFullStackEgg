
package E3EcuacionSegundoGrado;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class RaicesService {
    Scanner leer = new Scanner(System.in);
    
    public Raices crearEcuacion(){
        Raices coeficientes = new Raices();
        System.out.println("A continuación ingresa el valor del los coeficientes de la ecuación");
        System.out.println("Valor de ´a´");
        coeficientes.setA(leer.nextDouble());
        System.out.println("Valor de ´b´");
        coeficientes.setB(leer.nextDouble());
        System.out.println("Valor de ´c´");
        coeficientes.setC(leer.nextDouble());        
        return coeficientes;
    }
    
    public double getDiscriminante(Raices a){
        double discriminante = Math.pow(a.getB(), 2)-(4*a.getA()*a.getC());
        return discriminante;    
    }
    
    public boolean tieneRaices(Raices b){       
        return getDiscriminante(b)>0;        
    }
    
    public void obtenerRaices(Raices d){
        if (tieneRaices(d)) {
            double raiz1 = ((-1*d.getB())+Math.sqrt(Math.pow(d.getB(), 2)-(4*d.getA()*d.getC())))/(2*d.getA());
            double raiz2 = ((-1*d.getB())-Math.sqrt(Math.pow(d.getB(), 2)-(4*d.getA()*d.getC())))/(2*d.getA());              
            
            System.out.println("Las raíces de la ecuación (soluciones) son:");
            System.out.println("X1 = "+raiz1);          
            System.out.println("X2 = "+raiz2);
        }
    }
    
    public boolean tieneRaiz(Raices c){       
        return getDiscriminante(c)==0;        
    }
    
    public void obtenerRaiz(Raices e){
        if (tieneRaiz(e)) {
            double raiz = (-1*e.getB())/(2*e.getA());                        
            
            System.out.println("Las raíces de la ecuación (soluciones) son:");
            System.out.println("X1 = X2 = "+raiz);          
            
        }
    }
    
    public void calcular(Raices f){        
        
        if (tieneRaices(f)) {
            obtenerRaices(f);
        }
        if (tieneRaiz(f)) {
            obtenerRaiz(f);
        }
        if (getDiscriminante(f)<0) {
            System.out.println("La ecuación no tiene raíces (solución) en el campo de los números Reales");
        }
        
        
    }
        
    
        
    
}
