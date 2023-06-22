/*
Definir la clase Fecha. La Clase entidad tendrá solo 3 atributos (día, mes, año). No se podrá utilizar
ningún tipo de objeto de “clase fechas”. Inicializando desde la entidad los valores en 1, 1, 1900
respectivamente.
Se deberá en métodos independientes:
● Verificar que el año ingresado por el usuario este entre 1900 y 2021, caso contrario, el año
tomara el valor por defecto.
● Crear un método para verificar si el año ingresado es bisiesto
● Conocer la cantidad de días totales que tiene el mes elegido por el usuario. EJ: USTED
INGRESO MES 10 (OCTUBRE), QUE TIENE 31 días



● Mostrar día anterior a la fecha ingresada (Hay que considerar que sucede con inicio de
cada mes)
● Mostrar día posterior a la fecha ingresada (Hay que considerar que sucede con fin de cada
mes)

 */
package E10_4Fecha;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class FechaService {
    Scanner leer = new Scanner(System.in);
    public Fecha crearFecha(){    
        Fecha fecha1 = new Fecha();
        
        System.out.println("Ingresa el año: ");
        int year = leer.nextInt();
        if (year>=1900 && year<=2021) {
            fecha1.setAnio(year);
        } else{
            System.out.println("Año inválido. "
                    + "\n Se tomará el año 1900 como año registrado");
        }
        System.out.println("Ingresa el mes de acuerdo al siguiente menú: "
                + "\n 1:Ene  2:Feb   3:Mar "
                + "\n 4:Abr  5:May   6:Jun "
                + "\n 7:Jul  8:Ago   9:Sep"
                + "\n 10:Oct 11:Nov  12:Dic");
        fecha1.setMes(leer.nextInt());
        System.out.println("Ingresa el día: ");
        fecha1.setDia(leer.nextInt());
        return fecha1;
    }
    
    public boolean verificarAnio(Fecha b){
        int remainder1 = b.getAnio()%4;
        int remainder2 = b.getAnio()%100;
        int remainder3 = b.getAnio()%400;
        boolean bisiesto = false;
        if ((remainder1 == 0 && remainder2 != 0) || remainder3 ==0){            
            bisiesto = true;
        }
        return bisiesto;    
    }
    
    public int diasDelMes(Fecha c){
        boolean b = verificarAnio(c);
        int dias = 0;
        switch(c.getMes()){
            case 4:
            case 6:
            case 9:
            case 11:
                dias = 30;                
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dias = 31;                
                break;
            case 2:
                if (b==true) {
                    dias = 29;                    
                } else {
                    dias = 28;                    
                }
        }
        return dias;
    }
    
    public void diaAnterior(Fecha d){
        
        if (d.getDia()==1) {
            if (d.getMes()==1) {
                System.out.println("El día anterior es: 31 de diciembre del año "+(d.getAnio()-1));
            } else{
                d.setMes(d.getMes()-1);//Seteo con el mes anterior para poder llamar al método "diasDelMes" para averiguar el último día del mes anterior               
                System.out.println("El día anterior es: "+diasDelMes(d)+" del mes "+d.getMes()+" del año "+d.getAnio());
                d.setMes(d.getMes()+1);//Se devuelve el mes a su valor original para usar correctamente el dato en otros métodos posteriores
            } 
        }else{          
            System.out.println("El día anterior es: "+(d.getDia()-1)+" del mes "+d.getMes()+" del año "+d.getAnio());                       
        }       
    }
    
    public void diaPosterior(Fecha e){
        
        if (e.getDia()==31) {
            if (e.getMes()==12) {
                System.out.println("El día posterior es: 01 de enero del año "+(e.getAnio()+1));                
            } else{
                System.out.println("El día posterior es: 01 del mes "+(e.getMes()+1)+" del año "+e.getAnio());
                
            } 
        } else{
            if (diasDelMes(e)== e.getDia()) {
                System.out.println("El día posterior es: 01 del mes "+(e.getMes()+1)+" del año "+e.getAnio());
                
            } else{
                System.out.println("El día posterior es: "+(e.getDia()+1)+" del mes "+e.getMes()+" del año "+e.getAnio());
            }
        }        
    }
}

//PENDIENTE VALIDAR CORRECCCION DE DIAS Y MES INGRESADOS