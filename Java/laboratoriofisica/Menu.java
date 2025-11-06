import java.util.Scanner;
public class Menu
{
    private boolean seguir = true;
    private Sistema sis;
    // public Menu()
    // {

    // }
    public Menu(Sistema s) {
        this.sis = s;
    }
    public void startmenu()
    {
        Scanner sc = new Scanner(System.in);
        while (seguir)
        {
            System.out.println("Menú Principal:");
            System.out.println("1. Agregar equipo");
            System.out.println("2. Ordenar equipos por consumo");
            System.out.println("3. Generar resumen de estados");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarEquipo(sc);
                    break;
                case 2:
                    ordenarEquipos(sc);
                    break;
                case 3:
                    sis.generarResumen();
                    break;
                case 4:
                    seguir = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }

    private void agregarEquipo(Scanner sc) {
        System.out.println("Seleccione tipo de equipo:");
        System.out.println("1. Generador");
        System.out.println("2. ForceSensor");
        System.out.println("3. SimCalor");
        System.out.println("4. PenduloEncoder");
        System.out.println("5. Oscilloscope");
        int tipoEquipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Tipo: ");
        String tipo = sc.nextLine();
        System.out.print("Características: ");
        String caracteristicas = sc.nextLine();
        System.out.print("Fabricante: ");
        String fabricante = sc.nextLine();
        System.out.print("Consumo: ");
        float consumo = sc.nextFloat();
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Equipo nuevo = null;
        switch (tipoEquipo) {
            case 1:
                nuevo = new Generador(nombre, tipo, caracteristicas, fabricante, consumo, id);
                break;
            case 2:
                nuevo = new ForceSensor(nombre, tipo, caracteristicas, fabricante, consumo, id);
                break;
            case 3:
                nuevo = new SimCalor(nombre, tipo, caracteristicas, fabricante, consumo, id);
                break;
            case 4:
                nuevo = new PenduloEncoder(nombre, tipo, caracteristicas, fabricante, consumo, id);
                break;
            case 5:
                nuevo = new Oscilloscope(nombre, tipo, caracteristicas, fabricante, consumo, id);
                break;
            default:
                System.out.println("Tipo inválido.");
                return;
        }
        sis.addEquipo(nuevo);
        System.out.println("Equipo agregado.");
    }

    private void ordenarEquipos(Scanner sc) {
        System.out.println("Ordenar por consumo:");
        System.out.println("1. Mayor a menor");
        System.out.println("2. Menor a mayor");
        int orden = sc.nextInt();
        sc.nextLine();

        boolean mayor = (orden == 1);
        for (Equipo e : sis.getEquipos()) {
            e.setOrden(mayor);
        }
        sis.sort();
        System.out.println("Equipos ordenados.");
    }
}