package inlämningsuppgift2;

import java.util.ArrayList;

public class Person {

    private String namn;
    private ArrayList<Prylar> allaPrylar = new ArrayList<Prylar>();

    Person(String namn) {
        this.namn = namn;
    }

    public String getNamn() {
        return namn;
    }

    public void gåIgenomPrylarArrayList() {
        for (int x = 0; x < allaPrylar.size(); x++) {
            System.out.println(allaPrylar.get(x).getNamn() + " " + allaPrylar.get(x).getVärde());
        }
    }

    public void läggTillPryl(Prylar pryl) {
        allaPrylar.add(pryl);
    }

    public int summaVärde() {
        int summa = 0;
        for (Prylar aktuell : allaPrylar) {
            summa += aktuell.värde();
        }
        return summa;
    }

    public void aktierNollställs() {
        boolean prylÄrAktie = false;
        for (int x = 0; x < allaPrylar.size(); x++) {
            if (allaPrylar.get(x) instanceof Aktier) {
                ((Aktier) allaPrylar.get(x)).setPris(0);
                prylÄrAktie = true;
                break;
            }
        }
        if (!prylÄrAktie) {
        }
    }

    public String toString() {
        return namn + " äger prylarna: ";
    }

    public String getString() {
        return " är rikast som äger prylar med sammanlagt värde " + summaVärde();
    }
}
