public class PenduloEncoder extends Equipo implements ISimulator, IPhysical
{
    //super del constructor, lo pongo igual en todas las clases equipo y talvez se añade una que otra funcionalidad
    private boolean powered = false;
    private boolean running = false;
    public PenduloEncoder(String nombre, String tipo, String caracteristicas, String fabricante, float consumo, int id)
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
        this.powered = false;
        this.running = false;
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
