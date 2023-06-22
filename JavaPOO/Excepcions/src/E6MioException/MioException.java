/*
Dado el método metodoA de la clase A, indique:
a) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción MioException?
b) ¿Qué sentencias y en qué orden se ejecutan si no se produce la excepción MioException?
class A {
public void metodoA() {
sentencia_a1
sentencia_a2
try {
sentencia_a3
sentencia_a4
} catch (MioException e){
sentencia_a6
}
sentencia_a5
}
}
 */

package E6MioException;

/**
 *
 * @author AlejaDevelops
 */
public class MioException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* 
        
        Si se produce la excepción MioException se ejecutarán las siguientes sentencias: 
        1. sentencia_a1
        2. sentencia_a2
        3. sentencia_a6
        4. sentencia_a5
        
        si no se produce la excepción MioException se ejecutarán las siguientes sentencias:
        1. sentencia_a1
        2. sentencia_a2
        3. sentencia_a3
        4. sentencia_a4
        5. sentencia_a5
        
        */
    }

}
