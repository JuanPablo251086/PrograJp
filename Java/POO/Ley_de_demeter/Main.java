public class Main {
    
    public static void main(String[] args){
        Salon salon = new Salon();
        salon.entrar(); //Esto esta bien
        salon.getFoco().apagar(); //Esto viola la ley de demeter
    }
}
    

