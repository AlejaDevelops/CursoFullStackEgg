/*
Realizar una clase llamada Cadena que tenga como atributos una frase (de tipo de
String) y su longitud. En el main se creará el objeto y se le pedirá al usuario que ingrese
una frase que puede ser una palabra o varias palabras separadas por un espacio en
blanco y a través de los métodos set, se guardará la frase y la longitud de manera
automática según la longitud de la frase ingresada. Deberá además implementar los
siguientes métodos:
a) Método mostrarVocales(), deberá contabilizar la cantidad de vocales que tiene la
frase ingresada. ---- OK ---
b) Método invertirFrase(), deberá invertir la frase ingresada y mostrarla por pantalla. Por
ejemplo: Entrada: "casa blanca", Salida: "acnalb asac". ---- OK ---
c) Método vecesRepetido(String letra), recibirá un carácter ingresado por el usuario y
contabilizar cuántas veces se repite el carácter en la frase, por ejemplo:  ---- OK ---
 Entrada: frase = "casa blanca". Salida: El carácter 'a' se repite 4 veces.
e) Método compararLongitud(String frase), deberá comparar la longitud de la frase que
compone la clase con otra nueva frase ingresada por el usuario. ---- OK ---
f) Método unirFrases(String frase), deberá unir la frase contenida en la clase Cadena
con una nueva frase ingresada por el usuario y mostrar la frase resultante. ---- OK ---
g) Método reemplazar(String letra), deberá reemplazar todas las letras “a” que se
encuentren en la frase, por algún otro carácter seleccionado por el usuario y mostrar
la frase resultante. ---- OK ---
h) Método contiene(String letra), deberá comprobar si la frase contiene una letra que
ingresa el usuario y devuelve verdadero si la contiene y falso si no. ---- OK ---

 */
package E8GuardarFrase;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class FraseService {

    Scanner leer = new Scanner(System.in);

    public Frase crearFrase() {
        Frase f1 = new Frase();
        System.out.println("Ingresa una frase");
        f1.setFrase(leer.nextLine());
        f1.setLongitudFrase(f1.getFrase().length());

        return f1;
    }

    public void contarVocal(Frase a) {
        int cont = 0;
        for (int i = 0; i < a.getLongitudFrase(); i++) {
            if ("a".equalsIgnoreCase(a.getFrase().substring(i, i + 1)) || ("e".equalsIgnoreCase(a.getFrase().substring(i, i + 1))) || ("i".equalsIgnoreCase(a.getFrase().substring(i, i + 1))) || ("o".equalsIgnoreCase(a.getFrase().substring(i, i + 1))) || ("u".equalsIgnoreCase(a.getFrase().substring(i, i + 1)))) {
                cont +=1;       
            }
        }
        System.out.println("La cantidad de vocales encontradas es " + cont);
    }
    
    public void invertirFrase(Frase b){
        String fraseInvertida = "";
        for (int i = b.getLongitudFrase()-1; i >=0 ; i--) {
            fraseInvertida+=b.getFrase().substring(i, i+1);
        }
        
        System.out.println("La frase invertida es "+fraseInvertida);
    }
    
    public void vecesRepetido(Frase c){
        System.out.println("Ingresa una letra");
        String letra = leer.next();
        int cont =0;
        
        for (int i = 0; i < c.getLongitudFrase(); i++) {
            if (letra.equalsIgnoreCase(c.getFrase().substring(i, i+1))) {
            cont+=1;                
            }           
        }
        System.out.println("La letra ingresada se repite "+cont+" veces");
    }
    
    public void compararFrase(Frase d){
        System.out.println("Has elegido la opción comparar frase");
        System.out.println("Ingresa una nueva frase");
        String fraseNueva = leer.next(); //NOTA: No está admitiendo más de 12 caracteres. ¿Por qué?
        
        if (fraseNueva.length()>d.getLongitudFrase()) { 
            System.out.println("La longitud de la frase nueva es mayor que "+d.getFrase());            
        } else{
            if (fraseNueva.length()<d.getLongitudFrase()) {
                System.out.println("La longitud de la frase nueva es menor que "+d.getFrase());
            } else {
                System.out.println("La longitud de la frase nueva es igual que "+d.getFrase());
            }
        }
        
        
    }
    
    public void unirFrases(Frase e){
        System.out.println("Has elegido la opción unir frases");
        System.out.println("Ingresa una nueva frase");
        String fraseNueva = leer.nextLine();
        
        System.out.println(" ");
        System.out.println("La nueva frase es: " +e.getFrase()+" "+fraseNueva);
        
    }
    
    public void reemplazar(Frase f){
        System.out.println("Has elegido la opción reemplazar la letra A");
        System.out.println("Ingresa el nuevo caracter por el cual deseas reemplazar la A");
        char letra = leer.next().charAt(0);
                
        f.setFrase(f.getFrase().toLowerCase().replace("a", Character.toString(letra)));
        
        System.out.println("La nueva frase es: " +f.getFrase());      
  
    }
    
    public void contiene(Frase g){
        System.out.println("Has elegido la opción buscar letra");
        System.out.println("Ingresa la letra que deseas buscar en la frase");
        String letra = leer.nextLine();
        boolean respuesta=false;
        
        for (int i = 0; i < g.getLongitudFrase(); i++) {
            if (letra.equalsIgnoreCase(g.getFrase().substring(i, i+1))) {
                respuesta=true;          
            }               
        }
        System.out.println("La letra se encontró en la frase? "+respuesta);
    }
    

}
