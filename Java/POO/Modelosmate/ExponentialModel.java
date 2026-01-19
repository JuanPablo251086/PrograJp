import java.util.ArrayList;

public class ExponentialModel extends DeterministicModel {
    protected ArrayList<Double> coeffs; // 0: a, 1: b para y = a * exp(b * x)

    public ExponentialModel(String nombre, ArrayList<Double> coeffs) {
        super(nombre);
        if (coeffs.size() != 2) {
            throw new IllegalArgumentException("Se requieren dos coeficientes de parámetro");
        }
        this.coeffs = coeffs;
    }

    @Override
    protected String equation() {
        return "y = " + coeffs.get(0) + " * exp(" + coeffs.get(1) + " * x)";
    }

    @Override
    public ArrayList<Double> calculate(ArrayList<Double> params) {
        ArrayList<Double> results = new ArrayList<>();
        double a = coeffs.get(0);
        double b = coeffs.get(1);
        for (double x : params) {
            results.add(a * Math.exp(b * x));
        }
        outs = results;
        return results;
    }
}
