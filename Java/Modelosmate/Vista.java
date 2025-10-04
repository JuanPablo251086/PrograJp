import java.util.ArrayList;

public class Vista {
    public void Display(String message) {
        System.out.println(message);
    }

    public void Display(ArrayList<?> args) {
        System.out.print("Resultados: ");
        for (Object obj : args) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public void MatrixForm(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}