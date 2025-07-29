public class CompraActual{
    Generador elgenerador = new Generador();
    private int lot1 = elgenerador.generarN(0,15000);
    private int lot2 = elgenerador.generarN(0,15000);
    private int lot3 = elgenerador.generarN(0,15000);
    private int locGen = elgenerador.generarN(0,3);
    private boolean success = false;
    private int boletosComprados = 0;
    private int localidadasignada = 0;

    public boolean GenerarSuerte() {
        if ((this.lot1 < this.lot2 && this.lot1 > this.lot3) || (this.lot1 > this.lot2 && this.lot1 < this.lot3) ) {
            this.success = true;
            return(this.success);

    } else {

        return(this.success);
    }
    }
    
    public int GetLocalidad() {

    return(this.locGen);
            }

        }
    
