public class Jugador {
    private String simbolo;
    private int wins;
    private boolean vaPrimero;

    public Jugador(boolean vaPrimero) {
        this.wins = 0;
        this.vaPrimero = vaPrimero;
        this.simbolo = vaPrimero ? "X" : "O";
    }

    public int getWins() {
        return this.wins;
    }

    public void setSimbolo(String sym) {
        this.simbolo = sym;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public boolean getVaPrimero() {
        return this.vaPrimero;
    }

    public void incrementarWins() {
        this.wins++;
    }

    public boolean isTurno(int currentTurn) {
        return (currentTurn % 2 == 0) == this.vaPrimero; //op modulo para que no se pase al sumarle
    }
}