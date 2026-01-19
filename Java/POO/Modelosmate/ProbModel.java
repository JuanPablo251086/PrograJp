//se podría considerar su implementacion como una simplificacion de stat. 

import java.util.ArrayList;

public class ProbModel extends Model {
    private String distType;

    public ProbModel(String nombre, String distType) {
        super(nombre);
        this.distType = distType;
    }

    @Override
    public ArrayList<Double> calculate(ArrayList<Double> params) {
        if (!"simple".equals(distType)) {
            throw new UnsupportedOperationException("Only simple probability supported");
        }
        if (params.size() != 2) {
            throw new IllegalArgumentException("Simple probability requires exactly 2 parameters: favorable and total");
        }
        double favorable = params.get(0);
        double total = params.get(1);
        if (favorable < 0 || total <= 0 || favorable > total) {
            throw new IllegalArgumentException("Invalid probability parameters");
        }
        ArrayList<Double> results = new ArrayList<>();
        results.add(favorable / total);
        outs = results;
        return results;
    }
}