import java.util.Scanner;

public class Apparater extends Pryl {
 
    private String apparatnamn;
    private double slitage;
    private double ink�pspris;
 
 
    Apparater (String apparatnamn, double slitage, double ink�pspris) {
        this.apparatnamn = apparatnamn;
        this.slitage = slitage;
        this.ink�pspris = ink�pspris;
    }
 
    public double getV�rde(){
        double apv�rde = (slitage * 0.1) * ink�pspris;
        return apv�rde;
    }
 
    public String toString(){
        return apparatnamn;
    }  
 
}