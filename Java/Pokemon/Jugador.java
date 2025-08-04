public class Jugador 
{
    PokeDex pokedex = new PokeDex();
    private String nombre = null;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;
    public Jugador(String nom, int p1,int p2,int p3,int p4)
    {
        this.nombre = nom;
        this.pokemon1 = pokedex.getPokemon(p1);
        this.pokemon2 = pokedex.getPokemon(p2);
        this.pokemon3 = pokedex.getPokemon(p3);
        this.pokemon4 = pokedex.getPokemon(p4);
    }

public Pokemon getPokemon(int e)
{
    if (e == 1) {
    return(this.pokemon1);
} else if (e == 2) {
    return(this.pokemon2);
} else if (e == 3) {
    return(this.pokemon3);
} else if (e == 4) {
    return(this.pokemon4);
} else {
return (this.pokemon1);
}

}
}