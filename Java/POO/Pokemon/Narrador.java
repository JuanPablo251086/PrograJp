public class Narrador 
{
    public void narrarAtaqueNormal(Pokemon p1)
{
        System.out.println(p1 + "Usa " + p1.getMovimientoAtaque());
}
    public void narrarAtaqueEspecial(Pokemon p1)
    {
    System.out.println(p1+"Usa su habilidad especial, " + p1.getMovimientoEspecial());
}

    public void narrarEfecto(Pokemon p1) {
        System.out.println("Es Supereficaz!");
    }
    public void narrarinicioCombate(Jugador j1, Jugador j2)
    {
        System.out.println("Comienza el combate entre " + j1.getNombre() + " y " + j2.getNombre());
    }
    public void narrarRonda(int num, Pokemon pganador)
    {
        System.out.println("el ganador de la ronda " + num + " es: " + pganador);
    }

}
