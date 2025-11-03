public class Generador extends Equipo implements IPhysical
{
    //super del constructor, lo pongo igual en todas las clases equipo y talvez se añade una que otra funcionalidad 
    public Generador(String nombre, String tipo, String caracteristicas, String fabricante, float consumo, int id) 
    {
        super(nombre, tipo, caracteristicas, fabricante, consumo, id);
    }
    @Override
    public void powerOn()
    {

    }
    @Override
    public void powerOff()
    {

    }
}