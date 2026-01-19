public class celda{
    private boolean tieneBarco, disparada;
    public celda()
    {
        this.tieneBarco = false;
        this.disparada = false;
    }
    public void ponerBarco()
    {
        this.tieneBarco = true;
    }
    public boolean estaDisparada()
    {
        return this.disparada;
    }
    public void disparar()
    {
        this.disparada = true;
    }
    public String toString()
    {
        if (this.disparada && this.tieneBarco){
            return("X");
        }else if
            this.disparada == false && this.tieneBarco{
            return(".")
        }else if 
            this.disparada == false && this.tieneBarco {
            return (".")
        } else if 
            this.disparada == true && this.tieneBarco == false{
            return ("O")
        }
        
        
    }
}