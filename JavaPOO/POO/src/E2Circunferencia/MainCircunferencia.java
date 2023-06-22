/*
Declarar una clase llamada Circunferencia que tenga como atributo privado el radio de
tipo real. A continuación, se deben crear los siguientes métodos:
a) Método constructor que inicialice el radio pasado como parámetro. OK
b) Métodos get y set para el atributo radio de la clase Circunferencia. OK
c) Método para crearCircunferencia(): que le pide el radio y lo guarda en el atributo del
objeto. OK
d) Método area(): para calcular el área de la circunferencia (𝐀𝐫𝐞𝐚 = 𝛑 ∗ 𝐫𝐚𝐝𝐢𝐨𝟐). OK
e) Método perimetro(): para calcular el perímetro (𝐏𝐞𝐫𝐢𝐦𝐞𝐭𝐫𝐨 = 𝟐 ∗ 𝛑 ∗ 𝐫𝐚𝐝𝐢𝐨). ok
 */
package E2Circunferencia;

/**
 *
 * @author AlejaDevelops
 */
public class MainCircunferencia {

    public static void main(String[] args) {
        CircunferenciaService cs = new CircunferenciaService();
       Circunferencia c1 = cs.crearCircunferencia();
       cs.calcularArea(c1);
       cs.calcularPerimetro(c1);
    }
    
}
