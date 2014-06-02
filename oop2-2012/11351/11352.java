package prylregister;
 
public class Aktie extends Pryl{
    private int antal;
    private int pris;   
 
    public Aktie(String na, int an, int pr){
       super(na);
       antal = an;
       pris = pr;
   }
 
    public int värde(){
        return antal * pris;
   }
 
    void setPris(int nyPris){
        pris = nyPris;
    }
 
    public String toString(){
        String str = namn+" (aktie, "+värde()+" kr)"; 
        return str;
    }
}