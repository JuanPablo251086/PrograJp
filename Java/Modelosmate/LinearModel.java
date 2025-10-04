import java.util.ArrayList;

public class LinearModel extends DeterministicModel { //caso especial de este
    protected ArrayList<Double> coeffs; // 0 es pendiente, 1 es intercepto

    public LinearModel(String nombre, ArrayList<Double> coeffs) {
        super(nombre);
        if (coeffs.size() != 2) {
            throw new IllegalArgumentException("Requiere exactamente 2 parametros");
        }
        this.coeffs = coeffs;
    }

    @Override
    protected String equation() {
        return "y = " + coeffs.get(0) + "x + " + coeffs.get(1);
    }

    @Override
    public ArrayList<Double> calculate(ArrayList<Double> params) {
        ArrayList<Double> results = new ArrayList<>();
        double slope = coeffs.get(0);
        double intercept = coeffs.get(1);
        for (double x : params) {
            results.add(slope * x + intercept);
        }
        outs = results;
        return results;
    }

    public double calculateRoots() {
        if (coeffs.get(0) == 0) {
            throw new IllegalArgumentException("Error, la pendiente no puede ser 0");
        }
        return -coeffs.get(1) / coeffs.get(0);
    }
}