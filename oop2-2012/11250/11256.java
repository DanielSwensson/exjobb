import java.util.Scanner;

public class Smycken extends Pryl {
 
    private String smyckesnamn;
    private String material;
    private int antal�delstenar;
 
    Smycken (String smyckesnamn, String material, int antal�delstenar) {
        this.smyckesnamn = smyckesnamn;
        this.material = material;
        this.antal�delstenar = antal�delstenar;  
    }
 
    public double getV�rde(){
        int material = 0;
 
        if (this.material.equals("Guld")){
            material = 2000;
        }
        else if (this.material.equals("Silver")){
            material = 700;
        }
 
        double sv�rde = material + (antal�delstenar * 500);
        return sv�rde;
    }
    public String toString(){
        return smyckesnamn;
    }  
 
}
