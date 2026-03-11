package uabc.curlango.demodominoxxx;

import java.util.ArrayList;

/**
 * Write a description of class Tester here.
 *
 * @author (Cecilia Curlango Rosas)
 * @version (a version number or a date)
 */
public class Tester
{ 
    private Cementerio fichas;
    private Jugador jugador;
    
    public void elTester() {
        fichas = new Cementerio();
        jugador = new Jugador("Cecy");
        ArrayList<Ficha> unas = fichas.entregarFichas(5);
        jugador.tomarFichas(unas);
        System.out.println(jugador.getFichasAsString());
    }
}