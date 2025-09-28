import java.util.ArrayList;
public class Combatiente
{
    private int hp,atk,def,mp;
    private Str nombre;
    //en ingles para no confundir jaja
    private ArrayList<habilidades> habilities;
    
    public int getatk() {
        return(this.atk);
    }
    public int getdef() {
        return(this.def);
    }
    public int gethp() {
        return(this.hp);
    }
        public int getdef() {
        return(this.atk);
    }
        public int getmp() {
        return(this.mp);

        public ArrayList<Habilidades> gethabilidades()
        {
            
        }
    }

    public void dañar(int daño)
    //Al final voy a usar este mismo metodo para curar, usando daño negativo
    {
        this.hp = this.hp - daño;
    }
    public void appStatus(Efecto efecto)
    //Necesitare una nueva clase "efecto" para poder efectuar de manera correcta efectos sobre el personaje. No se si esto sera demasiado dificil de implementar, pero igual lo voy a dejar aquí.

    public void costo(int cmp)
    //Esto es para el manejo de MP
    {
        this.mp = this.mp - cmp;
    }
    usarHabilidad(Habilidad)
}