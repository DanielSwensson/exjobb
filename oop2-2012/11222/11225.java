package huvudprogram;

import java.util.ArrayList;
import java.util.Scanner;

public class Huvudprogram {

    private ArrayList<Person> alla = new ArrayList<Person>();
    Scanner scan = new Scanner(System.in);

    public Huvudprogram() {
        System.out.println("Hej och välkommen till prylprogrammet");
    }

    private void kör() {
        for (;;) {
            int val = readInt("Ange kommando 1-7: ");
            switch (val) {

                case 1:
                    skapaPerson();
                    break;
                case 2:
                    skapaPryl();
                    break;
                case 3:
                    visaAlla();
                    break;
                case 4:
                    visaRikaste();
                    break;
                case 5:
                    visaVissPerson();
                    break;
                case 6:
                    borskrasch();
                    break;
                case 7:
                    System.out.println("Tack och hej då!");
                    System.exit(0);
                default:
                    System.out.println("Fel kommando");
            }
        }
    }

    Person getPerson(String namn) {//Skapa getMetod i huvudklassen som ligger utanför metoden skapa person.
        for (Person p : alla) {
            if (p.getNamn().equalsIgnoreCase(namn)) {
                return p;
            }
        }
        return null;
    }

    void skapaPerson() {//Skapar en person och jämför med namnen i registret för att undvika redundans.
        String namn = readString("Ny persons namn: ");
        Person p = getPerson(namn);
        if (p != null) {
            System.out.println("Den personen finns redan");
        } else {
            Person ny = new Person(namn);
            alla.add(ny);
            System.out.println("Personen är registrerad");
        }
    }

    void skapaPryl() {
        String namn = readString("Vilken person äger prylen?: ");
        boolean hittad = false;
        Person rattPerson = null;
        for (Person p : alla) {
            if (p.getNamn().equalsIgnoreCase(namn)) {
                rattPerson = p;
                hittad = true;
            }
        }
        if (hittad) {
            String Pryl = readString("Vilken sorts pryl?: ");
            if (Pryl.equalsIgnoreCase("Smycke")) {
                String smycke = readString("Vilket sorts smycke?: ");
                String guld = readString("Är smycket av guld?: ");
                int adelsten = readInt("Antal ädelstenar?: ");
                rattPerson.prylsamling.add(new Smycke(smycke, guld, adelsten));
            } else if (Pryl.equalsIgnoreCase("Apparat")) {
                String apparat = readString("Vilket sorts apparat?: ");
                int inkopspris = readInt("Vad låg inköpspriset på?: ");
                int slitage = readInt("Hur sliten är apparaten på skala 1-10(1 = mycket sliten, 10 = nyinköpt)?: ");
                rattPerson.prylsamling.add(new Apparat(apparat, inkopspris, slitage));
            } else if (Pryl.equalsIgnoreCase("Aktie")) {
                String aktie = readString("Vilket sorts aktie?: ");
                int pris = readInt("Vad är aktiens pris?: ");
                int antal = readInt("Antalet aktier?: ");
                rattPerson.prylsamling.add(new Aktie(aktie, antal, pris));
            } else {
                System.out.println("Denna pryl kan inte läggas till i registret!");
            }
        } else {
            System.out.println("Personen du vill tilldela en pryl, finns inte i registret!");
        }
    }

    void visaAlla() {
        int i = 0;
        System.out.println("I registret finns: ");
        for (Person p : alla) {
            System.out.print(++i + ". " + p.getNamn() + "  ");
            System.out.println(p.getTotaltVarde());
        }
    }

    void visaRikaste() {
        Person rikast = alla.get(0);
        for (Person p : alla) {
            if (p.getRikast() > rikast.getRikast()) {
                rikast = p;
            }
        }
        System.out.print(rikast);
        System.out.print("\n");
        System.out.print(rikast.getPrylar());
    }

    void visaVissPerson() {

        String namn = readString("Vilken person vill du visa?: ");
        Person p = getPerson(namn);

        if (p != null) {
            System.out.println(p);
            System.out.println(p.getPrylar());

        } else {
            System.out.print("Den personen finns inte i registret!");
        }
    }

    void borskrasch() {

        for (Person p : alla) {
            p.krasch();
        }

        System.out.println("Börskrasch!");
    }

    public int readInt(String fraga) {
        for (;;) {
            try {
                System.out.print(fraga);
                int x = Integer.parseInt(scan.nextLine());
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Fel - skall vara numeriskt värde");
            }
        }
    }

    public String readString(String fraga) {
        System.out.print(fraga);
        String str = scan.nextLine();
        return str;
    }

    public static void main(String[] args) {
        Huvudprogram hp = new Huvudprogram();
        hp.kör();

    }
}
