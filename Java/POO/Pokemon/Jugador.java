public class Jugador 
{
    PokeDex pokedex = new PokeDex();
    private String nombre;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;
    private Pokemon[] escogidos = new Pokemon[4];
    public Jugador(String nom, int p1,int p2,int p3,int p4)
    {
        this.nombre = nom;
        this.pokemon1 = pokedex.getPokemon(p1);
        this.escogidos[0] = this.pokemon1;
        this.pokemon2 = pokedex.getPokemon(p2);
        this.escogidos[1] = this.pokemon2;
        this.escogidos[2] = this.pokemon3;
        this.escogidos[3] = this.pokemon4;
        this.pokemon2 = pokedex.getPokemon(p2);
        this.pokemon3 = pokedex.getPokemon(p3);
        this.pokemon4 = pokedex.getPokemon(p4);
    }
public boolean chequearRepetidos(Pokemon[] pokes) {
    Pokemon[] vistos = new Pokemon[4];
    for (int i = 0; i< pokes.length; i++)
    {
        if(vistos[i] == null) 
        {
            vistos[i] = pokes[i];
        } else if (vistos.cwontains(pokes[i])) {
                return false;
                break;
            }
        }
        return(true);
    }
    

public Pokemon getPokemon(int e)
{
   return (this.escogidos[e]);
}


public String getNombre()
{
    return(this.nombre);
}
}