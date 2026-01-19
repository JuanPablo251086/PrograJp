import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Sistema sistema;

    public Menu(Sistema sistema) {
        this.sistema = sistema;
        this.scanner = new Scanner(java.lang.System.in);
    }
//lo hice como lista no se pq jaja
    public void loop() {
        boolean running = true;
        while (running) {
            sistema.getVista().Display("Menu de Modelos:");
            ArrayList<Model> models = sistema.getModelos();
            for (int i = 0; i < models.size(); i++) {
                sistema.getVista().Display((i + 1) + ". " + models.get(i).nombre);
            }
            sistema.getVista().Display("0. Salir");
            sistema.getVista().Display("Elija una opcion: ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                running = false;
                continue;
            }
            if (choice < 1 || choice > models.size()) {
                sistema.getVista().Display("Opcion invalida.");
                continue;
            }
            Model model = models.get(choice - 1);
            sistema.getVista().Display("Ingrese el numero de parametros para " + model.nombre + ": "); //si mejorara mi programa probablemente cambiaría la implementación que hice de esto.
            int numParams = scanner.nextInt();
            ArrayList<Double> params = new ArrayList<>();
            for (int i = 0; i < numParams; i++) {
                sistema.getVista().Display("Parametro " + (i + 1) + ": ");
                params.add(scanner.nextDouble());
            }
            sistema.run(model, params);
        }
        scanner.close();
    }
}