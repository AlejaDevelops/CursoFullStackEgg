
package E14RegistroEquiposCelulares;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class MovilService {
    Scanner leer = new Scanner(System.in);
    
    public Movil cargarCelular(){
        Movil celular1 = new Movil();
        System.out.println("Registro de un nuevo equipo celular");
        System.out.println("Ingresa la marca");
        celular1.setMarca(leer.nextLine());
        System.out.println("Ingresa el modelo");
        celular1.setModelo(leer.nextLine());
        System.out.println("Ingresa la memoria RAM");
        celular1.setMemoriaRam(leer.nextLine());
        System.out.println("Ingresa la capacidad de almacenamiento");
        celular1.setAlmacenamiento(leer.nextLine());
        System.out.println("Ingresa el precio");
        celular1.setPrecio(leer.nextInt());
        
       return celular1;                
    }
    
    public Movil ingresarCodigo(Movil a){
        System.out.println("Cargar código del equipo");
        int[] vectorAux = new int[7];
        
        for (int i = 0; i < vectorAux.length; i++) {
            System.out.println("Ingresa el dígito "+(i+1)+" del código");
            vectorAux[i]=leer.nextInt();
        }
        a.setCodigo(vectorAux);
        System.out.println("código registrado correctamente");
        return a;
    }
    
    public void mostarEquipo(Movil b){
        System.out.println("DATOS DEL EQUIPO");
        System.out.println("Marca: "+b.getMarca());
        System.out.println("Memoria RAM: "+b.getMemoriaRam());
        System.out.println("Capacidad de almacenamiento: "+b.getAlmacenamiento());
        System.out.println("Precio: "+b.getPrecio());
        System.out.println("Código: "+Arrays.toString(b.getCodigo()));
    }
}
