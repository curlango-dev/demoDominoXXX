package uabc.curlango.demodominoxxx;

import java.util.ArrayList;

/**
 * Write a description of class Jugador here.
 *
 * @author (Cecilia Curlango Rosas)
 * @version (a version number or a date)
 */
public class Jugador
{
    private ArrayList<Ficha> fichas;
    private String nombre;
    
    public Jugador(String nombre) {
        this.nombre = nombre;
        fichas = new ArrayList();
    }
    public void tomarFichas(ArrayList<Ficha> nuevas) {
        fichas.addAll(nuevas);
    }
    public String getFichas() {
        String lasFichas= "";
        for (Ficha f: fichas) {
            lasFichas = lasFichas + f;
        }
        return lasFichas;
    }
}