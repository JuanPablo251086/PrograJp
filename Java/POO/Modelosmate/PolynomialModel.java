import java.util.ArrayList;

public class PolynomialModel extends DeterministicModel {
    protected ArrayList<Double> coeffs; 

    public PolynomialModel(String nombre, ArrayList<Double> coeffs) {
        super(nombre);
        if (coeffs.isEmpty()) {
            throw new IllegalArgumentException("Polynomial requires at least one coefficient");
        }
        this.coeffs = coeffs;
    }

    @Override
    protected String equation() {
        StringBuilder eq = new StringBuilder("y = ");
        for (int i = 0; i < coeffs.size(); i++) {
            eq.append(coeffs.get(i));
            if (i > 0) {
                eq.append(" * x^").append(i);
            }
            if (i < coeffs.size() - 1) {
                eq.append(" + ");
            }
        }
        return eq.toString();
    }

    @Override
    public ArrayList<Double> calculate(ArrayList<Double> params) {
        ArrayList<Double> results = new ArrayList<>();
        for (double x : params) {
            double y = 0;
            for (int i = 0; i < coeffs.size(); i++) {
                y += coeffs.get(i) * Math.pow(x, i);
            }
            results.add(y);
        }
        outs = results;
        return results;
    }
}