package Projekt;
public class Haj extends Djur {
    private int antalTänder;
    private double simHastighet;
    private int längd;
    
    public Haj(String namn, int vikt, int antalTänder, double simHastighet, int längd){
        super(namn, vikt);
        this.antalTänder = antalTänder;
        this.simHastighet = simHastighet;
        this.längd = längd;
    }
    
    public double attackStyrka(){
        return returneraVikt() + 2 * antalTänder + 4 * simHastighet + 1.2 * längd;
    }
  
    public String toString(){
        return "\n" + returneraNamnStora() + "\nEn " + längd + " meter lång haj som väger " + returneraVikt() + " kg och kan simma " + simHastighet + " meter på en sekund. \nHar " + antalTänder + " sylvassa tänder, och en total attackstyrka på " + attackStyrka() + ".\n";
    }
    
    public void ändraAttribut(int offer){
        ändraVikt(offer);
        antalTänder = antalTänder + offer;
        simHastighet = simHastighet + (offer * 0.2);
        System.out.print("\nLyckad jakt! " + offer + " småfiskar blev middag! " + returneraNamn() + "s vikt, antal tänder, simhastighet samt attackstyrka har ökat!");
    }
}