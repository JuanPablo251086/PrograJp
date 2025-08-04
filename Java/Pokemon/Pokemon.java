public class Pokemon
{   

    private int id;
    private String nombre;
    private String tipo;
    private double ataque;
    private double defensa;
    private String movimientoAtaque;
    private String movimientoEspecial;
    private double efectoAtaque;
    private String efectoEspecial;
    private double danioEspecial;

    public Pokemon(int ide, String nom, String typ, double atk, double def, String moviAt, double eA, String moviEs, String eE, double danioE)
    {
        this.id = ide;
        this.nombre = nom;
        this.tipo = typ;
        this.ataque = atk;
        this.defensa = def;
        this.movimientoAtaque = moviAt;
        this.movimientoEspecial = moviEs;
        this.efectoAtaque = eA;
        this.efectoEspecial = eE;
        this.danioEspecial = danioE;
    }

    public String toString()
    {
        return(this.nombre + this.tipo);
    }
    public void setAtaque(double valor)
    {
        this.ataque = valor;
    }

    public void setDefensa(double valor)
    {
        this.defensa = valor;
    }
    public double getAtaque()
   {
        return (this.ataque);
   }

   public double getDefensa()
   {
        return (this.defensa);
   }
    public String getTipo()
    {
        return (this.tipo);
    }
    public String getEfectoE()
    {
        return (this.efectoEspecial);
    }
    public double getAtaqueEspecial()
    {
        return(this.danioEspecial);
    }
}