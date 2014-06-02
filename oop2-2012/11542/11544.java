package inlämningsuppgift2;

public class Apparater extends Prylar {

    private int inköpspris;
    private int slitage;

    Apparater(String namn, int inköpspris, int slitage) {
        super(namn);
        this.inköpspris = inköpspris;
        this.slitage = slitage;
    }

    public double värde() {
        if (slitage == 10) {
            värde = inköpspris;
        } else if (slitage == 9) {
            värde = inköpspris * 0.90;
        } else if (slitage == 8) {
            värde = inköpspris * 0.80;
        } else if (slitage == 7) {
            värde = inköpspris * 0.70;
        } else if (slitage == 6) {
            värde = inköpspris * 0.60;
        } else if (slitage == 5) {
            värde = inköpspris * 0.50;
        } else if (slitage == 4) {
            värde = inköpspris * 0.40;
        } else if (slitage == 3) {
            värde = inköpspris * 0.30;
        } else if (slitage == 2) {
            värde = inköpspris * 0.20;
        } else if (slitage == 1) {
            värde = inköpspris * 0.10;
        }
        return värde;
    }

    public int getInköpspris() {
        return inköpspris;
    }

    public int getSlitage() {
        return slitage;
    }

    public String toString() {
        return getNamn() + "apparaten har inköpspriset " + inköpspris + " kr, och slitaget " + slitage;
    }
}
