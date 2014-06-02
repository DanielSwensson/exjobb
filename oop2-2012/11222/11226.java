package huvudprogram;

import java.util.ArrayList;

public class Person {

    private String namn;
    private String pryl;
    protected ArrayList<Pryl> prylsamling = new ArrayList<Pryl>();

    public Person(String namn) {
        this.namn = namn;
    }

    public String getPerson() {
        return this.namn;//Metod är en funktion som kan användas för att returnera data från ett objekt.
    }

    public String getNamn() {
        return this.namn;
    }

    public void addPryl(Pryl p) {
        prylsamling.add(p);
    }

    public String getPrylar() {
        String utskrift = "";
        for (Pryl pr : prylsamling) {
            utskrift += "" + pr + "\n";
        }
        return utskrift;
    }

    public int getTotaltVarde() {
        int totaltVarde = 0;

        for (Pryl p : prylsamling) {
            totaltVarde += p.getVarde();
        }
        return totaltVarde;
    }

    public int getRikast() {
        int i = Integer.MAX_VALUE;
        i = getTotaltVarde();
        return getTotaltVarde();

    }

    public void krasch() {
        for (Pryl pr : prylsamling) {
            if (pr instanceof Aktie) {
                ((Aktie) pr).getKrasch();
            }
        }
    }

    public String toString() {
        return namn + " som sammanlagt äger " + getTotaltVarde();
    }
}
