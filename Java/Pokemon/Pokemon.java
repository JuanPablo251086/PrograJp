public class Pokemon
{
    private String nombre = null;
    private String tipo = null;
    private double ataque = 0;
    private double defensa = 0;
    private Movimiento movimA = new Movimiento(a);
    private Movimiento movimE = new Movimiento(e);

    public void Pokemon(String nom, String typ, double atk, double def, Movimiento ma, Movimiento me)
    {
        this.nombre = nom;
        this.nombre = typ;
        this.ataque = atk;
        this.defensa = def;
        this.movimA = ma;
    }


    public void setAtaque(int valor)
    {
        this.ataque = valor;
    }

    public void setDefensa(int valor)
    {
        this.ataque = valor;
    }
    public int getAtaque()
   {
        return (this.ataque);
   }

   public int getDefensa()
   {
        return (this.defensa);
   }
    public Srting getTipo()
    {
        return (this.tipo);
    }
}