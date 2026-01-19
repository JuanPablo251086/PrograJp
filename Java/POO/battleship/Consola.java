import java.util.Scanner;
public class Consola
{
    private final Scanner sc;

    public Consola() {
        this.sc = new Scanner();
    }

    private void print(String s) {
        System.out.print(s);
    }
    private void println(String s) {
        System.out.println(s);
    }

    public void mostrarBienvenida()
    {
        System.out.prinln("Bienvenido al juego de battlship");


    }
    public void dibujarTablero(Tablero t){
        int n = t.getN();

        print("  ");
        for (int i = 1; i <= n; i++){
            print(i + "");
            println("");


        for (int i =0; i < n; i++){
            print((char)('A'+ i) + " ");
            for (int j = 0; j < n; j++){
                print(t.getCelda(i,j)+ " ");
            }

            println("");
        }
        println("");
    }
    }
}