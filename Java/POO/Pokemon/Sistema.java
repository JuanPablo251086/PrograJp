public class Sistema

{
    Narrador narrador = new Narrador();
    double PE1;
    double PE2;
    private Generador generador = new Generador();
    //Interacciones de tipos:
    public int efectuarTipos(Pokemon poke1, Pokemon poke2)
    {
        String atacante = poke1.getTipo();
        String defensor = poke2.getTipo();
    // Ventajas (eficaz)
        if (atacante.equals("Fire") && (defensor.equals("Grass") || defensor.equals("Ice") || defensor.equals("Bug"))) {
            return 15;
        } else if (atacante.equals("Water") && (defensor.equals("Fire") || defensor.equals("Rock") || defensor.equals("Ground"))) {
            return 15;
        } else if (atacante.equals("Grass") && (defensor.equals("Water") || defensor.equals("Rock") || defensor.equals("Ground"))) {
            return 15;
        } else if (atacante.equals("Electric") && (defensor.equals("Water") || defensor.equals("Flying"))) {
            return 15;
        } else if (atacante.equals("Ice") && (defensor.equals("Grass") || defensor.equals("Ground") || defensor.equals("Flying") || defensor.equals("Dragon"))) {
            return 15;
        } else if (atacante.equals("Fighting") && (defensor.equals("Normal") || defensor.equals("Ice") || defensor.equals("Rock"))) {
            return 15;
        } else if (atacante.equals("Poison") && defensor.equals("Grass")) {
            return 15;
        } else if (atacante.equals("Ground") && (defensor.equals("Fire") || defensor.equals("Electric") || defensor.equals("Poison") || defensor.equals("rock"))) {
            return 15;
        } else if (atacante.equals("Flying") && (defensor.equals("Grass") || defensor.equals("Fighting") || defensor.equals("Bug"))) {
            return 15;
        } else if (atacante.equals("Psychic") && (defensor.equals("Fighting") || defensor.equals("Poison"))) {
            return 15;
        } else if (atacante.equals("Bug") && (defensor.equals("Grass") || defensor.equals("Psychic"))) {
            return 15;
        } else if (atacante.equals("Rock") && (defensor.equals("Fire") || defensor.equals("Ice") || defensor.equals("Flying") || defensor.equals("Bug"))) {
            return 15;
        } else if (atacante.equals("Ghost") && defensor.equals("Psychic")) {
            return 15;
        } else if (atacante.equals("Dragon") && defensor.equals("Dragon")) {
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

        int ventaja = 0;
        ventaja = efectuarTipos(p1,p2);
        ventaja = ventaja + efectuarTipos(p2,p1);
        if (ventaja != 0) {
        System.out.println("Es supereficaz!");
        }
        

        boolean p1_suerte = generador.generarN(1,10) > 3 ? true : false;
        boolean p2_suerte = generador.generarN(1,10) > 3 ? true : false;

        if (p1_suerte == true) { 
            narrador.narrarAtaqueEspecial(p1);
            PE1 = PE1 + p1.getAtaqueEspecial();
            switch(p1.getEfectoE()) {
            case "debuffA":
                p2.setAtaque(p2.getAtaque()-15);
                break;
            case "DebuffD":
                p2.setDefensa(p2.getDefensa()-15);
                break;
            case "buffA":
                p1.setAtaque(p1.getAtaque()+15);
            case "buffD":
                p1.setAtaque(p1.getAtaque()+15);
            default:
            }
        } else {
                narrador.narrarAtaqueNormal(p1);
                PE1 = PE1 + p1.getAtaque();
        }
            
        
            if (p2_suerte == true){
        
            narrador.narrarAtaqueEspecial(p2);
            PE2 = PE2 + p2.getAtaqueEspecial();
            switch(p2.getEfectoE()) {
            case "debuffA":
                p1.setAtaque(p1.getAtaque()-15);
                break;
            case "DebuffD":
                p1.setDefensa(p1.getDefensa()-15);
                break;
            case "buffA":
                p2.setAtaque(p2.getAtaque()+15);
            case "buffD":
                p2.setAtaque(p2.getAtaque()+15);
            default:
                System.out.println(p2.getEfectoE() + "j2");
            }
        } else {
                narrador.narrarAtaqueNormal(p2);
                PE2 = PE2 + p2.getAtaque();
        }
    
        PE1 = PE1 - p2.getDefensa() + ventaja;
        PE2 = PE2 - p1.getDefensa() + ventaja;
    
    if (PE1 > PE2) {
        return(p1);
} else {
    return(p2);
}
    }
}