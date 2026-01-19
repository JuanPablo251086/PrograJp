//Nivel más alto de abstraccion en los modelos, hubo un cambio en el diseño
//quité lo de error handling porque no encontre una forma generalizada de hacerlo de forma efectiva

import java.util.ArrayList;

public abstract class Model {
    protected String nombre;
    protected ArrayList<Double> args;
    protected ArrayList<Double> outs;

    public Model(String nombre) {
        this.nombre = nombre;
        this.args = new ArrayList<>();
        this.outs = new ArrayList<>();
    }

    public abstract ArrayList<Double> calculate(ArrayList<Double> params);
}