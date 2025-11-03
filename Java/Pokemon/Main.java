public class Main
{

    public static void main(String[] args)
    {
        Jugador jugador1 = new Jugador("Nicolas",1,6,10,90);
        Jugador jugador2 = new Jugador("JP",91,105,104,49);
        Combate esteCombate = new Combate(jugador1,jugador2);

        esteCombate.inicicarCombate();
    }
}