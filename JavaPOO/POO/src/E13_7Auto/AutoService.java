/*
Crea una clase Auto. Como atributos tendrá nombre del dueño, fecha vencimiento carnet, color del
vehículo, modelo y KM en motor (deberá ser inicializado por defecto en 7500km),
Crear métodos que permitan:
● Que un usuario cargue su ficha del auto.
● Que el usuario, modifique la titularidad del vehículo.
● Indicar un trayecto recorrido, modificando de este modo los KM del motor
● Crear un método que indique si es necesario realizar Service al vehículo, considerando que
al llegar a los 10.000km corresponde realizarlo.
 */
package E13_7Auto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class AutoService {
    Scanner leer = new Scanner(System.in);
    public Auto crearFicha(){
        Auto ficha1 = new Auto();
        System.out.println("Ingresa el nombre del propietario");
        ficha1.setNombre(leer.nextLine());
        System.out.println("Fecha de vencimiento de la licencia dd/mm/aaaa: ");
        int dia = leer.nextInt();
        int mes = leer.nextInt();
        int anio = leer.nextInt();
        Date fechaV = new Date(anio-1900, mes-1, dia);
        ficha1.setFechaVencLicencia(fechaV);
        System.out.println("Color del auto");
        ficha1.setColor(leer.next());
        System.out.println("Modelo del auto");
        ficha1.setModelo(leer.nextInt());
        System.out.println("Kilometraje del vehiculo");
        ficha1.setKm(leer.nextInt());
        return ficha1;
    }
    
    public void modificarTitular(Auto a){
        System.out.println("Ingrea el nombre del nuevo propietario");
        a.setNombre(leer.next());
        System.out.println("Fecha de vencimiento de la licencia dd/mm/aaaa: ");
        int dia = leer.nextInt();
        int mes = leer.nextInt();
        int anio = leer.nextInt();
        Date fechaV = new Date(anio-1900, mes-1, dia);
        a.setFechaVencLicencia(fechaV);
    }
    
    public void recorrido(Auto b){
        System.out.println("Trayecto nuevo");
        System.out.println("Ingresa los km recorridos:");
        int kmTrayecto = leer.nextInt();
        b.setKm(kmTrayecto+b.getKm());
        
    }
    
    public void alertaServicio(Auto c){
        if (c.getKm()>=10000) {
            System.out.println("El auto necesita mantenimiento");            
        } else{
            System.out.println("El auto aún no necesita mantenimiento");
        }          
    }
    
    public void imprimirFicha (Auto d){
        SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formateadorFecha.format(d.getFechaVencLicencia());
        System.out.println("Datos del vehículo: "
                +"\n Propietario: "+d.getNombre()
                +"\n Fecha de vencimiento licencia: "+fechaFormateada
                +"\n Color: " +d.getColor()
                +"\n Modelo: "+d.getModelo()
                +"\n Kilometraje: "+d.getKm());
                
    }
            
}
