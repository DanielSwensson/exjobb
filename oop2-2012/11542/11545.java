package inlämningsuppgift2;
//Titti Lagergrens inlÃ¤mningsuppgift 2 
import java.util.Scanner;
import java.util.ArrayList;

public class Huvudprogram {

    private ArrayList<Person> allaPersoner = new ArrayList<Person>();
    Scanner scan = new Scanner(System.in);

    public int readInt(String fråga) {
        for (;;) {
            try {
                System.out.print(fråga);
                int x = Integer.parseInt(scan.nextLine());
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Fel - skall vara numeriskt värde");
            }
        }
    }

    public String readString(String fråga) {
        System.out.print(fråga);
        String str = scan.nextLine();
        return str;
    }

    public Person getPerson(String namn) {
        for (Person p : allaPersoner) {
            if (p.getNamn().equalsIgnoreCase(namn)) {
                return p;
            }
        }
        return null;
    }

    public void tilldelaPrylTillPerson(Prylar pryl) {
        while (true) {
            String person = readString("Vilken person ska äga prylen? : ");
            for (int x = 0; x < allaPersoner.size(); x++) {
                if (allaPersoner.get(x).getNamn().equalsIgnoreCase(person)) {
                    allaPersoner.get(x).läggTillPryl(pryl);
                    System.out.println("Prylen har tilldelats en ägare");
                    return;
                }
            }
            System.out.println("Personen finns inte i registret, försök igen");
        }
    }

    public void skapaPerson() {
        String namn = readString("Nya personens namn: ");
        Person p = getPerson(namn);
        if (p != null) {
            System.out.println("Den personen finns redan ");
        } else {
            Person ny = new Person(namn);
            allaPersoner.add(ny);
        }
    }

    public void skapaPryl() {
        int vilken = readInt("Vilken sorts pryl vill du skapa (1=Smycke/2=Aktie/3=Apparat):"
                + "\nSe till att du skapat en person innan du skapar en pryl! ");
        switch (vilken) {

            case 1:
                String namnPåSmycke = readString("Vilken sorts smycke? ");
                int antalÄdelstenar = readInt("Antal ädelstenar? ");
                String smyckesTyp = readString("Är smycket gjort av guld eller silver? ");
                while (!smyckesTyp.equalsIgnoreCase("Guld") && !smyckesTyp.equalsIgnoreCase("Silver")) {
                    System.out.print("Felaktigt svar, försök igen: ");
                    smyckesTyp = scan.nextLine();
                }
                Smycken nyttSmycke = new Smycken(namnPåSmycke, antalÄdelstenar, smyckesTyp);
                tilldelaPrylTillPerson(nyttSmycke);
                break;

            case 2:
                String namnPåAktie = readString("Aktiens namn? ");
                int antalAktier = readInt("Antal aktier? ");
                int aktiensPris = readInt("Aktiens pris? ");
                Aktier nyAktie = new Aktier(namnPåAktie, antalAktier, aktiensPris);
                tilldelaPrylTillPerson(nyAktie);
                break;

            case 3:
                String namnPåApparat = readString("Vilken sorts apparat? ");
                int inköpspris = readInt("Vad är inköpspriset? ");
                int slitage = readInt ("Ange slitaget mellan 1-10? (där 1=väldigt sliten och 10=helt ny) ");
                Apparater nyApparat = new Apparater(namnPåApparat, inköpspris, slitage);
                tilldelaPrylTillPerson(nyApparat);
                break;

            default:
                System.out.println("Felaktigt kommando ");
                break;
        }
    }

    public void visaAlla() {
        System.out.println("Dessa personer finns registrerade ");
        for (int x = 0; x < allaPersoner.size(); x++) {
            System.out.println(allaPersoner.get(x).getNamn() + " " + allaPersoner.get(x).summaVärde());
        }
    }

    public void visaRikaste() {
        Person rikast = null;
        for (int x = 0; x < allaPersoner.size(); x++) {
            if (rikast == null) {
                rikast = allaPersoner.get(x);
            } else if (allaPersoner.get(x).summaVärde() > rikast.summaVärde()) {
                rikast = allaPersoner.get(x);
            }
        }
        System.out.println(rikast.getNamn() + rikast.getString());
        rikast.gåIgenomPrylarArrayList();
    }

    public void visaVissPerson() {
        String vem = readString("Vilken person vill du se? ");
        boolean personenFinns = false;
        for (int x = 0; x < allaPersoner.size(); x++) {
            if (allaPersoner.get(x).getNamn().equalsIgnoreCase(vem)) {
                System.out.println(allaPersoner.get(x).toString());
                allaPersoner.get(x).gåIgenomPrylarArrayList();
                personenFinns = true;
                break;
            }
        }
        if (!personenFinns) {
            System.out.println("Personen med det namnet fanns ej i registret");
        }
    }

    public void börskrasch() {
        for (int x = 0; x < allaPersoner.size(); x++) {
            allaPersoner.get(x).aktierNollställs();
        }
        System.out.println("Alla aktier i registret har fått priset 0!");
    }

    public static void main(String[] args) {
        Huvudprogram hp = new Huvudprogram();
        System.out.println("Hej och välkommen till Prylprogrammet! \n(1=Skapa person, 2=Skapa pryl, 3=Visa alla,"
                + " 4=Visa rikaste, 5=Visa viss person, 6=Börskrasch, 7=Avsluta)");
        for (;;) {
            int val = hp.readInt("Ange kommando 1-7: ");
            switch (val) {
                case 1:
                    hp.skapaPerson();
                    break;
                case 2:
                    hp.skapaPryl();
                    break;
                case 3:
                    hp.visaAlla();
                    break;
                case 4:
                    hp.visaRikaste();
                    break;
                case 5:
                    hp.visaVissPerson();
                    break;
                case 6:
                    hp.börskrasch();
                    break;
                case 7:
                    System.out.println("Tack och hej då!");
                    System.exit(0);

                default:
                    System.out.println("Fel kommando");
            }
        }
    }
}
