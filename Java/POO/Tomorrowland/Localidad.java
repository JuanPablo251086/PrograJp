public class Localidad{
    private int disponibilidad = 0;
    private int id = 0;
    private int precio = 0;
    private int ventas = 0;
    private int ganancias = 0;
    private String nombre = "";

    public Localidad(String nom, int disp, int prec, int id) {
        this.disponibilidad = disp;
        this.precio = prec;
        this.nombre = nom;
        this.id = id;
    }
    public String toString() {
        return("la Localidad " + this.id + " tiene " + this.disponibilidad + " Asientos disponibles con " + this.ventas + " ventas Y cada uno cuesta " + this.precio );
    }
    public int getPrecio()
    {
        return(this.precio);
    } 
    public int getVentas()
    {
        return(this.ventas);
    }
    public int getDisponibilidad()
    {
        return(this.disponibilidad);
    }
    public void compra(int cant) {
        this.disponibilidad = this.disponibilidad - cant;
        this.ventas = this.ventas + cant;
        this.ganancias = this.ventas * this.precio; 
    }
    public int getGanancias()
    {
        return(this.ganancias);
    }
}
