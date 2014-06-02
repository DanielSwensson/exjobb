import java.util.Scanner;

public class Aktier extends Pryl{
 
    private String aktienamn;
    private double aktieantal;
    private double aktiepris;
 
    Aktier (String aktienamn, double aktieantal, double aktiepris) {
        this.aktienamn = aktienamn;
        this.aktieantal = aktieantal;
        this.aktiepris = aktiepris;
    }
 
    public double getVärde(){
        double avärde = aktieantal * aktiepris;
        return avärde;
    }
   
   
    public void setVärde0(){
        aktiepris = 0;
    }
 
    public String toString(){
        return aktienamn;
 
    }  
}