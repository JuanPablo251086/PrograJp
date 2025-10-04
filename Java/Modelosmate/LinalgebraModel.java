import java.util.ArrayList;
//esta clase quedo un poco rota, estuvo un poco mas dificil de lo que imaginaba jaja. Al rato y tomo mas clases de lineal
public class LinalgebraModel extends Model {
    private ArrayList<double[]> subspaces; 

    public LinalgebraModel(String nombre) {
        super(nombre);
        subspaces = new ArrayList<>();
    }

    public double[] calcEigen(double[][] matrix) { //Solo lo pude hacer para 2x2, generalizarlo va requerir que estudie un poco más 
        if (matrix.length != 2 || matrix[0].length != 2 || matrix[1].length != 2) {
            throw new IllegalArgumentException("Solo es posible 2x2");
        }
        double a = matrix[0][0];
        double b = matrix[0][1];
        double c = matrix[1][0];
        double d = matrix[1][1];
        double trace = a + d;
        double det = a * d - b * c;
        double discriminant = trace * trace - 4 * det;
        if (discriminant < 0) {
            throw new RuntimeException("eigenvalores complejos no estan soportados por el momento");
        }
        double sqrtDisc = Math.sqrt(discriminant);
        return new double[]{(trace + sqrtDisc) / 2, (trace - sqrtDisc) / 2};
    }

    public void calcSpaces(double[][] matrix) {
        // Esto fue demasiado dificil, no me dio tiempo a implementarlo realmente
        subspaces.clear();
    }

    @Override
    public ArrayList<Double> calculate(ArrayList<Double> params) {
        if (params.size() != 4) {
            throw new IllegalArgumentException("Esta funcion requiere exactamente 4 paramentros");
        }
        double[][] matrix = {
            {params.get(0), params.get(1)},
            {params.get(2), params.get(3)}
        };
        double[] eigenvalues = calcEigen(matrix);
        calcSpaces(matrix);
        ArrayList<Double> results = new ArrayList<>();
        for (double ev : eigenvalues) {
            results.add(ev);
        }
        outs = results;
        return results;
    }
}