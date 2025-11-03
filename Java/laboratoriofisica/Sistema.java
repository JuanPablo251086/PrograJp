import java.util.Collections;
import java.util.ArrayList;
//le cambie de nombre a sistema porque hacia clavo con todo lo de System
public class Sistema
{

    private ArrayList<Equipo> todoelequipo;
    private Menu elmenu;

    public Sistema()
    {
        ArrayList todoelequipo = new ArrayList<Equipo>();
        this.elmenu = new Menu();
    }

    public String generarResumen()
    {
        return ""; //TODO
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
//     public Equipo lookup(int identifier)
//     {
//         return(new Equipo()); //TODO
//     }
    }