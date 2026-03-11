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
    public boolean tieneMulas() {
        for (Ficha ficha : fichas) {
            if (ficha.esMula()) {
                return true;
            }
        }
        return false;
    }
    public Ficha getFichaMasAlta() {
        Ficha fichaMasAlta = fichas.getFirst();
        for (int i = 1; i < fichas.size(); i++) {
            if (fichaMasAlta.getPuntos() < fichas.get(i).getPuntos()) {
                fichaMasAlta = fichas.get(i);
            }
        }
        return fichaMasAlta;
    }
    public Ficha getMulaMasGrande() {
        Ficha masGrande = new Ficha(0,0);
        if (tieneMulas()) {
            for (Ficha ficha : fichas) {
                if (ficha.esMula()) {
                    if (ficha.getLadoA() > masGrande.getLadoA()) {
                        masGrande = ficha;
                    }
                }
            }
            return masGrande;
        }
        return null;
    }
    public void tomarFichas(ArrayList<Ficha> nuevas) {
        fichas.addAll(nuevas);
    }
    public ArrayList<Ficha> getFichas() {
        return fichas;
    }
    public String getFichasAsString() {
        String lasFichas= "";
        for (Ficha f: fichas) {
            lasFichas = lasFichas + f;
        }
        return lasFichas;
    }

    @Override
    public String toString() {
        return nombre + " " + getFichasAsString();
    }
}