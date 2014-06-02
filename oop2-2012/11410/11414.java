package Projekt;
public class Orm extends Djur {
    private double mängdGift;
    
    public Orm(String namn, int vikt, double mängdGift){
        super(namn, vikt);
        this.mängdGift = mängdGift;
    }
    
    public double attackStyrka(){
        return returneraVikt() + 29 * mängdGift;
    }
    
    public String toString(){
        return "\n" + returneraNamnStora() + "\nEn listig orm på " + returneraVikt() + " kg. Vid varje bett överför den " + mängdGift + " milligram supergiftig substans till offret. \nAttackstyrka: " + attackStyrka() + ".\n";
    }
    
    public void ändraAttribut(int offer){
        ändraVikt(offer);
        mängdGift = mängdGift + (offer * 0.1);
        System.out.print("\nLyckad jakt! " + offer + " möss och kaniner blev middag! " + returneraNamn() + " har ökat sin vikt, alstrar nu mer mängd gift per bett, samt har utvecklat attackstyrkan!");
    }
}