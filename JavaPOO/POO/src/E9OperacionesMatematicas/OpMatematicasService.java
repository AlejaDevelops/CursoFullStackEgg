
package E9OperacionesMatematicas;

/**
 *
 * @author AlejaDevelops
 */
public class OpMatematicasService {
    
    public OpMatematicas devolverMayor(OpMatematicas a){        
        
        if (a.getNumero1()>a.getNumero2()) {
            a.setNumeroMayor(a.getNumero1());
            a.setNumeroMenor(a.getNumero2());
        } else if (a.getNumero1()<a.getNumero2()) {
            a.setNumeroMayor(a.getNumero2());
            a.setNumeroMenor(a.getNumero1());
            
        } else {
            System.out.println("ERROR - Los números son iguales");
            a.setNumeroMayor(0);
            a.setNumeroMenor(0);
        }        
        return a;        
    }
    
    public double calcularPotencia(OpMatematicas b){        
        
        double potencia = Math.pow(Math.round(b.getNumeroMayor()), Math.round(b.getNumeroMenor()));
        
        return potencia;
    }
    
    public double calcularRaiz(OpMatematicas c){
        double raiz = Math.sqrt(Math.abs(c.getNumeroMenor()));
        return raiz;
    }
    
}
