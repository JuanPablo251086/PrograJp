public class Main
{

    public static void main(String[] args)
    {
        Jugador jugador1 = new Jugador("pepe",5,8,9,10);
        Jugador jugador2 = new Jugador("pancho",4,3,2,1);
        Combate esteCombate = new Combate(jugador1,jugador2);

        esteCombate.inicicarCombate();
    }
}