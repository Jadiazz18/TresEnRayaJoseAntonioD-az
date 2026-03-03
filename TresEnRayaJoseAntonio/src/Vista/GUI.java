package Vista;

import control.Juego;
import modelo.Tipo;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private Juego juego;
    private JButton[][] botones;

    public GUI() {
        juego = new Juego();
        botones = new JButton[3][3];

        setTitle("Tres en Raya");
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));

        inicializarBotones();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void inicializarBotones() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton boton = new JButton("");
                int fila = i;
                int columna = j;

                boton.addActionListener(e -> {
                    if (juego.jugar(fila, columna)) {
                        actualizarVista();
                        Tipo ganador = juego.comprobarGanador();
                        if (ganador != null) {
                            JOptionPane.showMessageDialog(this, 
                                "Ganador: " + ganador);
                        }
                    }
                });

                botones[i][j] = boton;
                add(boton);
            }
        }
    }

    private void actualizarVista() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tipo tipo = juego.getTablero().getCasilla(i, j);
                botones[i][j].setText(
                    tipo == Tipo.VACIO ? "" : tipo.toString()
                );
            }
        }
    }
}