
package E8GuardarFrase;

/**
 *
 * @author AlejaDevelops
 */
public class Frase {
    
    private String frase;
    private int longitudFrase;

    public Frase() {
    }

    public Frase(String frase, int longitudFrase) {
        this.frase = frase;
        this.longitudFrase = longitudFrase;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public int getLongitudFrase() {
        return longitudFrase;
    }

    public void setLongitudFrase(int longitudFrase) {
        this.longitudFrase = longitudFrase;
    }

    @Override
    public String toString() {
        return "Frase{" + "frase=" + frase + ", longitudFrase=" + longitudFrase + '}';
    }
    
    
    
}
