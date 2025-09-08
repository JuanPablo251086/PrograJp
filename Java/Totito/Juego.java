public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private Partida partida;
    private Vista vista;

    public Juego() {
        this.jugador1 = new Jugador(true); // Va primero
        this.jugador2 = new Jugador(false); // Va segundo
        this.vista = new Vista();
        this.partida = null;
    }

    public void loopPrincipal() {
        int opcion;
        do {
            vista.imprimirMenu();
            opcion = vista.obtenerOpcion();
            switch (opcion) {
                case 1:
                    comenzarPartida();
                    break;
                case 2:
                    imprimirInforme();
                    break;
                case 3:
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    System.out.println("Programa terminado.");
                    System.exit(1);
            }
        } while (opcion != 3);
        vista.cerrar();
    }

    public void comenzarPartida() {
        partida = new Partida();
        System.out.println("Nueva partida iniciada. Jugador X va primero.");
        vista.imprimirTablero(partida.getTablero());

        while (partida.isOngoing()) {
            Jugador actual = (partida.getTurno() % 2 == 0) ? jugador1 : jugador2;
            System.out.println("Turno de " + actual.getSimbolo() + ":");
            int[] mov = vista.obtenerMovimiento();
            partida.jugar(mov[0], mov[1], actual);
            vista.imprimirTablero(partida.getTablero());
        }

        Jugador ganador = partida.finalizar(jugador1, jugador2);
        vista.imprimirGanador(ganador);
    }

    public void imprimirInforme() {
        vista.imprimirInforme(jugador1, jugador2);
    }
}