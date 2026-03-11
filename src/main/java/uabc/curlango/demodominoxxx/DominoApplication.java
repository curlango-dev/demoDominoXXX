package uabc.curlango.demodominoxxx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class DominoApplication extends Application {
    private JuegoDomino juego;
    private HBox tablero;
    // controles
    private VBox controles;
    private Button nuevaFicha;
    private Button colocarIzquierda;
    private Button colocarDerecha;
    private Button colocarInicial;
    private Label fichaActual;

    @Override
    public void start(Stage stage) throws IOException {
        juego = new JuegoDomino();
        tablero = new HBox();
        Ficha ficha = juego.getFicha();
        FichaEmoji fichaEmoji = new FichaEmoji(ficha.getLadoA(), ficha.getLadoB());

        crearControles();
        asignarAcciones();
        BorderPane root = new BorderPane();
        root.setCenter(tablero);
        root.setRight(controles);

        Scene scene = new Scene(root, 520, 640);
        stage.setTitle("Domino!");
        stage.setScene(scene);
        stage.show();
    }

    private void agregarFicha() {
        Ficha ficha = juego.getFicha();
        FichaEmoji fichaEmoji = new FichaEmoji(ficha.getLadoA(), ficha.getLadoB());
        fichaActual.setText(fichaEmoji.getEmoji());
    }
    private Label crearFicha() {
        Label label = new Label(fichaActual.getText());
        Font font = new Font("Arial", 40);
        label.setFont(font);
        return label;
    }
    private void asignarAcciones() {
        colocarDerecha.setOnMouseClicked(event -> {
            if (juego.colocarDerecha()) {
                redibujarTablero();
                agregarFicha();
            }
        });
        colocarIzquierda.setOnMouseClicked(event -> {
            if (juego.colocarIzquierda()) {
                redibujarTablero();
                agregarFicha();
            }
        });
        nuevaFicha.setOnAction(e -> {
            if (juego.hayFichas()) {
                agregarFicha();
            } else {
                nuevaFicha.setDisable(true);
                colocarIzquierda.setDisable(true);
                colocarDerecha.setDisable(true);
            }
        });
        colocarInicial.setOnMouseClicked(event -> {
            juego.colocarInicial();
            redibujarTablero();
            agregarFicha();

            colocarInicial.setDisable(true);
            nuevaFicha.setDisable(false);
            colocarDerecha.setDisable(false);
            colocarIzquierda.setDisable(false);
        });
    }

    private void redibujarTablero() {
        ArrayList<Ficha> lasFichasActuales = juego.getFichas();
        tablero.getChildren().clear();

        for (Ficha ficha : lasFichasActuales) {
            FichaEmoji fichaEmoji = new FichaEmoji(ficha.getLadoA(),
                    ficha.getLadoB());
            Label label = new Label(fichaEmoji.getEmoji());
            Font font = new Font("Arial", 40);
            label.setFont(font);
            tablero.getChildren().add(label);
        }
    }

    private void crearControles() {
        controles = new VBox();
        nuevaFicha = new Button("Ficha nueva");
        nuevaFicha.setDisable(true);
        colocarIzquierda = new Button("Izquierda");
        colocarIzquierda.setDisable(true);
        colocarDerecha = new Button("Derecha");
        colocarDerecha.setDisable(true);
        colocarInicial = new Button("Inicial");
        Ficha ficha = juego.getFicha();
        FichaEmoji fichaEmoji = new FichaEmoji(ficha.getLadoA(), ficha.getLadoB());
        fichaActual = new Label(fichaEmoji.getEmoji());
        Font font = new Font("Arial", 60);
        fichaActual.setFont(font);
        controles.getChildren().addAll(fichaActual,
                nuevaFicha,
                colocarIzquierda,
                colocarDerecha,
                colocarInicial);
    }

    public static void main(String[] args) {
        JuegoDomino juegoDomino = new JuegoDomino();
        juegoDomino.agregarJugador("Cecy");
        juegoDomino.agregarJugador("María");
        juegoDomino.agregarJugador("Juan");
        juegoDomino.agregarJugador("Merlina");

        juegoDomino.repartirFichas();
        ArrayList<Jugador> jugadores = juegoDomino.getJugadores();
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
        juegoDomino.determinarPrimerJugador();
        Jugador jugadorActual = juegoDomino.getJugadorActual();
        System.out.println("El primero será " + jugadorActual);
        // launch();
    }
}