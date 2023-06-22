/*
Realizar una clase llamada Cuenta (bancaria) que debe tener como mínimo los atributos:
numeroCuenta (entero), el DNI del cliente (entero largo) y el saldo actual (entero).
Las operaciones asociadas a dicha clase son:
a) Constructor por defecto y constructor con DNI, saldo, número de cuenta e interés.ok
b) Agregar los métodos getters y setters correspondientes OK
c) Metodo para crear un objeto Cuenta, pidiéndole los datos al usuario. OK
d) Método ingresar(double ingreso): el método recibe una cantidad de dinero a ingresar
y se la sumara a saldo actual. ok
e) Método retirar(double retiro): el método recibe una cantidad de dinero a retirar y se
la restará al saldo actual. Si la cuenta no tiene la cantidad de dinero a retirar, se
pondrá el saldo actual en 0.
f) Método extraccionRapida(): le permitirá sacar solo un 20% de su saldo. Validar que el
usuario no saque más del 20%.
g) Método consultarSaldo(): permitirá consultar el saldo disponible en la cuenta.
h) Método consultarDatos(): permitirá mostrar todos los datos de la cuenta
 */
package E5CuentaBancaria;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class MainCuentaBancaria {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        
        CuentaBancariaService cs = new CuentaBancariaService();
        CuentaBancaria c1 = cs.crearCuenta();
        int opcion;
        
        
        do { 
            System.out.println("Cuál operación desea realizar?");
            System.out.println("1- Retirar dinero");
            System.out.println("2- Ingresar dinero");
            System.out.println("3- Retito rápido");
            System.out.println("4- Consultar saldo");
            System.out.println("5- Consultar datos");
            System.out.println("6- Salir");
            opcion = leer.nextInt();
            
            switch (opcion){
            case 1:
                cs.retirar(c1);
                break;
            case 2:
                cs.ingresar(c1);
                break;
            case 3:
                cs.extraccionRapida(c1);
                break;
            case 4:
                cs.consultarSaldo(c1);
                break;
            case 5:
                cs.consultarDatos(c1);
                break;
            case 6:
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Elección no válida");
        }
            
        } while (opcion!=6);
        
        
        
        
        
        
        
    }
    
}
