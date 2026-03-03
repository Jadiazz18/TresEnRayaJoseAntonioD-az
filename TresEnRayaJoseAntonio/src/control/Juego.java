package control;

import modelo.*;

public class Juego {

    private Tablero tablero;
    private Tipo turno;

    public Juego() {
        tablero = new Tablero();
        turno = Tipo.X;
    }

    public boolean jugar(int fila, int columna) {
        boolean colocado = tablero.colocarFicha(fila, columna, turno);
        if (colocado) {
            cambiarTurno();
        }
        return colocado;
    }

    private void cambiarTurno() {
        turno = (turno == Tipo.X) ? Tipo.O : Tipo.X;
    }

    public Tipo getTurno() {
        return turno;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Tipo comprobarGanador() {
        Tipo[][] t = tablero.getTablero();

        // Filas y columnas
        for (int i = 0; i < 3; i++) {
            if (t[i][0] != Tipo.VACIO &&
                t[i][0] == t[i][1] &&
                t[i][1] == t[i][2]) {
                return t[i][0];
            }

            if (t[0][i] != Tipo.VACIO &&
                t[0][i] == t[1][i] &&
                t[1][i] == t[2][i]) {
                return t[0][i];
            }
        }

        // Diagonales
        if (t[0][0] != Tipo.VACIO &&
            t[0][0] == t[1][1] &&
            t[1][1] == t[2][2]) {
            return t[0][0];
        }

        if (t[0][2] != Tipo.VACIO &&
            t[0][2] == t[1][1] &&
            t[1][1] == t[2][0]) {
            return t[0][2];
        }

        return null;
    }
}