/*
Ejercicios de aprendizaje varios desarrollados durante la lectura de la guia teórica
 */
package PrimerasPracticas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author AlejaDevelops
 */
public class PrimerasPracticasMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Deteccion de errores
        /*Array<int> listado = new ArrayList;
        TreeSet<String> = TreeSet();
        HashMap<Integer> personas = new HashMap<>;*/
        
        ArrayList<Integer> listado = new ArrayList();
        TreeSet<String> conjunto= new TreeSet();
        HashMap<Integer, String> personas = new HashMap();
        
        int x;             
        
        
        for (int i = 0; i < 5; i++) {
            x = i*10;
            listado.add(x);
            conjunto.add(x+"i");
            personas.put(x, "k");
        }
        
        System.out.println("Impresion de colecciones y mapa");
        System.out.println("ArrayList: "+listado);
        System.out.println("TreeSet: "+conjunto);
        System.out.println("HashMap"+personas);
        
        System.out.println("");
        System.out.println("Removiendo elementos...");
        listado.remove(3);
        //listado.remove(20); NOTA: ME REPORTA ERROR 
        conjunto.remove("30i");
        personas.remove(10);
        
        System.out.println("Impresion de colecciones y mapa luego de usar remove");
        System.out.println("ArrayList");
        for (Integer integer : listado) {
            System.out.println(integer);            
            
        }
        System.out.println(" ");
        System.out.println("Set");
        for (String string : conjunto) {
            System.out.println(string);
        }
        System.out.println(" ");
        System.out.println("Maps");
        for (Map.Entry<Integer, String> entry : personas.entrySet()) {
            System.out.println("Key: "+ entry.getKey()+" /Value: "+entry.getValue());                     
        }
        System.out.println("ArrayList: "+listado);
        System.out.println("HashSet: "+conjunto);
        System.out.println("HashMap: "+personas);
        
        /*Deteccion de errores
    HashMap<Integer> personas = new HashMap<>;
String n1 = “Albus”;
String n2 = “Severus”;
personas.add(n1);
personas.add(n2);*/
    
    
    HashMap<Integer, String> persona = new HashMap();
    String n1 = "Albus";
    String n2 = "Severus";
   
    persona.put(0,n1);
    persona.put(1,n2);
    
    /*Detecccion de errores:
    
    ArrayList<String> = new ArrayList()
bebidas.put(“café);
bebidas.add(“té”);
Iterator<String> it =bebidas.iterator();
whale (it.next()){
if (it.next().equals(“café”)){
it.remove();*/
    
        ArrayList<String> bebidas= new ArrayList();              
        bebidas.add("café");
        bebidas.add("té");
        Iterator<String> it = bebidas.iterator();
        
        while (it.hasNext()){
            if (it.next().equals("café")){
            it.remove();
            }
       }
        
        System.out.println(bebidas);
        System.out.println("-----------------------");
        ArrayList<String> libros = new ArrayList();
        libros.add("Mi lucha");
        libros.add("Cien años");
        libros.add("Mobie Dick");
        libros.add("Mujercitas");
        libros.add("Tommy");
        
        for (String aux : libros) {
            System.out.println("Titulos: "+aux);
        }
        
    
    
    
    }
    
    
    
    

    
    
}
