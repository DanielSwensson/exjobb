import java.util.Scanner;

public class Apparater extends Pryl {
 
    private String apparatnamn;
    private double slitage;
    private double inköpspris;
 
 
    Apparater (String apparatnamn, double slitage, double inköpspris) {
        this.apparatnamn = apparatnamn;
        this.slitage = slitage;
        this.inköpspris = inköpspris;
    }
 
    public double getVärde(){
        double apvärde = (slitage * 0.1) * inköpspris;
        return apvärde;
    }
 
    public String toString(){
        return apparatnamn;
    }  
 
}