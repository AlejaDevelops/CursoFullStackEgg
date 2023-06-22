
package E5CuentaBancaria;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class CuentaBancariaService {
    Scanner leer = new Scanner(System.in);
    
    public CuentaBancaria crearCuenta(){
                
        CuentaBancaria c1 = new CuentaBancaria();
        System.out.println("Ingresar el número de cuenta bancaria");
        c1.setCuentaBancaria(leer.nextInt());
        System.out.println("Ingresar el DNI asociado");
        c1.setDni(leer.nextLong());
        System.out.println("¿Con qué monto abrirás tu cuenta?");
        c1.setSaldoCuenta(leer.nextDouble());
        
        return c1;
       
    }
    
    public void ingresar(CuentaBancaria d){
               
        System.out.println("¿Qué monto va a depositar en la cuenta?");
        double ingreso = leer.nextDouble();
        d.setSaldoCuenta(d.getSaldoCuenta()+ingreso);        
              
    }
    
    public void retirar(CuentaBancaria e){
               
        System.out.println("¿Qué monto va a retirar de la cuenta?");
        double retiro = leer.nextDouble();        
        e.setSaldoCuenta(e.getSaldoCuenta()-retiro);        
        
        if (e.getSaldoCuenta()<0) {
            e.setSaldoCuenta(0);
        }      
        
    }
    
    public void extraccionRapida(CuentaBancaria f){
        System.out.println("¿Qué monto va a retirar de la cuenta?");
        double retiro = leer.nextDouble();
        
        if ((f.getSaldoCuenta()*0.2)<retiro) {
            System.out.println("Monto a retirar no permitido");
        } else{
            f.setSaldoCuenta(f.getSaldoCuenta()-retiro);            
        }     
  
    }
    
    public void consultarSaldo(CuentaBancaria g){
        System.out.println("El saldo actual de su cuenta es: "+g.getSaldoCuenta() );
    }
    
    public void consultarDatos(CuentaBancaria h){
        System.out.println("DATOS DE LA CUENTA");
        System.out.println("DNI del titular: " + h.getDni());
        System.out.println("Numero de cuenta: " + h.getCuentaBancaria());
    }
}
