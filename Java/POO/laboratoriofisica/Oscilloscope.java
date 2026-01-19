public class Oscilloscope extends Equipo implements ISimulator, IPhysical
{
    public int pollingrate;
    private boolean running = false;
//super del constructor, lo pongo igual en todas las clases equipo y talvez se añade una que otra funcionalidad
    private boolean powered = false;
    public Oscilloscope(String nombre, String tipo, String caracteristicas, String fabricante, float consumo, int id)
    {
        super(nombre, tipo, caracteristicas, fabricante, consumo, id);
    }
    @Override
    public void powerOn()
    {
        this.powered = true;
    }
    @Override
    public void powerOff()
    {
        this.running = false;
        this.powered = false;
    }
    @Override
    public void searchUpdate()
    {
    }
    @Override
    public void start()
    {
        this.running = true;
    }
    @Override
    public void stop()
    {
        this.running = false;
    }
    @Override
    public String getEstado()
    {
        return (powered ? "Encendido" : "Apagado") + ", " + (running ? "Ejecutando" : "Detenido");
    }
       
}