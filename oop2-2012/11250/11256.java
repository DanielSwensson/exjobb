import java.util.Scanner;

public class Smycken extends Pryl {
 
    private String smyckesnamn;
    private String material;
    private int antalädelstenar;
 
    Smycken (String smyckesnamn, String material, int antalädelstenar) {
        this.smyckesnamn = smyckesnamn;
        this.material = material;
        this.antalädelstenar = antalädelstenar;  
    }
 
    public double getVärde(){
        int material = 0;
 
        if (this.material.equals("Guld")){
            material = 2000;
        }
        else if (this.material.equals("Silver")){
            material = 700;
        }
 
        double svärde = material + (antalädelstenar * 500);
        return svärde;
    }
    public String toString(){
        return smyckesnamn;
    }  
 
}
