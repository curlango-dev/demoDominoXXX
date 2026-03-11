package uabc.curlango.demodominoxxx;

/**
 * Modela una Ficha de domino.
 *
 * @author (Cecilia Curlango Rosas)
 * @version (febrero 2026)
 */
public class Ficha
{
    private int ladoA;
    private int ladoB;
    
    public Ficha(int ladoA, int ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }
    
    public int getLadoA() {
        return ladoA;
    }
    public int getLadoB() {
        return ladoB;
    }
    public boolean esMula() {
        return ladoA == ladoB;
    }
    public int getPuntos() {
        return ladoA + ladoB;
    }
    public String toString() {
        return "["+ ladoA +"|"+ladoB+"]";
    }
    public void voltear() {
        int temp = ladoA;
        ladoA = ladoB;
        ladoB = temp;
    }
}