public class SimCalor extends Equipo implements ISimulator
{
//super del constructor, lo pongo igual en todas las clases equipo y talvez se añade una que otra funcionalidad
    private boolean running = false;
    public SimCalor(String nombre, String tipo, String caracteristicas, String fabricante, float consumo, int id)
    {
        super(nombre, tipo, caracteristicas, fabricante, consumo, id);
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
        return running ? "Ejecutando" : "Detenido";
    }
}