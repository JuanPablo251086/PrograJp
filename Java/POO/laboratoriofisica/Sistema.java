import java.util.Collections;
import java.util.ArrayList;
//le cambie de nombre a sistema porque hacia clavo con todo lo de System
public class Sistema
{
    private ArrayList<Equipo> todoelequipo;
    private Menu elmenu;
    public Sistema()
    {
        this.todoelequipo = new ArrayList<Equipo>();
        this.elmenu = new Menu(this);
    }
    public void generarResumen()
    {
        ArrayList<String> summaries = new ArrayList<>();
        for (Equipo e : todoelequipo) {
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Tipo: " + e.getTipo());
            System.out.println("Caracteristicas: " + e.getCaracteristicas());
            System.out.println("Fabricante: " + e.getFabricante());
            System.out.println("Consumo: " + e.getConsumo());
            System.out.println("ID: " + e.getId());
            System.out.println("Estado: " + e.getEstado());
            System.out.println("-------------------");
        }
    }
    public void sort()
    {
        Collections.sort(this.todoelequipo);
    }
   
    public void addEquipo(Equipo e)
    {
        todoelequipo.add (e);
    }
    public void startmenus()
    {
        this.elmenu.startmenu();
    }
// public Equipo lookup(int identifier)
// {
// return(new Equipo()); //TODO
// }
    public ArrayList<Equipo> getEquipos() {
        return todoelequipo;
    }
    }