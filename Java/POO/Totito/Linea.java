public class Linea { //ya ni la pare usando mucho
    private Casilla[] casillas;
    private String tipo;

    public Linea(Casilla[] casillas, String tipo) {
        this.casillas = casillas;
        this.tipo = tipo;
    }

    public Casilla[] getLinea() {
        return this.casillas;
    }
}