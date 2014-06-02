
import java.util.ArrayList;

public class Person {

    private String namn;
    private int totaltVärde;
    private ArrayList<Pryl> listaMedPrylar;

    Person(String namn) {
        this.namn = namn;
        listaMedPrylar = new ArrayList<Pryl>();
    }

    public String hämtaNamn() {
        return namn;
    }

    public void adderaPryl(Pryl p) {
        listaMedPrylar.add(p);
    }

    public void skrivUtPrylar() {
        for (Pryl p : listaMedPrylar) {
            System.out.println(p);
        }
    }

    public int hämtaTotaltVärde() {
        totaltVärde = 0;
        for (Pryl p : listaMedPrylar) {
            totaltVärde += p.hämtaVärde();
        }
        return totaltVärde;
    }

    public void nollställaAktier() {
        for (Pryl aktuell : listaMedPrylar) {
            if (aktuell instanceof Aktier) {
                Aktier a = (Aktier) aktuell;
                a.nollställaVärde();

            }
        }

    }
}