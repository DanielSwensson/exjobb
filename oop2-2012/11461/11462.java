public class Aktier extends Pryl{
    private int prisPerAktie;
    private int antal;
    
    Aktier(String namn, int prisPerAktie, int antal){
        super(namn);
        this.prisPerAktie = prisPerAktie;
        this.antal = antal;
    }
    public double hämtaVärde() {
        int värde = (antal * prisPerAktie);
        return värde;
    }
     public String toString(){
        return super.toString() + " Antal aktier: " + antal+ " Pris per aktie: "+ prisPerAktie + " Värde " + hämtaVärde() + " kr";
        
    }
     public void nollställaVärde(){
         prisPerAktie = 0;
     }
}