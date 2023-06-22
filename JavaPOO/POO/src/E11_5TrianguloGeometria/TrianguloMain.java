/*
Definir una clase triangulo que modelara triángulos isósceles . Definir los atributos necesarios para
operar. Crear los métodos correspondientes a la clase Entidad.
Crear un arreglo con 4 objetos de la clase
Crear los siguientes métodos:
● Calcular área
● Calcular perímetro
● Mostrar los datos del triangulo que tenga el área de mayor superficie
 */
package E11_5TrianguloGeometria;

import java.util.ArrayList;

/**
 *
 * @author AlejaDevelops
 */
public class TrianguloMain {


    public static void main(String[] args) {
        System.out.println("*** CALCULADORA DE TRIANGULO ***");
        int[] vectorTriangulos = new int[4];
        TrianguloService ts = new TrianguloService();     
                
        ArrayList<Triangulo> listaTriangulos = new ArrayList<>(); //ArrayList: permite almacenar una lista de datos similar a un array, pero sin necesidad de establecer dimensión inicial         
        for (int i = 0; i < 4; i++) {
            System.out.println("Ingresa los datos del triángulo "+(i+1));
            listaTriangulos.add(ts.crearTriangulo());
        }
        
        System.out.println("");
        System.out.println("Los datos de los triángulos ingresados son:");    
        for (Triangulo triangulo : listaTriangulos) {
            System.out.println("Triangulo con lados: "+triangulo.getLado1()+"/"+triangulo.getLado2()+"/"+triangulo.getLado3());
        }
        
        
        System.out.println("----------------------------------------------");
        for (int i = 0; i < 4; i++) {
            System.out.println("Triángulo "+(i+1));
            System.out.println("Perimetro: "+ts.calcularPerimetro(listaTriangulos.get(i)));
            System.out.println("Area: "+ts.calcularArea(listaTriangulos.get(i)));
            System.out.println(" ");
        }
        System.out.println("----------------------------------------------");
        ts.trianguloMayor(listaTriangulos);
        
    }
    
}
