public class Partida {
    private Tablero tablero;
    private int turno;

    public Partida() {
        this.tablero = new Tablero();
        this.turno = 0;
    }

    public void jugar(int i, int j, Jugador jugadorActual) {
        if (tablero.getCasilla(i, j) == null || tablero.getCasilla(i, j).isJugada()) {
            System.out.println("Movimiento inválido: casilla inválida o ya ocupada.");
            System.out.println("Programa terminado.");
            System.exit(1);
        }
        tablero.llenarCasilla(i, j, jugadorActual.getSimbolo());
        turno++;
    }

    public Jugador finalizar(Jugador jugador1, Jugador jugador2) {
        String ganador = tablero.chequearGanador();
        if (ganador != null && !ganador.equals("tie")) {
            if (ganador.equals(jugador1.getSimbolo())) {
                jugador1.incrementarWins();
                return jugador1;
            } else if (ganador.equals(jugador2.getSimbolo())) {
                jugador2.incrementarWins();
                return jugador2;
            }
        }
        return null; 
    }

    public Tablero getTablero() {
        return tablero;
    }

    public int getTurno() {
        return turno;
    }

    public boolean isOngoing() {
        String result = tablero.chequearGanador();
        return result == null && !tablero.isFull();
    }
}