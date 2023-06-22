/*
Crear una clase Pass, donde declaremos los siguientes atributos:
● pass : Del tipo String
● nombre: Del tipo String
● dni: Del tipo int.
Métodos para desarrollar:
● Ingresar datos de usuarios (usando el constructor. HACER INGRESO DE DATOS FIJOS (no por
teclado)
● Crear un método para ingresar una contraseña (crearPass). En este método, debemos
validar que la longitud sea correcta. (10). En caso de ser correcto, almaceno la contraseña.
Si ingreso a esta opción del menú, indefectiblemente deberá dejar su contraseña asignada.
● Crear un método para analizar la contraseña(analizarPass). Donde:
o SI Existe al menos una letra z : Es nivel MEDIO
o Si Existe al menos una letra z y al menos 2 letras a: Es nivel ALTO
o Si ninguna condición se cumple es nivel BAJO
● Crear los métodos correspondientes para modificar el nombre o DNI. Atención! Primero
debe ingresar el pass para poder realizar dicha gestión. Caso contrario se impedirá el
acceso a modificar los datos.
● A través de un menú de opciones:
o A) ingresar la contraseña, recordar que antes de guardarla debe ser ingresada una
contraseña valida).
o B) Mensaje al usuario que tipo de NIVEL es su contraseña
o C) Modificar contraseña, donde primero debe poner su contraseña anterior para
dar permiso
o C) Modificar nombre, donde primero debe poner su contraseña para dar permiso,
SINO impedir cambios
o D) Modificar DNI, donde primero debe poner su contraseña para dar permiso,
SINO impedir cambios
 */
package E9_3Password;

import java.util.Scanner;

/**
 *
 * @author Computador 1
 */
public class PassService {
       Scanner leer = new Scanner(System.in);
    public Pass ingresoDatos(){
        
        Pass datos = new Pass(); 
        System.out.println("Cargando nombre, cédula y DNI");
        System.out.println("...");
        datos.setNombre("Maria Sierra Gomez");
        datos.setDni(123456789);        
        System.out.println("Datos cargados...");        
        
        return datos;
    }
    
    public Pass crearPass(Pass a){        
        String pass;
        boolean band = false;
        
        do {
           System.out.println("Ingresa tu contraseña");
           pass = leer.next();
           if (pass.length() == 10) {                           
                a.setPass(pass);
                band = true;
                System.out.println("Contraseña registrada exitosamente");
        } else{
            System.out.println("Contraseña no válida. Intenta nuevamente");
        } 
        } while (band == false);      

        return a;
    }
    
    public void analizarPass(Pass b){
        int contA=0;
        int contZ=0;
        for (int i = 0; i < b.getPass().length(); i++) {
            if ("a".equalsIgnoreCase(b.getPass().substring(i, i+1))) {
               contA++;                 
            }
            if ("z".equalsIgnoreCase(b.getPass().substring(i, i+1))) {
               contZ++;     
            }        
        }
        
        if (contA>1 && contZ>0) {
            System.out.println("Nivel de seguridad ALTO");
        }
        if (contA==0 && contZ>0) {
            System.out.println("Nivel de seguridad MEDIO");
        }
        if (contA==0 && contZ==0) {
            System.out.println("Nivel de seguridad BAJO");
        }
    } //Se deben agregar otras opciones de validación
    
    public void modificadorPass(Pass c){
        String password;
        boolean bandera = false;
        do {            
           System.out.println("Ingresa tu contraseña actual");
           password = leer.next();
           
            if (password.equals(c.getPass())) {
                System.out.println("Ingresa la nueva contraseña: ");
                c.setPass(leer.next());                
                System.out.println("La contraseña sido modificada con éxito");
                bandera = true;
            } else {
                System.out.println("Contraseña inválida. Intenta nuevamente");
            }         
        } while (bandera==false);   
    }
    
    public void modificadorNombre(Pass c){
        String password;
        boolean bandera = false;
        do {            
           System.out.println("Ingresa tu contraseña actual");
           password = leer.next();
           
            if (password.equals(c.getPass())) {
                System.out.println("Ingresa el nuevo nombre: ");
                c.setNombre(leer.next());                
                System.out.println("El nombre ha sido modificado con éxito");
                bandera = true;
            } else {
                System.out.println("Contraseña inválida. Intenta nuevamente");
            }         
        } while (bandera==false);  
    }
    
    public void modificadorDNI(Pass c){
        String password;
        boolean bandera = false;
        do {            
           System.out.println("Ingresa tu contraseña actual");
           password = leer.next();
           
            if (password.equals(c.getPass())) {
                System.out.println("Ingresa el nuevo DNI: ");
                c.setDni(leer.nextLong());
                System.out.println("El DNI ha sido modificado con éxito");
                bandera = true;
            } else {
                System.out.println("Contraseña inválida. Intenta nuevamente");
            }         
        } while (bandera==false);   
    }
    
    public void menu(Pass d){
        char opcion = 'a';
        do {            
            System.out.println("Elige una opción del siguiente menú: "
                + "\n A - Ingresar contraseña "
                + "\n B - Ver nivel de seguridad de la contraseña "
                + "\n C - Modificar contraseña "
                + "\n D - Modificar nombre "
                + "\n E - Modificar DNI "
                + "\n S - Salir");     
            opcion = leer.next().charAt(0);
            
            switch(opcion){
                case 'A':
                    crearPass(d);
                    System.out.println("-------------------------");
                    break;
                case 'B':
                    analizarPass(d);
                    System.out.println("-------------------------");
                    break;
                case 'C':
                    modificadorPass(d);
                    System.out.println("-------------------------");
                    break;
                case 'D':
                    modificadorNombre(d);
                    System.out.println("-------------------------");
                    break;
                case 'E':
                    modificadorDNI(d);
                    System.out.println("-------------------------");
                    break;
                case 'S':
                    System.out.println("BYE!");
                    break;
                default:
                    System.out.println("Elección no válida, intenta nuevamente");
                    System.out.println("-------------------------");
            }            
        } while (!"S".equalsIgnoreCase(String.valueOf(opcion)));     
 
    }
    
}
    
