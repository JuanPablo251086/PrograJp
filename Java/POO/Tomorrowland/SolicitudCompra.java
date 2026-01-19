public class SolicitudCompra
{
    private String nombre = "";
    private String correo = "";
    private double presupuesto = 0.0;
    private int numeroBoletos = 0;

    public SolicitudCompra(String nom, String corr, double presu, int numBol) {
        this.nombre = nom;
        this.correo = corr;
        this.presupuesto = presu;
        this.numeroBoletos = numBol;
    }
    public String getNombre() {
        return(this.nombre);
    }
    public String getCorreo() {
        return(this.correo);
    }
    public double getPresupuesto() {
        return(this.presupuesto);
    }
    public int getNumBoletos() {
        return(this.numeroBoletos);
    }
}