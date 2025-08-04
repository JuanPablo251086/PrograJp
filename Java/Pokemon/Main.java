public class Main
{

    public static void main(String[] args)
    {
        Jugador jugador1 = new Jugador("pepe",12,4,9,100);
        Jugador jugador2 = new Jugador("pancho",13,5,18,101);
        Combate esteCombate = new Combate(jugador1,jugador2);

        esteCombate.inicicarCombate();
    }
}