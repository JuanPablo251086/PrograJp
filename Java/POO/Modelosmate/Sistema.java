import java.util.ArrayList;

public class Sistema {
    private ArrayList<Model> modelos = new ArrayList<>(); //en general este atributo de aqui es el que refleja de mayor manera el polimorfismo
    private Menu menu;
    private Vista vista;

    public Sistema() {
        this.vista = new Vista();
        this.menu = new Menu(this);
    }

    public void run(Model model, ArrayList<Double> params) {
        try {
            ArrayList<Double> results = model.calculate(params);
            if (model instanceof DeterministicModel) {
                vista.Display("Ecuacion: " + ((DeterministicModel) model).equation());
            }
            vista.Display(results);
        } catch (Exception e) {
            vista.Display("Error: " + e.getMessage());
        }
    }

    public void addModel(Model model) {
        modelos.add(model);
    }

    public ArrayList<Model> getModelos() { 
        return modelos;
    }

    public Menu getMenu() {
        return menu;
    }

    public Vista getVista() {
        return vista;
    }
}