package inlämningsuppgift2;

public class Aktier extends Prylar {

    private int antalAktier;
    private int pris;

    Aktier(String namn, int antalAktier, int pris) {
        super(namn);
        this.antalAktier = antalAktier;
        this.pris = pris;
    }

    public double värde() {
        värde = antalAktier * pris;
        return värde;
    }

    public int getAntalAktier() {
        return antalAktier;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int newPris) {
        pris = newPris;
    }

    public String toString() {
        return "Aktien " + getNamn() + " har antalet " + getAntalAktier() + ". Varje aktie har priset " + getPris() + "kr";
    }
}
