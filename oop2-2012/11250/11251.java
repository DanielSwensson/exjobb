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
 
    public double getV�rde(){
        double av�rde = aktieantal * aktiepris;
        return av�rde;
    }
   
   
    public void setV�rde0(){
        aktiepris = 0;
    }
 
    public String toString(){
        return aktienamn;
 
    }  
}