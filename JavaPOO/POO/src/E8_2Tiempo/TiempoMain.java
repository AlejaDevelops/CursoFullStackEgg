/*
Definir la clase Tiempo, la cual tendrá la hora, minutos y segundos. Definir dos constructores: un
constructor vacío y otro con la hora, minutos y segundos ingresado por el usuario. Deberá definir
además, los métodos getters y setters correspondientes, y el método imprimirHoraCompleta().
Recordar crear una validación sobre las horas, minutos y segundos ingresados por el usuario. Te
animas a simular el paso del tiempo en consola??????
 */
package E8_2Tiempo;


/**
 *
 * @author AlejaDevelops
 */
public class TiempoMain {
    public static void main(String[] args) {
        System.out.println("*** Registro del tiempo y compativo con la hora actual***");
        System.out.println("Ingresa una hora de inicio del día actual");
        TiempoService ts = new TiempoService();
        Tiempo tiempo1 = ts.tomarTiempo();
        
        System.out.println("La hora ingresada es: ");
        ts.imprimirHoraCompleta(tiempo1);
        System.out.println("");
        System.out.println("La hora actual es: ");
        Tiempo tiempo2 = ts.horaActual();
        ts.imprimirHoraCompleta(tiempo2);
        System.out.println("");
        Tiempo tiempo3 = ts.pasoDelTiempo(tiempo1, tiempo2);
        System.out.println("El tiempo transcurrido entre la hora ingresada y la hora actual es: "
                + "\n"+ tiempo3.getHora()+" horas"
                + "\n"+tiempo3.getMinutos()+" minutos"
                + "\n"+tiempo3.getSegundos()+" segundos");
        
        
        
        
    }
}
