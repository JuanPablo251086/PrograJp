import java.util.Random;

public class Generador
{
    public int generarN(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min + 1)+ min;
    } 
}