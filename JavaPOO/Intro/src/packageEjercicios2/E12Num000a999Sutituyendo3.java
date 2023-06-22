/*
 Necesitamos mostrar un contador con 3 dígitos (X-X-X), que muestre los números del 0-0-0 al 9-9-9, 
con la particularidad que cada vez que aparezca un 3 lo sustituya por una E.
Ejemplo:
0-0-0
0-0-1
0-0-2
0-0-E
0-0-4
0-1-2
0-1-E

 */
package packageEjercicios;

/**
 * @author AlejaDevelops
 * @author dh19ob87
 */
public class E12Num000a999Sutituyendo3 {

    public static void main(String[] args) {
        System.out.println("*** IMPRESORA NUMEROS 0-0-0 hasta 9-9-9 ***");
        System.out.println(" ------ Con sustitución del numero 3 ------");
        
        for (int i = 0; i < 1000; i++) {
            System.out.printf("%n%s-%s-%s ", (i/100 ==3) ? "E" : i/100, (((i/10)%10) ==3) ? "E" : ((i/10)%10), ((i%10)==3) ? "E" : i%10);
        }
        System.out.println("");
        
        
        
        //Solución 2
        /*for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (i == 3 && j!=3 && k!=3) {
                        System.out.println("E-" + j + "-" + k);
                    }
                    if (j == 3 && i!=3 && k!=3) {
                        System.out.println(i + "-E-" + k);
                    }
                    if (k == 3 && i!=3 && j!=3) {
                        System.out.println(i + "-" + j + "-E");
                    }
                    if (i == 3 && j == 3 && k!=3) {
                        System.out.println("E-E-" + k);
                    }
                    if (i == 3 && k == 3 && j!=3) {
                        System.out.println("E-" + j + "-E");
                    }
                    if (j == 3 && k == 3 && i!=3) {
                        System.out.println(i + "-E-E");
                    }
                    if (i == 3 && j == 3 && k == 3) {
                        System.out.println("E-E-E");
                    }
                    
                    if (i!=3 && j!=3 && k!=3) {
                        System.out.println(i + "-" + j + "-" + k);
                    }
                }
            }
        }*/

    }
}
