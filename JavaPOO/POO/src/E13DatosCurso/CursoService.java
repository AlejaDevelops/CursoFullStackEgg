/*
Un profesor particular está dando cursos para grupos de cinco alumnos y necesita un
programa para organizar la información de cada curso. Para ello, crearemos una clase
entidad llamada Curso, cuyos atributos serán: nombreCurso, cantidadHorasPorDia,
cantidadDiasPorSemana, turno (mañana o tarde), precioPorHora y alumnos. Donde
alumnos es un arreglo de tipo String de dimensión 5 (cinco), donde se alojarán los
nombres de cada alumno. A continuación, se implementarán los siguientes métodos:
 Un constructor por defecto.
 Un constructor con todos los atributos como parámetro.
 Métodos getters y setters de cada atributo.
 método cargarAlumnos(): este método le permitirá al usuario ingresar los alumnos
que asisten a las clases. Nosotros nos encargaremos de almacenar esta información
en un arreglo e iterar con un bucle, solicitando en cada repetición que se ingrese el
nombre de cada alumno.
 Método crearCurso(): el método crear curso, le pide los valores de los atributos al
usuario y después se le asignan a sus respectivos atributos para llenar el objeto
Curso. En este método invocaremos al método cargarAlumnos() para asignarle valor
al atributo alumnos


 Método calcularGananciaSemanal(): este método se encarga de calcular la ganancia
en una semana por curso. Para ello, se deben multiplicar la cantidad de horas por
día, el precio por hora, la cantidad de alumnos y la cantidad de días a la semana que
se repite el encuentro.
 */
package E13DatosCurso;

import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class CursoService {
    Scanner leer = new Scanner(System.in);
    
    public String[] cargarAlumnos(Curso b){               
        String vectorAux[] = new String [5];  
       
        for (int i = 0; i < vectorAux.length; i++) {
            System.out.println("Ingresa el nombre del alumno "+(i+1));                      
            vectorAux[i]=leer.next();       
        }
        System.out.println("Has terminado de cargar todos los alunmos");
        b.setVectorAlumnos(vectorAux);        
        return b.getVectorAlumnos();
    }
    
    public Curso crearCurso(){
        Curso cursoLleno = new Curso();
        System.out.println("Bienvenido!!!");
        System.out.println("A continuación podrás crear un curso");
        System.out.println(" ");
        System.out.println("¿Cuál es el nombre del curso?");
        cursoLleno.setNombreCurso(leer.nextLine());   
        System.out.println("¿Cuál es la duración en horas diarias?");
        cursoLleno.setCantidadHorasPorDia(leer.nextInt());
        System.out.println("¿Cuántas veces a la semana dictas este curso (cantidad de días)?");
        cursoLleno.setCantidadDiasPorSemana(leer.nextInt());
        String turno;
        do {            
            System.out.println("¿En qué jornada dicta el curso?");
            System.out.println("M - Mañana");
            System.out.println("T - Tarde");
            turno = leer.next().toUpperCase();

            if ("M".equals(turno) || "T".equals(turno) ) {
                cursoLleno.setTurno(turno);
            } else {
                System.out.println("Elección no válida, intenta nuevamente");
                System.out.println(" ");
            }    
        } while (!turno.equals("M") && !turno.equals("T"));    
          
        System.out.println("¿Cuál es el precio por hora?");
        cursoLleno.setPrecioPorHora(leer.nextInt());
        cargarAlumnos(cursoLleno); 
        System.out.println("Curso lleno correctamente");
        return cursoLleno;
 
    }
    
    public void calcularGananciaSemanal(Curso a){
        System.out.println("A continuación se calculará la ganancia semanal del curso ingresado...");
        System.out.println("...");
        
        int gananciaSem = a.getPrecioPorHora()*a.getCantidadHorasPorDia()*a.getCantidadDiasPorSemana()*a.getVectorAlumnos().length; 
        System.out.println("La ganancia semanal del curso "+a.getNombreCurso()+" es $" +gananciaSem);
        //System.out.println("La cantidad de alumnos es "+a.getVectorAlumnos().length); ERROR 
    }
}
