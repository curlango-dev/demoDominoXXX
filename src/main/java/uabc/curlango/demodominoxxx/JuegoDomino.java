package uabc.curlango.demodominoxxx;

import java.util.ArrayList;

/**
 * Clase JuegoDomino
 *
 * @author Cecilia M. Curlango Rosas
 * @version 03 2026
 */
public class JuegoDomino {
   private Cementerio fichas;
   private Tablero tablero;
   private Ficha ficha;

   public JuegoDomino() {
       fichas = new Cementerio();
       tablero = new Tablero();
   }

   public void colocarInicial() {
       tablero.acomodarPrimeraFicha(ficha);
   }
   public ArrayList<Ficha> getFichas() {
       return tablero.getFichas();
   }
   public boolean colocarIzquierda() {
       return tablero.colocarALaIzquierda(ficha);
   }
   public boolean colocarDerecha() {
       return tablero.colocarALaDerecha(ficha);
   }

   public boolean hayFichas() {
       return fichas.getCantidadDeFichas()!=0;
   }
   public Ficha getFicha() {

       if (fichas.getCantidadDeFichas()>0) {
           ficha = fichas.entregarFichas(1).getFirst();
       }
       return ficha;
   }
}
