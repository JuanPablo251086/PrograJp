public class Battleship {
    private final int n, barcos, disparosMax; 
    private int disparosUsados;
    private Tablero tablero;
    private Consola vista;
    private Random rnd;

    //config

    n = 5;
    barcos = 3
    disparosMax = 8;

    public Battleship() 
    {
        this.tablero = new Tablero(this.n);
        this.vista = new Consola();
        this.rnd = new Random();
        this.disparosUsados = 0;

    }
    public void jugar()
    {
        this.vista.mostrarBienvenida();

        this.tablero.colocarBarcosAleatorios(this.n, )
        while()
        {
            this.vista.dibujarTablero()
            String entrada = this.vista.perdirEntrada("Comando ")
        }
    }
}
