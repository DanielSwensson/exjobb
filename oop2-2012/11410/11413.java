package Projekt;
import java.text.DecimalFormat;
public class Lejon extends Djur {
    private int mängdMuskler;
    
    public Lejon(String namn, int vikt, int mängdMuskler){
        super(namn, vikt);
        this.mängdMuskler = mängdMuskler;
    }
    
    public double attackStyrka(){
        return returneraVikt() + 9 * mängdMuskler; 
    }
    
    public String procentMuskler(){
        DecimalFormat format = new DecimalFormat("###.00");
        return format.format(((double)mängdMuskler / (double)returneraVikt() * 100));
    }
    
    public String toString(){
        return "\n" + returneraNamnStora() + "\nEn konung av djungeln med sina " + returneraVikt() + " kg, varav " + procentMuskler() + " % av vikten består av ren muskelvävnad. \nAttackstyrkan ligger på " + attackStyrka() + ".\n";
    }
    
    public void ändraAttribut(int offer){
        ändraVikt(offer);
        mängdMuskler = mängdMuskler + offer;
        System.out.print("\nLyckad jakt! " + offer + " däggdjur blev middag! " + returneraNamn() + " har ökat i vikt, byggt på sig lite muskler, samt ökat attackstyrkan!");
    }
}