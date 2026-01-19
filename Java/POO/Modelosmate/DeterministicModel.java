import java.util.ArrayList;

public abstract class DeterministicModel extends Model {
    public DeterministicModel(String nombre) {
        super(nombre);
    }

    protected abstract String equation();
}