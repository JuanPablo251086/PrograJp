import java.util.Scanner;
public class Vista {
    private Scanner scanner;

    public Vista() {
        this.scanner = new Scanner(System.in);
    }

    public void imprimirTablero(Tablero tablero) {
        System.out.println(tablero.toString());
    }

    public int[] obtenerMovimiento() {
        try {
            System.out.print("Ingrese fila (0-2): ");
            int i = scanner.nextInt();
            if (i < 0 || i > 2) {
                System.out.println("Fila debe ser entre 0 y 2.");
                System.out.println("Programa terminado.");
                System.exit(1);
            }
            System.out.print("Ingrese columna (0-2): ");
            int j = scanner.nextInt();
            if (j < 0 || j > 2) {
                System.out.println("Columna debe ser entre 0 y 2.");
                System.out.println("Programa terminado.");
                System.exit(1);
            }
            return new int[]{i, j};
        } catch (Exception e) {
            System.out.println("Entrada inválida: debe ingresar números enteros.");
            System.out.println("Programa terminado.");
            System.exit(1);
            return new int[]{-1, -1}; //retorno lo q sea para q compile
        }
    }

    public void imprimirMenu() {
        System.out.println("1. Comenzar nueva partida");
        System.out.println("2. Ver informe de victorias");
        System.out.println("3. Salir");
        System.out.print("Elija una opción: ");
    }

    public int obtenerOpcion() {
        try {
            int opcion = scanner.nextInt();
            if (opcion < 1 || opcion > 3) {
                System.out.println("Opción inválida: debe ser 1, 2 o 3.");
                System.out.println("Programa terminado.");
                System.exit(1);
            }
            return opcion;
        } catch (Exception e) {
            System.out.println("Entrada inválida: debe ingresar un número entero.");
            System.out.println("Programa terminado.");
            System.exit(1);
            return(-1); //igual no se llega aqui entonces solo retorno lo que sea pa q compile
        }
    }

    public void imprimirGanador(Jugador ganador) {
        if (ganador != null) {
            System.out.println("¡Jugador " + ganador.getSimbolo() + " gana!");
        } else {
            System.out.println("¡Empate!");
        }
    }

    public void imprimirInforme(Jugador j1, Jugador j2) {
        System.out.println("Jugador X (primero): " + j1.getWins() + " victorias");
        System.out.println("Jugador O (segundo): " + j2.getWins() + " victorias");
    }

    public void cerrar() {
        scanner.close();
    }
}

