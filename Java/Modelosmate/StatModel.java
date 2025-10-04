import java.util.ArrayList;

public class StatModel extends Model {
    protected boolean typeSample;

    public StatModel(String nombre, boolean typeSample) {
        super(nombre);
        this.typeSample = typeSample;
    }
//Estos 3 calculos son utiles, sin importar el tipo de modelo estadistico
    protected double calcMean(ArrayList<Double> data) {
        double sum = 0;
        for (double d : data) {
            sum += d;
        }
        return sum / data.size();
    }

    protected double calcStdDev(ArrayList<Double> data) {
        double mean = calcMean(data);
        double sum = 0;
        for (double d : data) {
            sum += (d - mean) * (d - mean);
        }
        double var = sum / (typeSample ? data.size() - 1 : data.size());
        return Math.sqrt(var); //implementacion del calculo de la desviación estándar
    }

    protected double calcVarCoeff(ArrayList<Double> data) {
        double mean = calcMean(data);
        if (mean == 0) {
            throw new IllegalArgumentException("Division por cero, no es posible con una media de 0.");
        }
        return calcStdDev(data) / mean;
    }

    @Override
    public ArrayList<Double> calculate(ArrayList<Double> params) {
        if (params.isEmpty() || (typeSample && params.size() == 1)) {
            throw new IllegalArgumentException("Tamaño no válido");
        }
        ArrayList<Double> results = new ArrayList<>();
        results.add(calcMean(params));
        results.add(calcStdDev(params));
        results.add(calcVarCoeff(params));
        outs = results;
        return results;
    }
}