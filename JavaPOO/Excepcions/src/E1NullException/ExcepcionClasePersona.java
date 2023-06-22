/*
Inicializar un objeto de la clase Persona ejercicio 3 de la guía 8 Servicios, a null y tratar
de invocar el método esMayorDeEdad() a través de ese objeto. Luego, englobe el código
con una cláusula try-catch para probar la nueva excepción que debe ser controlada.
 */
package E1NullException;

/**
 *
 * @author AlejaDevelops
 */
public class ExcepcionClasePersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // E7Persona Guia: POOEjerciciosAprendizaje
        Persona persona = null;
        System.out.println(persona);
        PersonaService ps = new PersonaService();

        try {
            boolean esMayor = ps.esMayorDeEdad(persona);
            System.out.println(esMayor);
        } catch (NullPointerException e) {
            System.out.println("ERROR: "+e);
        }

    }

}
