
package E9OperacionesMatematicas;

/**
 *
 * @author AlejaDevelops
 */
public class OpMatematicasMain {


    public static void main(String[] args) {
        
        System.out.println("*** OPERACIONES MATEMATICAS CON NUMEROS ALEATORIOS ***");
        
        OpMatematicas objeto1 = new OpMatematicas();
        
        double num1 = Math.random()*5;
        double num2 = Math.random()*5;   
        objeto1.setNumero1(num1-num2); //NOTA: Solo genera números positivos
        
        num1 = Math.random()*5;
        num2 = Math.random()*5;
        objeto1.setNumero2(num1-num2);        
        System.out.println("Los números creados por el programa para realizar las operaciones matemáticas son: "+objeto1.getNumero1()+" y "+objeto1.getNumero2());
        
        OpMatematicasService os = new OpMatematicasService();
        os.devolverMayor(objeto1);
        System.out.println("El número mayor es: "+objeto1.getNumeroMayor());
        System.out.println("El número mayor elevado al número menor es: "+os.calcularPotencia(objeto1));
        System.out.println("La raiz cuadrada del número menor es: "+os.calcularRaiz(objeto1));
        
        
    }
    
}
