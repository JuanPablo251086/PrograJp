import java.util.ArrayList;

public class GeometryModel extends Model {
    private String shapeType;

    public GeometryModel(String nombre, String shapeType) {
        super(nombre);
        this.shapeType = shapeType;
    }

    @Override
    public ArrayList<Double> calculate(ArrayList<Double> params) { //posibles modelos geometricos que se pueden instanciar acorde a la necesidad
        double area;
        switch (shapeType) {
            case "circle":
                if (params.size() != 1) {
                    throw new IllegalArgumentException("El círuclo solo requiere un parámetro, el radio");
                }
                double radius = params.get(0);
                if (radius <= 0) {
                    throw new IllegalArgumentException("El radio debe ser positivo");
                }
                area = Math.PI * radius * radius;
                break;
            case "rectangle":
                if (params.size() != 2) {
                    throw new IllegalArgumentException("El rectángulo requiere solo base y altura");
                }
                double length = params.get(0);
                double width = params.get(1);
                if (length <= 0 || width <= 0) {
                    throw new IllegalArgumentException("Error, ingresa positivos");
                }
                area = length * width;
                break;
            case "triangle":
                if (params.size() != 2) {
                    throw new IllegalArgumentException("El triángulo requiere dos parámetros, base y altura");
                }
                double base = params.get(0);
                double height = params.get(1);
                if (base <= 0 || height <= 0) {
                    throw new IllegalArgumentException("Error, ingresa positivos");
                }
                area = 0.5 * base * height;
                break;
            default:
                throw new UnsupportedOperationException("No se reconocio el tipo de figura");
        }
        ArrayList<Double> results = new ArrayList<>();
        results.add(area);
        outs = results;
        return results;
    }
}