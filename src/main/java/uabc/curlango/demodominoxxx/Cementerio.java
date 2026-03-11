package uabc.curlango.demodominoxxx;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Modela un cementerio de domino.
 *
 * @author (Cecilia Curlango Rosas)
 * @version (febrero 2026)
 */
public class Cementerio
{
    private ArrayList<Ficha> banco;
    private int mulaMasGrande; // que tiene el domino
    
    public Cementerio(int mula) {
        if (mula<0) {
            mulaMasGrande = 6;
        } else {
            mulaMasGrande = mula;
        }
        llenar();
        mezclar();
    }
    
    public Cementerio() {
        mulaMasGrande = 6;
        llenar();
        mezclar();
    }
    public void mezclar() {
        Collections.shuffle(banco);
    }
    public int getCantidadDeFichas() {
        return banco.size();
    }
    public String toString() {
        String lasFichas = "";
        for (Ficha f: banco) {
            lasFichas = lasFichas + f;
        }
        
        return lasFichas;
    }
    public ArrayList<Ficha> entregarFichas(int n) {
        ArrayList<Ficha> entregadas = new ArrayList();
        for (int i=0; !banco.isEmpty() && i<n; i++) {
            Ficha f = banco.remove(0);
            entregadas.add(f);
        }
        return entregadas;
    }
    public void llenar() {
        banco = new ArrayList();
        for (int i=0; i<=mulaMasGrande; i++) {
            for (int j=i; j<=mulaMasGrande; j++) {
                Ficha ficha = new Ficha(i,j);
                banco.add(ficha);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
}