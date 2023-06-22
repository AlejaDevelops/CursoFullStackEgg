
package E7Persona;

/**
 *
 * @author AlejaDevelops
 */
public class MainPersona {

    public static void main(String[] args) {
        
        PersonaService ps = new PersonaService();
        Persona[] p = new Persona[4];        
               
        for (int i = 0; i < p.length; i++) {                        
            p[i] = ps.crearPersona();//En cada posición i de p se crea una persona completa (un objeto)  
        }
        
        int contMayorEdad = 0;
        int contMenorEdad = 0;
        int contBajoPeso = 0;
        int contNormalPeso =0;
        int contSobrePeso =0;
        
        for (int i = 0; i < p.length; i++) {   

            if (ps.esMayorDeEdad(p[i])==true) {
                System.out.println(p[i].getNombre()+" es mayor de edad");
                contMayorEdad+=1;
            } else {
                System.out.println(p[i].getNombre()+" es menor de edad");
                contMenorEdad+=1;
            }
            
            
            switch (ps.calcularIMC(p[i])) {
                case -1:
                    System.out.println("Y se encuentra debajo de su peso ideal");
                    contBajoPeso+=1;
                    break;
                case 0:
                    System.out.println("Y se encuentra en su peso ideal");
                    contNormalPeso+=1;
                    break;
                case 1:
                    System.out.println("Y se encuentra en sobrepeso");
                    contSobrePeso+=1;
                    break;
                default:
                    break;
            }
        }
        
        System.out.println(" ");
        System.out.println("La cantidad de personas que encuentran debajo de su peso ideal es: "+contBajoPeso);
        System.out.println("La cantidad de personas que encuentran en su peso ideal es: "+contNormalPeso);
        System.out.println("La cantidad de personas que encuentran por encima de su peso ideal es: "+contSobrePeso);
        System.out.println("El porcentaje de persona menores de edad es "+contMenorEdad*100/p.length+"%"); 
        System.out.println("El porcentaje de persona mayores de edad es "+contMayorEdad*100/p.length+"%"); 
    }
    
}
