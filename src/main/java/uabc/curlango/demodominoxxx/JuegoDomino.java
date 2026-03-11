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
   private ArrayList<Jugador> jugadores;
   private int numeroJugadorActual;
   private Jugador jugadorActual;


   public JuegoDomino() {
       fichas = new Cementerio();
       tablero = new Tablero();
       jugadores = new ArrayList<>();
   }
   public void determinarPrimerJugador() {
       if (!jugadores.isEmpty()) {
           numeroJugadorActual = -1;
           for (int i = 0; i < jugadores.size(); i++) {
               Jugador j = jugadores.get(i);
               if (numeroJugadorActual == -1) {
                   if (j.tieneMulas()) {
                       numeroJugadorActual = i;
                       jugadorActual = j;
                   }
               } else {
                   if (j.tieneMulas() && jugadorActual.getMulaMasGrande().getLadoA() <
                           j.getMulaMasGrande().getLadoA()) {
                       numeroJugadorActual = i;
                       jugadorActual = j;
                   }
               }
           }
       }
       // atender el caso de que ningún jugador tenga una mula
       // entonces, el que tenga la ficha más alta empieza
       if (numeroJugadorActual == -1) {
           numeroJugadorActual = 0;
           jugadorActual = jugadores.get(numeroJugadorActual);
           for (int i = 1; i < jugadores.size(); i++) {
               Jugador j = jugadores.get(i);
               if (jugadorActual.getFichaMasAlta().getPuntos() >
               j.getFichaMasAlta().getPuntos()) {
                   numeroJugadorActual = i;
                   jugadorActual = j;
               }
           }
       }
   }
   public Jugador getJugadorActual() {
       return jugadorActual;
   }
   public ArrayList<Jugador> getJugadores() {
       return jugadores;
   }
   public void agregarJugador(String nombre) {
       if (jugadores.size() < 4) {
           jugadores.add(new Jugador(nombre));
       }
   }

   public void repartirFichas() {
       if (jugadores.size() >= 2) {
           for (Jugador jugador : jugadores) {
               jugador.tomarFichas(fichas.entregarFichas(7));
           }
       }
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
