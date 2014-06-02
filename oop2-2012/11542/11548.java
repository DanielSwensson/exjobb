package inlämningsuppgift2;

public class Smycken extends Prylar {

    private int antalÄdelstenar;
    private String smyckesTyp;

    Smycken(String namn, int antalÄdelstenar, String smyckesTyp) {
        super(namn);
        this.antalÄdelstenar = antalÄdelstenar;
        this.smyckesTyp = smyckesTyp;
    }

    public double värde() {
        if (smyckesTyp.equalsIgnoreCase("Guld")) { //Smycket är gjort utav guld
            värde = 2000 + (500 * antalÄdelstenar);
        } else if (smyckesTyp.equalsIgnoreCase("Silver")) { //Smycket är gjort utav silver
            värde = 700 + (500 * antalÄdelstenar);
        }
        return värde;
    }

    public int getAntalÄdelstenar() {
        return antalÄdelstenar;
    }

    public String getSmyckesTyp() {
        return smyckesTyp;
    }

    public String toString() {
        return getNamn() + "et har " + antalÄdelstenar + " antal ädelstenar, och är gjort utav " + smyckesTyp;
    }
}
