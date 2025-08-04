public class Combate
{
    private Pokemon ronda1a;
    private Pokemon ronda1b;
    private Pokemon ronda2a;
    private Pokemon ronda2b;
    private Pokemon ronda3a;
    private Pokemon ronda3b;
    private Pokemon ronda4a;
    private Pokemon ronda4b;
    private Sistema sistema = new Sistema();
    public Combate(Jugador j1, Jugador j2)
    {
    this.ronda1a = j1.getPokemon(1);
    this.ronda1b = j2.getPokemon(1);
    this.ronda2a = j1.getPokemon(2);
    this.ronda2b = j2.getPokemon(2);
    this.ronda3a = j1.getPokemon(3);
    this.ronda3b = j2.getPokemon(3);
    this.ronda4a = j1.getPokemon(4);
    this.ronda4b = j2.getPokemon(4);
    }
    public void inicicarCombate()
    {
    System.out.println("el ganador de la 1 es: " + sistema.efectuarRonda(ronda1a,ronda1b));
    System.out.println("el ganador de la 2 es: " + sistema.efectuarRonda(ronda2a,ronda2b));
    System.out.println("el ganador de la 3 es: " + sistema.efectuarRonda(ronda3a,ronda3b));
    System.out.println("el ganador de la 4 es: " + sistema.efectuarRonda(ronda4a,ronda4b));
    }
}