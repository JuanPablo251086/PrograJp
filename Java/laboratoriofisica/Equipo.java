import java.util.ArrayList;



//Ya no la hice abstract porque así puedo usar polimorfismo más fácilmente
public class Equipo implements Comparable<Equipo>
{


    private String nombre, tipo, caracteristicas, fabricante;
    //quite status, esta responsabilidad se la voy a implentar individualmente acorde al caso
    private float consumo;
    private int id;
    ArrayList<Float> readings;
    //tuve que hacer un workaround aqui con este atributo para poder establecer varios parametros de comparacion 
    public boolean ordenMayor;

    public Equipo(String nombre, String tipo, String caracteristicas, String fabricante, float consumo, int id)
    {
        this.nombre = nombre;
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.fabricante = fabricante;
        this.consumo = consumo;
        this.id = id;

        
        //Lecturas se inicializa sin nada
        this.readings = new ArrayList<Float>();
        //comportamiento default
        this.ordenMayor = true;
    }

    


    public int getId()
    {
        return this.id;
    }
    public String getNombre()
    {
        return this.nombre;
    }
    public String getCaracteristicas()
    {
        return this.caracteristicas;
    }

    public void setOrden(boolean nuevo)
    {
        this.ordenMayor = nuevo;
    }    

    @Override
    public int compareTo(Equipo otroEquipo) {
        if (this.ordenMayor) {
            return Float.compare(otroEquipo.consumo, this.consumo);
        } else {
            return Float.compare(this.consumo, otroEquipo.consumo);
        }
    }
}