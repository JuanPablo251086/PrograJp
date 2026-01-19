public class Main
{
    public static void main(String[] args)
    {
        Sistema sistema = new Sistema();
        
        // Inicializar uno de cada equipo con datos de ejemplo
        Equipo generador = new Generador("Generador1", "TipoGenerador", "Caracteristicas del generador", "FabricanteA", 150.0f, 1);
        sistema.addEquipo(generador);
        
        Equipo forceSensor = new ForceSensor("ForceSensor1", "TipoSensorFuerza", "Caracteristicas del sensor de fuerza", "FabricanteB", 50.0f, 2);
        sistema.addEquipo(forceSensor);
        
        Equipo simCalor = new SimCalor("SimCalor1", "TipoSimuladorCalor", "Caracteristicas del simulador de calor", "FabricanteC", 80.0f, 3);
        sistema.addEquipo(simCalor);
        
        Equipo penduloEncoder = new PenduloEncoder("PenduloEncoder1", "TipoPenduloEncoder", "Caracteristicas del pendulo encoder", "FabricanteD", 120.0f, 4);
        sistema.addEquipo(penduloEncoder);
        
        Equipo oscilloscope = new Oscilloscope("Oscilloscope1", "TipoOsciloscopio", "Caracteristicas del osciloscopio", "FabricanteE", 200.0f, 5);
        sistema.addEquipo(oscilloscope);
        
        sistema.startmenus();
    }
}