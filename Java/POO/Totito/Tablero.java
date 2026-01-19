import java.util.ArrayList;
public class Tablero {
    private Casilla[][] casillas;

    public Tablero() {
        this.casillas = new Casilla[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.casillas[i][j] = new Casilla();
            }
        }
    }

    @Override
    public String toString() {
        ArrayList<String> lineas = new ArrayList<>();
        lineas.add("  0 1 2");
        for (int i = 0; i < 3; i++) {
            ArrayList<String> filas = new ArrayList<>();
            filas.add(i + "");
            filas.add(" ");
            for (int j = 0; j < 3; j++) {
                filas.add(casillas[i][j].getSimbolo());
                filas.add(" ");
            }
            lineas.add(String.join("", filas));
        }
        return String.join("\n", lineas);
    }

    public void llenarCasilla(int i, int j, String symb) {
        if (i < 0 || i >= 3 || j < 0 || j >= 3) {
            System.out.println("Movimiento inválido: índices fuera de rango (0-2).");
            System.out.println("Programa terminado.");
            System.exit(1);
        }
        if (casillas[i][j].isJugada()) {
            System.out.println("Movimiento inválido: casilla ya ocupada.");
            System.out.println("Programa terminado.");
            System.exit(1);
        }
        casillas[i][j].setSimbolo(symb);
    }

    public String chequearGanador() {
        // chequea filas
        for (int i = 0; i < 3; i++) {
            String sym = casillas[i][0].getSimbolo();
            if (!sym.equals(" ") && sym.equals(casillas[i][1].getSimbolo()) && sym.equals(casillas[i][2].getSimbolo())) {
                return sym;
            }
        }
        // chequea columnas
        for (int j = 0; j < 3; j++) {
            String sym = casillas[0][j].getSimbolo();
            if (!sym.equals(" ") && sym.equals(casillas[1][j].getSimbolo()) && sym.equals(casillas[2][j].getSimbolo())) {
                return sym;
            }
        }
        // chequea diagonales
        String sym1 = casillas[0][0].getSimbolo();
        if (!sym1.equals(" ") && sym1.equals(casillas[1][1].getSimbolo()) && sym1.equals(casillas[2][2].getSimbolo())) {
            return sym1;
        }
        String sym2 = casillas[0][2].getSimbolo();
        if (!sym2.equals(" ") && sym2.equals(casillas[1][1].getSimbolo()) && sym2.equals(casillas[2][0].getSimbolo())) {
            return sym2;
        }
        // Chequea empate
        boolean tie = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!casillas[i][j].isJugada()) {
                    tie = false;
                    break;
                }
            }
            if (!tie) break;
        }
        if (tie) {
            return "tie";
        }
        return null; //no hacer nada si no pasa nada ;)
    }

    public Casilla getCasilla(int i, int j) {
        if (i >= 0 && i < 3 && j >= 0 && j < 3) {
            return casillas[i][j];
        }
        return null;
    }

    public boolean isFull() { //chequea si esta lleno nomas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!casillas[i][j].isJugada()) {
                    return false;
                }
            }
        }
        return true;
    }
}