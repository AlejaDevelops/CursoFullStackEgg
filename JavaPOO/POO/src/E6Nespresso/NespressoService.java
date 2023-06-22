
package E6Nespresso;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class NespressoService {
    
    Scanner leer = new Scanner(System.in);
    
    public Nespresso llenarCafetera(){      
        Nespresso cafetera = new Nespresso();
        
        System.out.println("¿De qué tamaño es tu cafetera en mL?");           
        cafetera.setCapacidadMaxCafetera(leer.nextInt());        
        cafetera.setCantidadActual(cafetera.getCapacidadMaxCafetera());
        
        return cafetera;              
    }
    
    
    public void servirTaza(Nespresso a){
        
        if (a.getCantidadActual()==0) {
            System.out.println("Lo siento, no hay café :(");
            
            
        } else {
            System.out.println("Servicio de servido de café activado");
            System.out.println("¿De qué tamaño es tu taza en mL?");
            int tamanoTaza = leer.nextInt();

            if (tamanoTaza>a.getCantidadActual()) {
                System.out.println("La cantidad de café actual es insuficiente para llenar tu taza");
                System.out.println("El porcentaje llenado de la taza es " + (a.getCantidadActual()*100)/tamanoTaza+ "%");
                a.setCantidadActual(0);
                System.out.println("La cantidad disponible es: "+a.getCantidadActual());
            } else{
                System.out.println("Sirviendo café...");
                System.out.println("He llenado tu taza");
                a.setCantidadActual(a.getCantidadActual()- tamanoTaza);
                System.out.println("La cantidad disponible es: "+a.getCantidadActual());
        }
        }
  
    }
    
    public void vaciarCafetera(Nespresso b){
        if (b.getCantidadActual()==0) {
            System.out.println("La cafetera ya está vacía.");
        } else{
            System.out.println("Vaciando cafetera...");
            b.setCantidadActual(0);
            System.out.println("Cafetera vacía.");
        }
        
        
    }
    
    public void agregarCafe(Nespresso c){
        System.out.println("Qué cantidad de café deseas agregar?");
        int cantidadCafe = leer.nextInt();
        
        if (cantidadCafe+c.getCantidadActual()>c.getCapacidadMaxCafetera()) {           
            System.out.println("ERROR - La cantidad de café que deseas agregar sobrepasa la capacidad de la cafetera");
            System.out.println("No se puede agregar la cantidad de café deseada");
        }else{
            System.out.println("Cantidad de café agregada");
            c.setCantidadActual(c.getCantidadActual()+cantidadCafe);
            System.out.println("La cantidad disponible es: "+c.getCantidadActual());
        }
    
  
        
    }
   
}
