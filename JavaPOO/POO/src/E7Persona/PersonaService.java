/*
Realizar una clase llamada Persona que tenga los siguientes atributos: nombre, edad,
sexo ('H' hombre, 'M' mujer, 'O' otro), peso y altura. Si el alumno desea añadir algún otro
atributo, puede hacerlo. Los métodos que se implementarán son:
 Un constructor por defecto. 
 Un constructor con todos los atributos como parámetro.
 Métodos getters y setters de cada atributo.
 Metodo crearPersona(): el método crear persona, le pide los valores de los atributos
al usuario y después se le asignan a sus respectivos atributos para llenar el objeto
Persona. Además, comprueba que el sexo introducido sea correcto, es decir, H, M o
O. Si no es correcto se deberá mostrar un mensaje
 Método calcularIMC(): calculara si la persona está en su peso ideal (peso en
kg/(altura^2 en mt2)). Si esta fórmula da por resultado un valor menor que 20,
significa que la persona está por debajo de su peso ideal y la función devuelve un -1.
Si la fórmula da por resultado un número entre 20 y 25 (incluidos), significa que la
persona está en su peso ideal y la función devuelve un 0. Finalmente, si el resultado
de la fórmula es un valor mayor que 25 significa que la persona tiene sobrepeso, y la
función devuelve un 1.
 Método esMayorDeEdad(): indica si la persona es mayor de edad. La función
devuelve un booleano.
A continuación, en la clase main hacer lo siguiente:
Crear 4 objetos de tipo Persona con distintos valores, a continuación, llamaremos todos
los métodos para cada objeto, deberá comprobar si la persona está en su peso ideal,
tiene sobrepeso o está por debajo de su peso ideal e indicar para cada objeto si la
persona es mayor de edad.


Por último, guardaremos los resultados de los métodos calcularIMC y esMayorDeEdad en
distintas variables, para después en el main, calcular un porcentaje de esas 4 personas
cuantas están por debajo de su peso, cuantas en su peso ideal y cuantos, por encima, y
también calcularemos un porcentaje de cuantos son mayores de edad y cuantos menores
 */
package E7Persona;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class PersonaService {

    public Persona crearPersona() {
        Scanner leer = new Scanner(System.in);
        Persona pc = new Persona();
        boolean bandera = true;

        System.out.println("Ingresa el nombre de la persona");
        pc.setNombre(leer.nextLine());
        System.out.println("Ingresa su edad");
        pc.setEdad(leer.nextInt());

        //Validación elección Sexo
        do {
            System.out.println("Ingresa el sexo");
            System.out.println("M - Mujer");
            System.out.println("H - hombre");
            System.out.println("O - Otro");
            pc.setSexo(leer.next().charAt(0));

            if ("M".equalsIgnoreCase(Character.toString(pc.getSexo())) || "H".equalsIgnoreCase(Character.toString(pc.getSexo())) || "O".equalsIgnoreCase(Character.toString(pc.getSexo()))) {
                bandera = false;
            } else {
                System.out.println("Elección no válida, intenta nuevamente");
            }
        } while (bandera);

        System.out.println("Ingresa su estatura en metros");
        pc.setEstatura(leer.nextDouble());
        System.out.println("Ingresa su peso en kg");
        pc.setPeso(leer.nextDouble());

        return pc;
    }

    public int calcularIMC(Persona a) {
        int salida;

        a.setImc(a.getPeso() / Math.pow(a.getEstatura(), 2));

        if (a.getImc() < 20) {
            //Persona debajo de su peso ideal
            salida = -1;
        } else if (a.getImc() >= 20 && a.getImc() <= 25) {
                //la persona está en su peso ideal
                salida = 0;
        } else {
                //La persona tiene sobrepeso
                salida = 1;
        }           
        
        return salida;
    }
    
    public boolean esMayorDeEdad(Persona b){
        boolean salida =false;
        
        if (b.getEdad()>=18) {
            //le persona es mayor de edad
            salida = true;
        }
        
        return salida;
    }
}
