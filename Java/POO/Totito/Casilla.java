public class Casilla {
    private boolean jugada;
    private String simbolo;

    public Casilla() {
        this.jugada = false;
        this.simbolo = " ";
    }

    public void setSimbolo(String sym) {
        this.simbolo = sym;
        this.jugada = true;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public boolean isJugada() {
        return this.jugada;
    }
}