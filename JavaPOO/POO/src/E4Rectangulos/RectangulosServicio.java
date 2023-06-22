
package E4Rectangulos;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class RectangulosServicio {
   
    public Rectangulos crearRectangulo(){
        Scanner leer = new Scanner(System.in);
        
        Rectangulos r = new Rectangulos();
        System.out.println("Ingrese la base del rectángulo: ");
        r.setBase(leer.nextInt());
        System.out.println("Ingrese la altura del rectángulo: ");
        r.setAltura(leer.nextInt());
        
        return r;
        
    }
    
    public int superficie(Rectangulos a){
        a.setSuperficie(a.getBase()*a.getAltura());
        return a.getSuperficie();
    }
    
    public int perimetro(Rectangulos b){
    b.setPerimetro(2*(b.getBase()+b.getAltura()));
    return b.getPerimetro();
    }
    
    public void dibujarRectangulo(Rectangulos c){
        
        System.out.println("El dibujo del rectángulo es: ");
        for (int i = 0; i < c.getAltura(); i++) {
            for (int j = 0; j < c.getBase(); j++) { 
                if (i==0 || i==c.getAltura()-1 ) {
                    System.out.print("*");                    
                }
                if (i>0 && i<c.getAltura()-1) {
                    if (j==0 || j==c.getBase()-1) {
                    System.out.print("*");   

                    } else{
                        System.out.print(" "); 
                    }
                    
                }
                
                
            }
            System.out.println("");
        }
    }
    
    
}
