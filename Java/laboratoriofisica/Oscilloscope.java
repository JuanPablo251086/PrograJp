public class Oscilloscope extends Equipo implements ISimulator, IPhysical
{
    public int pollingrate;


//super del constructor, lo pongo igual en todas las clases equipo y talvez se añade una que otra funcionalidad 
    public Oscilloscope(String nombre, String tipo, String caracteristicas, String fabricante, float consumo, int id) 
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
    @Override
    public void searchUpdate()
    {

    }
    @Override
    public void start()
    {

    }
    @Override
    public void stop()
    {

    }
        
}