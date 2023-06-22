/*
Programa Nespresso. Desarrolle una clase Cafetera con los atributos capacidadMaxima
(la cantidad máxima de café que puede contener la cafetera) y cantidadActual (la
cantidad actual de café que hay en la cafetera). Implemente, al menos, los siguientes
métodos:
 Constructor predeterminado o vacío OK
 Constructor con la capacidad máxima y la cantidad actual OK
 Métodos getters y setters. OK 
 Método llenarCafetera(): hace que la cantidad actual sea igual a la capacidad
máxima. OK
 Método servirTaza(int): se pide el tamaño de una taza vacía, el método recibe el
tamaño de la taza y simula la acción de servir la taza con la capacidad indicada. Si la
cantidad actual de café “no alcanza” para llenar la taza, se sirve lo que quede. El
método le informará al usuario si se llenó o no la taza, y de no haberse llenado en
cuanto quedó la taza. OK
 Método vaciarCafetera(): pone la cantidad de café actual en cero. OK
 Método agregarCafe(int): se le pide al usuario una cantidad de café, el método lo
recibe y se añade a la cafetera la cantidad de café indicada.ok
 */
package E6Nespresso;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class MainNespresso {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        NespressoService cs = new NespressoService();
        Nespresso cafetera1 = cs.llenarCafetera();
        int opcion;
        
       
        do {
            System.out.println("*** MENU CAFE ***");
            System.out.println("Cuál operación desea realizar?");
            System.out.println("1- Servir café");
            System.out.println("2- Agregar café");
            System.out.println("3- Vaciar cafetera");
            System.out.println("4- Salir");
            opcion = leer.nextInt();
            
            switch (opcion){
            case 1:
                cs.servirTaza(cafetera1);
                break;
            case 2:
                cs.agregarCafe(cafetera1);
                break;
            case 3:
                cs.vaciarCafetera(cafetera1);
                break;          
            case 4:
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Elección no válida");
        }
            
        } while (opcion!=4);
        
    }
    
    
    
    
    
    
    
 
    
    
    
    
    
            
} 
