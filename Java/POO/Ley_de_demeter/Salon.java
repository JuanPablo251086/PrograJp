public class Salon {
    private Bombilla foco = new Bombilla();
    public void entrar() {
        this.foco.encender();
        System.out.println("entraste al salon");
    }
    public Bombilla getFoco(){
        return(this.foco);
    }
}