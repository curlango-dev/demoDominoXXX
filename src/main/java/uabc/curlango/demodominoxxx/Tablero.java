package uabc.curlango.demodominoxxx;

import java.util.ArrayList;

/**
 * Clase Tablero
 *
 * @author Cecilia M. Curlango Rosas
 * @version 03 2026
 */
public class Tablero {
    private ArrayList<Ficha> fichas;

    public Tablero() {
        fichas = new ArrayList<>();
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }
    public void acomodarPrimeraFicha(Ficha ficha) {
        fichas.add(ficha);
    }

    public boolean colocarALaIzquierda(Ficha ficha) {
        boolean resultado = false;
        Ficha primera = fichas.getFirst();
        if (primera.getLadoA() == ficha.getLadoB()) {
            fichas.add(0, ficha);
            resultado = true;
        } else {
            if (primera.getLadoA() == ficha.getLadoA()) {
                ficha.voltear();
                fichas.addFirst(ficha);
                resultado = true;
            }
        }
        return resultado;
    }
    public boolean colocarALaDerecha(Ficha ficha) {
        boolean resultado = false;
        Ficha ultima = fichas.getLast();
        if (ultima.getLadoB() == ficha.getLadoA()) {
            fichas.add(ficha);
            resultado = true;
        } else {
            if (ficha.getLadoB() == ultima.getLadoB()) {
                ficha.voltear();
                fichas.add(ficha);
                resultado = true;
            }
        }
        return resultado;
    }
}
