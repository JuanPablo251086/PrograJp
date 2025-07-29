import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Localidad localidad3 = new Localidad("Localidad 3", 20,100,3);
        //System.out.println(Localidad3);
        Localidad localidad5 = new Localidad("Localidad 5", 20,500,5);
        //System.out.println(Localidad5);
        Localidad localidad10 = new Localidad("Localidad 10", 20,1000,10);
        //System.out.println(Localidad10);
         SolicitudCompra nuevasolicitud = null;
        CompraActual pruebacompra = new CompraActual();
        //SolicitudCompra pruebasolicitud = new SolicitudCompra("", "", 0, 0);
        boolean unaflagporahi = false;
        System.out.println(pruebacompra.GenerarSuerte());

    Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Nuevo Comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción (1-6): ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                    System.out.print("Ingrese el nombre del comprador: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el correo electrónico: ");
                    String correo = scanner.nextLine();

                    System.out.print("Ingrese el presupuesto de pago: ");
                    double presupuesto = scanner.nextDouble();

                    System.out.print("Ingrese la cantidad de boletos: ");
                    int cantidad = scanner.nextInt();
                    nuevasolicitud = new SolicitudCompra(nombre, correo, presupuesto, cantidad);
                    System.out.println("Comprador registrado exitosamente");
                        break;
                    case 2:
                    CompraActual nuevaCompra = new CompraActual();
                    boolean exito = nuevaCompra.GenerarSuerte();

                    if ((nuevaCompra.GetLocalidad() == 0 && (localidad3.getDisponibilidad() - nuevasolicitud.getNumBoletos() > 0)) && exito == true) {
                        localidad3.compra((int)nuevasolicitud.getPresupuesto()/localidad3.getPrecio());
                        double cantidadcompradaalfinal = (int)nuevasolicitud.getPresupuesto()/localidad3.getPrecio();
                        System.out.println("La cantidad de boletos que compraste fue de: " + cantidadcompradaalfinal + " Y fuiste asignado a la localidad 3 ");


                    } else if ((nuevaCompra.GetLocalidad() == 1 && (localidad5.getDisponibilidad() - nuevasolicitud.getNumBoletos() > 0)) && exito == true) {
                        localidad5.compra((int)nuevasolicitud.getPresupuesto()/localidad5.getPrecio());
                        double cantidadcompradaalfinal = (int)nuevasolicitud.getPresupuesto()/localidad5.getPrecio();
                        System.out.println("La cantidad de boletos que compraste fue de: " + cantidadcompradaalfinal + " y fuiste asignado a la localidad 5 ");


                    } else if ((nuevaCompra.GetLocalidad() == 2 && (localidad10.getDisponibilidad() - nuevasolicitud.getNumBoletos() > 0)) && exito == true) {
                        localidad10.compra((int)nuevasolicitud.getPresupuesto()/localidad10.getPrecio());
                        double cantidadcompradaalfinal = (int)nuevasolicitud.getPresupuesto()/localidad10.getPrecio();
                        System.out.println("La cantidad de boletos que compraste fue de: " + cantidadcompradaalfinal + " y fuiste asignado a la localidad: 10 ");


                    }else{
                        System.out.println("No se compraron boletos. No ganaste la lotería, o no había la disponibilidad en la localidad para los boletos que solicitaste. Intenta de nuevo.");
                    }
                        break;
                    case 3:
                        System.out.println("Las ventas totales son de "+( localidad3.getPrecio()*localidad3.getVentas() + localidad5.getPrecio()*localidad5.getVentas() + localidad10.getPrecio()*localidad10.getVentas()));
                        System.out.println(localidad3);
                        System.out.println(localidad5);
                        System.out.println(localidad10);
                        break;
                    case 4:
                        System.out.println("Selecciona 1. Localidad 3,    2. Localidad 5,      3. localidad 10");
                        int opcionanidada = scanner.nextInt();
                        switch(opcionanidada) {
                        case 1:
                            System.out.println("Las ventas de esta localidad fueron de " + localidad3.getVentas());
                            break;
                        case 2:
                            System.out.println("Las ventas de esta localidad fueron de " + localidad5.getVentas());
                            break;
                        case 3:
                            System.out.println("Las ventas de esta localidad fueron de " + localidad10.getVentas());
                            break;
                        default:
                        }
                        break;
                    case 5:
                        System.out.println("Las ganancias totales fueron de: ");
                        System.out.println(localidad3.getGanancias() + localidad5.getGanancias() + localidad10.getGanancias() );
                        break;
                    case 6:
                        System.out.println("-> Saliendo del sistema...");
                        break;
                    default:
                }
            } else {
                System.out.println("** Entrada no válida. Por favor, ingrese un número entero. **");
            }
        }

        scanner.close();
    }
}

    

