/*
Definir una Clase que contenga algún tipo de dato de tipo array y agregue el código para
generar y capturar una excepción ArrayIndexOutOfBoundsException (índice de arreglo fuera
de rango).
 */
package E2ArrayIndexOutOfBoundsException;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author AlejaDevelops
 */
public class EjercicioArrayIndexOutOfBoundsException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> listaPersonas = new ArrayList();
        listaPersonas.add("Pepe");
        listaPersonas.add("lola");
        listaPersonas.add("Juanito");
        ClaseConArray objeto = new ClaseConArray("Planilla grado 11°", 159, LocalDate.now(), listaPersonas);
        System.out.println("Estudiantes: ");
        System.out.println(objeto);

        try {
            for (int i = 0; i < 6; i++) {
                System.out.println(objeto.getListaPersonas().get(i));
            }

        } catch (ArrayIndexOutOfBoundsException e) { //No pude usar el ArrayIndexOutOfBoundsException
            System.out.println("Indice fuera del rango");
        }
        System.out.println("Sigue ejecutando el resto de código...");

        /* El problema que estás experimentando al intentar utilizar ArrayIndexOutOfBoundsException en el bloque catch es porque 
        ArrayIndexOutOfBoundsException no es una superclase directa de Exception, sino una subclase de IndexOutOfBoundsException.
        En Java, existe una jerarquía de excepciones, donde las excepciones más generales están en la parte superior y las excepciones 
        más específicas están en la parte inferior. La clase base para todas las excepciones en Java es Throwable. Throwable tiene dos 
        subclases principales: Exception y Error. A su vez, Exception tiene varias subclases, como RuntimeException y IndexOutOfBoundsException.
        En tu caso, cuando intentaste capturar ArrayIndexOutOfBoundsException, el compilador no pudo hacer coincidir directamente esa excepción 
        con la jerarquía de excepciones en el bloque catch. Sin embargo, como ArrayIndexOutOfBoundsException es una subclase de IndexOutOfBoundsException, 
        puedes capturarla utilizando IndexOutOfBoundsException en el bloque catch en su lugar.*/
    }

}
