package modelo;

public class Tablero {

    private Tipo[][] tablero;

    public Tablero() {
        tablero = new Tipo[3][3];
        inicializar();
    }

    public void inicializar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = Tipo.VACIO;
            }
        }
    }

    public boolean colocarFicha(int fila, int columna, Tipo tipo) {
        if (tablero[fila][columna] == Tipo.VACIO) {
            tablero[fila][columna] = tipo;
            return true;
        }
        return false;
    }

    public Tipo getCasilla(int fila, int columna) {
        return tablero[fila][columna];
    }

    public Tipo[][] getTablero() {
        return tablero;
    }
}