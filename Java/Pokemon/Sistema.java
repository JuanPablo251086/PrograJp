public class Sistema

{
    double PE1;
    double PE2;
    private Generador generador = new Generador();
    //Interacciones de tipos:
    public int efectuarTipos(Pokemon poke1, Pokemon poke2)
    {
        String atacante = poke1.getTipo();
        String defensor = poke2.getTipo();
    // Ventajas (eficaz)
        if (atacante.equals("fire") && (defensor.equals("grass") || defensor.equals("ice") || defensor.equals("bug"))) {
            return 15;
        } else if (atacante.equals("water") && (defensor.equals("fire") || defensor.equals("rock") || defensor.equals("ground"))) {
            return 15;
        } else if (atacante.equals("grass") && (defensor.equals("water") || defensor.equals("rock") || defensor.equals("ground"))) {
            return 15;
        } else if (atacante.equals("electric") && (defensor.equals("water") || defensor.equals("flying"))) {
            return 15;
        } else if (atacante.equals("ice") && (defensor.equals("grass") || defensor.equals("ground") || defensor.equals("flying") || defensor.equals("dragon"))) {
            return 15;
        } else if (atacante.equals("fighting") && (defensor.equals("normal") || defensor.equals("ice") || defensor.equals("rock"))) {
            return 15;
        } else if (atacante.equals("poison") && defensor.equals("grass")) {
            return 15;
        } else if (atacante.equals("ground") && (defensor.equals("fire") || defensor.equals("electric") || defensor.equals("poison") || defensor.equals("rock"))) {
            return 15;
        } else if (atacante.equals("flying") && (defensor.equals("grass") || defensor.equals("fighting") || defensor.equals("bug"))) {
            return 15;
        } else if (atacante.equals("psychic") && (defensor.equals("fighting") || defensor.equals("poison"))) {
            return 15;
        } else if (atacante.equals("bug") && (defensor.equals("grass") || defensor.equals("psychic"))) {
            return 15;
        } else if (atacante.equals("rock") && (defensor.equals("fire") || defensor.equals("ice") || defensor.equals("flying") || defensor.equals("bug"))) {
            return 15;
        } else if (atacante.equals("ghost") && defensor.equals("psychic")) {
            return 15;
        } else if (atacante.equals("dragon") && defensor.equals("dragon")) {
            return 15;
        }


        else if (atacante.equals("fire") && (defensor.equals("fire") || defensor.equals("water") || defensor.equals("rock") || defensor.equals("dragon"))) {
            return -15;
        } else if (atacante.equals("water") && (defensor.equals("water") || defensor.equals("grass") || defensor.equals("dragon"))) {
            return -15;
        } else if (atacante.equals("grass") && (defensor.equals("fire") || defensor.equals("grass") || defensor.equals("poison") || defensor.equals("flying") || defensor.equals("bug") || defensor.equals("dragon"))) {
            return -15;
        } else if (atacante.equals("electric") && (defensor.equals("electric") || defensor.equals("grass") || defensor.equals("dragon") || defensor.equals("ground"))) {
            return -15;
        } else if (atacante.equals("ice") && (defensor.equals("fire") || defensor.equals("water") || defensor.equals("ice"))) {
            return -15;
        } else if (atacante.equals("fighting") && (defensor.equals("poison") || defensor.equals("flying") || defensor.equals("psychic") || defensor.equals("bug"))) {
            return -15;
        } else if (atacante.equals("poison") && (defensor.equals("poison") || defensor.equals("ground") || defensor.equals("rock") || defensor.equals("ghost"))) {
            return -15;
        } else if (atacante.equals("ground") && (defensor.equals("grass") || defensor.equals("bug"))) {
            return -15;
        } else if (atacante.equals("flying") && (defensor.equals("electric") || defensor.equals("rock"))) {
            return -15;
        } else if (atacante.equals("psychic") && defensor.equals("psychic")) {
            return -15;
        } else if (atacante.equals("bug") && (defensor.equals("fire") || defensor.equals("fighting") || defensor.equals("poison") || defensor.equals("flying") || defensor.equals("ghost"))) {
            return -15;
        } else if (atacante.equals("rock") && (defensor.equals("fighting") || defensor.equals("ground"))) {
            return -15;
        } else if (atacante.equals("ghost") && defensor.equals("normal")) {
            return -15; 
        } else if (atacante.equals("dragon") && defensor.equals("ice")) {
            return -15; 
        }
        else {
            return 0;
        }
    }
public Pokemon efectuarRonda(Pokemon p1, Pokemon p2)
    {


        int ventaja = efectuarTipos(p1,p2);
        ventaja = ventaja + efectuarTipos(p2,p1);

        boolean p1_suerte = generador.generarN(1,10) > 3 ? true : false;
        boolean p2_suerte = generador.generarN(1,10) > 3 ? true : false;

        if (p1_suerte == true) { 
            PE1 = PE1 + p1.getAtaqueEspecial();
            switch(p1.getEfectoE()) {
            case "debuffA":
                p2.setAtaque(p2.getAtaque()-15);
                break;
            case "DebufffD":
                p2.setDefensa(p2.getDefensa()-15);
                break;
            case "buffA":
                p1.setAtaque(p1.getAtaque()+15);
            case "buffD":
                p1.setAtaque(p1.getAtaque()+15);
            default:
                System.out.println("error, no se efectuo el efecto especial.");
            }
            
        }
            if (p2_suerte == true){
        {
            PE2 = PE2 + p2.getAtaqueEspecial();
            switch(p2.getEfectoE()) {
            case "debuffA":
                p1.setAtaque(p1.getAtaque()-15);
                break;
            case "DebufffD":
                p1.setDefensa(p1.getDefensa()-15);
                break;
            case "buffA":
                p2.setAtaque(p2.getAtaque()+15);
            case "buffD":
                p2.setAtaque(p2.getAtaque()+15);
            default:
                System.out.println("error, no se efectuo el efecto especial.");
            }
        }
    }
    PE1 = p1.getAtaque() - p2.getDefensa() + ventaja;
    PE2 = p2.getAtaque() - p1.getDefensa() + ventaja;
    
    if (PE1 > PE2) {
        return(p1);
} else {
    return(p2);
}
    }
}