public class ForceSensor extends Equipo implements IPhysical
{
    //super del constructor, lo pongo igual en todas las clases equipo y talvez se añade una que otra funcionalidad
    private boolean powered = false;
    public ForceSensor(String nombre, String tipo, String caracteristicas, String fabricante, float consumo, int id)
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
    }
    @Override
    public String getEstado()
    {
        return powered ? "Encendido" : "Apagado";
    }
}