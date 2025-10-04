//Juan Pablo Castañeda 251086, POO Seccion 50(?)

import java.util.ArrayList;

public class Main {
    private Sistema sistema;

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() { //para mas info revisar el usermanual
        sistema = new Sistema();
        //Estos son algunos modelos de ejemplo que se van a instanciar en el menu, desde aquí se pueden personalizar con los respectivos parametros
        sistema.addModel(new StatModel("Modelo Estadistico (Muestra)", true)); //el boolean represetna en este caso muestra, poblacion es false
        sistema.addModel(new ProbModel("Modelo Probabilistico Simple", "simple"));
        sistema.addModel(new GeometryModel("Modelo Geometrico Rectangulo", "rectangle" )); //posibles: rectangle, circle, triangle
        sistema.addModel(new LinalgebraModel("Modelo Algebra Lineal (2x2)")); //2x2 es el que el programa soporta
        ArrayList<Double> linearCoeffs = new ArrayList<>();
        linearCoeffs.add(2.0); // Pendiente
        linearCoeffs.add(1.0); // Intercepto
        sistema.addModel(new LinearModel("Modelo Lineal", linearCoeffs));
        ArrayList<Double> expCoeffs = new ArrayList<>();
        expCoeffs.add(1.0); // a
        expCoeffs.add(0.5); // b
        sistema.addModel(new ExponentialModel("Modelo Exponencial", expCoeffs));
        ArrayList<Double> polyCoeffs = new ArrayList<>();
        polyCoeffs.add(3.0); // constante
        polyCoeffs.add(2.0); // x
        polyCoeffs.add(1.0); // x^2
        sistema.addModel(new PolynomialModel("Modelo Polinomial", polyCoeffs));

        //inicio
        sistema.getMenu().loop();
    }
}