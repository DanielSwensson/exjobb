package Projekt;
public class Spindel extends Djur {
    private int antalTaggar;
    private double mängdGift;
    
    public Spindel(String namn, int vikt, int antalTaggar, double mängdGift){
        super(namn, vikt);
        this.antalTaggar = antalTaggar;
        this.mängdGift = mängdGift;
    }
    
    public double attackStyrka(){
        return returneraVikt() + 27 * antalTaggar + 22 * mängdGift;
    }
    
    public String toString(){
        return "\n" + returneraNamnStora() + "\nEn obehaglig spindel som väger " + returneraVikt() + " gram och sprutar in " + mängdGift + " milligram gift i offret vid varje bett. \nHar " + antalTaggar + " spetsiga taggar över hela kroppen, samt en total attackstyrka på " + attackStyrka() + ".\n";
    }
    
    public void ändraAttribut(int offer){
        ändraVikt(offer);
        antalTaggar = antalTaggar + offer;
        mängdGift = mängdGift + (offer * 0.1);
        System.out.print("\nLyckad jakt! " + offer + " insekter blev middag! " + returneraNamn() + " har ökat sin vikt, är nu utrustad med fler taggar, alstrar mer mängd gift per bett samt har ökat attackstyrkan!");
    }
}