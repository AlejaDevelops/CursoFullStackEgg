/*
Definir la clase Fecha. La Clase entidad tendrá solo 3 atributos (día, mes, año). No se podrá utilizar
ningún tipo de objeto de “clase fechas”. Inicializando desde la entidad los valores en 1, 1, 1900
respectivamente.
Se deberá en métodos independientes:
● Verificar que el año ingresado por el usuario este entre 1900 y 2021, caso contrario, el año
tomara el valor por defecto.
● Conocer la cantidad de días totales que tiene el mes elegido por el usuario. EJ: USTED
INGRESO MES 10 (OCTUBRE), QUE TIENE 31 días
● Mostrar día anterior a la fecha ingresada (Hay que considerar que sucede con inicio de
cada mes)
● Mostrar día posterior a la fecha ingresada (Hay que considerar que sucede con fin de cada
mes)
● Crear un método para verificar si el año ingresado es bisiesto
 */
package E10_4Fecha;



/**
 *
 * @author AlejaDevelops
 */
public class FechaMain {
    public static void main(String[] args) {
        
        
        FechaService fs = new FechaService();
        Fecha fecha1 = fs.crearFecha();
        
        boolean bisiesto = fs.verificarAnio(fecha1);
        if (bisiesto) {
            System.out.println("El año "+fecha1.getAnio()+" si es bisiesto");
        }else{
            System.out.println("El año "+fecha1.getAnio()+" no es bisiesto");
        }           
        
        System.out.println("El mes ingresado tiene "+fs.diasDelMes(fecha1)+" dias");        
        fs.diaAnterior(fecha1);
        fs.diaPosterior(fecha1);
    }
    
        
 
}
