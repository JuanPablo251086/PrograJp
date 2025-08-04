public class Combate
{
    private Jugador jugador1;
    private Jugador jugador2;
    private Pokemon ronda1a;
    private Pokemon ronda1b;
    private Pokemon ronda2a;
    private Pokemon ronda2b;
    private Pokemon ronda3a;
    private Pokemon ronda3b;
    private Pokemon ronda4a;
    private Pokemon ronda4b;
    private Sistema sistema = new Sistema();

    public Sistema getSistema()
    {
        return this.sistema;
    }
    public Combate(Jugador j1, Jugador j2)
    {
    this.jugador1 = j1;
    this.jugador2 = j2;

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
    sistema.narrador.narrarinicioCombate(jugador1,jugador2);
    sistema.narrador.narrarRonda(1,sistema.efectuarRonda(ronda1a,ronda1b));
    sistema.narrador.narrarRonda(2,sistema.efectuarRonda(ronda2a,ronda2b));
    sistema.narrador.narrarRonda(3,sistema.efectuarRonda(ronda3a,ronda3b));
    sistema.narrador.narrarRonda(4,sistema.efectuarRonda(ronda4a,ronda4b));
    }
}