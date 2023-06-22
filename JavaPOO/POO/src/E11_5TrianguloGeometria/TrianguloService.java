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
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class TrianguloService {
    Scanner input = new Scanner(System.in);    
    
    public Triangulo crearTriangulo(){
        Triangulo triangulo1 = new Triangulo();
        System.out.println("Ingresa el tamaño en centímetros uno de los dos iguales:");
        triangulo1.setLado1(input.nextDouble());
        triangulo1.setLado2(triangulo1.getLado1());
        System.out.println("Ingresa el tamaño en centímetros el lado diferente:");
        triangulo1.setLado3(input.nextDouble());
        
        return triangulo1; 
    }
    
     public double calcularArea(Triangulo a){
         double h = (double)(Math.sqrt((Math.pow(a.getLado1(),2))-((Math.pow(a.getLado3(),2)/4))));         
         double area = (h*a.getLado3())/2;
         return area;
     }
     
     public double calcularPerimetro(Triangulo b){
         double p = 2*b.getLado1()+b.getLado3();
         return p;
     }
     
     public void trianguloMayor(ArrayList<Triangulo> listaTriangulos){
         double areaMayor = 0;
         double area;
         int posicionMayor=0;
         for (int i = 0; i < 4; i++) {
             area = calcularArea(listaTriangulos.get(i));
             if (areaMayor == 0) {
                 areaMayor = area;
                 posicionMayor = i;
             }else{                 
                 if (area>areaMayor) {
                     areaMayor = area;
                     posicionMayor = i;
                 }
             }          
 
         }
         System.out.println("El triángulo que tiene el área mayor es el triángulo "+(posicionMayor+1)+" y sus datos son: "
                 +"\n Lado 1: "+listaTriangulos.get(posicionMayor).getLado1()
                 +"\n Lado 2: "+ listaTriangulos.get(posicionMayor).getLado2()
                 +"\n Lado 3: "+listaTriangulos.get(posicionMayor).getLado3());
        
     }
}
