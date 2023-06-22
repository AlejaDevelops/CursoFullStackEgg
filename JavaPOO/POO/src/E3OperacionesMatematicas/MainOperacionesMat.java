/*
Crear una clase llamada Operacion que tenga como atributos privados numero1 y
numero2. A continuación, se deben crear los siguientes métodos:
a) Método constructor con todos los atributos pasados por parámetro. OK
b) Metodo constructor sin los atributos pasados por parámetro. OK
c) Métodos get y set. OK
d) Método para crearOperacion(): que le pide al usuario los dos números y los guarda
en los atributos del objeto. OK
e) Método sumar(): calcular la suma de los números y devolver el resultado al main. OK
f) Método restar(): calcular la resta de los números y devolver el resultado al main OK
g) Método multiplicar(): primero valida que no se haga una multiplicación por cero, si
fuera a multiplicar por cero, el método devuelve 0 y se le informa al usuario el error.
Si no, se hace la multiplicación y se devuelve el resultado al main
h) Método dividir(): primero valida que no se haga una división por cero, si fuera a pasar
una división por cero, el método devuelve 0 y se le informa al usuario el error se le
informa al usuario. Si no, se hace la división y se devuelve el resultado al main.
 */
package E3OperacionesMatematicas;

/**
 *
 * @author AlejaDevelops
 */
public class MainOperacionesMat {

    public static void main(String[] args) {
        
        OperacionesMatServicio os = new OperacionesMatServicio();
        OperacionesMat op1 = os.crearOperacion();
        
        System.out.println("La suma de los números ingresados es: " +os.suma(op1));
        System.out.println("La resta de los números ingresados es: " +os.resta(op1));
        
        if (os.multiplicacion(op1)!=0) {
            System.out.println("La multiplicación de los número ingresados es: "+os.multiplicacion(op1));        
        }
        
        if (os.division(op1)!=0) {
            System.out.println("La división del primer número entre el segundo es: "+ os.division(op1));
        }  
    
    }
    
}
