public class Tablero

{

    private int n, barcosTotales;
    Celda [][] celdas;

    public Tablero(int n)
    {
        for(int i = 0; i < this.n - 1; i++) {
            for (int j = 0; j < this.n-1; j++) {
                this.celdas[i][j] = new Celda();
            }
        }
        this.n = n;
        this.celdas = new Celda[n][n];
        this.barcosTotales = 0;

    }

    public int getCelda(int i, int j)
    {
        return celdas[i][j];
    }
    public void colocarBarcosAleatorios(int cantidad, Random rnd, int tamanio){
        int colocados = 0;
        while (colocados < cantidad)
            int i = rnd.nextInt(this.n);
            int j = rnd.nextInt(this.n);
            if (!this.celdas[i][j].tieneBarco())
            {
                this.celdas[i][j].ponerBarco();
                colocados++;
            }
    }
    public int barcosHundidos()
    {
        int aciertos = 0;
        for (int i = 0; i< this.n; i++)
            for (int j = 0; j< this.n; j++)
            
    }
}