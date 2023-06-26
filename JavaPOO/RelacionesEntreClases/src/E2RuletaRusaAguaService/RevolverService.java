/*
Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual (posición
del tambor que se dispara, puede que esté el agua o no) y posición agua (la posición del
tambor donde se encuentra el agua). Estas dos posiciones, se generarán aleatoriamente.
Métodos:
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)
 */
package E2RuletaRusaAguaService;

import E2RuletaRusaAgua.Revolver;

/**
 *
 * @author AlejaDevelops
 */
public class RevolverService {    
    
    public Revolver llenarRevolver(){
        Revolver r = new Revolver();
        r.setPosicionActual((int)(Math.random()*6)+1);
        r.setPosicionAgua((int)(Math.random()*6)+1);
        
        return r;
    }
    
    public boolean mojar(Revolver r){
        return r.getPosicionActual()==r.getPosicionAgua();
    }
    
    public Revolver siguienteChorro(Revolver r){
        if (r.getPosicionActual()<6) {
            r.setPosicionActual(r.getPosicionActual()+1);            
        }else
            r.setPosicionActual(1);
        return r;
    }
    
    public void toString(Revolver r){
        System.out.println(r.toString());
    }
}
