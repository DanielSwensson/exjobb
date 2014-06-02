
import java.util.ArrayList;
import java.util.Scanner;

public class Huvudprogram {

    private static ArrayList<Person> listaMedPersoner = new ArrayList<Person>();
    private static Scanner tangentbord = new Scanner(System.in);

    public static int läsaInInt(String fråga) {
        for (;;) {
            try {
                System.out.println(fråga);
                int x = Integer.parseInt(tangentbord.nextLine());
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Fel! Svaret måste vara ett heltal, försök igen.");
            }
        }
    }

    public static String läsaInString(String fråga) {;
        System.out.println(fråga);
        String str = tangentbord.nextLine();
        return str;
    }
    
    public static void taBortPerson() {
        String personSomSkaBort = läsaInString("Vem vill du ta bort? ");
        boolean hittad = false;
            for(int varv = 0; varv < listaMedPersoner.size(); varv++){
            if(listaMedPersoner.get(varv).hämtaNamn().equalsIgnoreCase(personSomSkaBort)){
                System.out.println(listaMedPersoner.get(varv).hämtaNamn() + " är raderad!");
                listaMedPersoner.remove(varv);
                hittad = true;
                break;
            }   
            }
            if(!hittad){
                System.out.println("Personen finns inte!");
        }
    }

    public static Person finnsPersonen(String ägare) {
        boolean hittaPerson = false;
        for (Person aktuell : listaMedPersoner) {
            if (aktuell.hämtaNamn().equalsIgnoreCase(ägare)) {
                hittaPerson = true;
                return aktuell;
            }
        }
        if (hittaPerson == false) {
            System.out.println("Personen finns inte!");
        }
        return null;

    }

    public static void läggaTillSmycke(String ägare) {
        Person hittad = finnsPersonen(ägare);
        String guld = null;
        if (hittad != null) {
            String namn = läsaInString("Vilket sorts smycke? ");
            for (;;) {
                guld = läsaInString("Är smycket av guld? ");
                if (guld.equalsIgnoreCase("ja") || guld.equalsIgnoreCase("nej")) {
                    break;
                } else {
                    System.out.print("Du måste svara ja eller nej! ");
                }
            }
            int antalÄdelstenar = läsaInInt("Hur många ädelstenar? ");
            Smycken s = new Smycken(namn, guld, antalÄdelstenar);
            hittad.adderaPryl(s);
            System.out.println("Smycket tillagd! ");
        }
    }

    public static void läggaTillApparat(String ägare) {
        Person hittad = finnsPersonen(ägare);
        if (hittad != null) {
            String namn = läsaInString("Vilken sorts apparat?");
            int inköpsPris = läsaInInt("Vad var inköpspriset?");
            for (;;) {
                int slitageVärde = läsaInInt("Slitagevärde? 1-10, där 10 är helt nytt. ");
                if (slitageVärde <= 10 && slitageVärde >= 1) {
                    Apparater a = new Apparater(namn, inköpsPris, slitageVärde);
                    hittad.adderaPryl(a);
                    System.out.println("Apparaten tillagd! ");
                    break;
                } else {
                    System.out.println("Du måste skriva ett tal mellan 1-10!");
                }
            }
        }
    }

    public static void läggaTillAktie(String ägare) {
        Person hittad = finnsPersonen(ägare);
        if (hittad != null) {
            String namn = läsaInString("Vad heter aktien? ");
            int antal = läsaInInt("Hur många aktier? ");
            int prisPerAktie = läsaInInt("Vad kostar en aktie? ");
            Aktier a = new Aktier(namn, antal, prisPerAktie);
            hittad.adderaPryl(a);
            System.out.println("Aktien tillagd! ");
        }
    }

    public static void visaAlla() {
        System.out.println("I registret finns: ");
        for (Person aktuell : listaMedPersoner) {
            System.out.println(aktuell.hämtaNamn() + "  Totalt värde på prlar: " + aktuell.hämtaTotaltVärde() + " kr");
        }
    }

    public static void visaRikaste() {
        int högstasumman = 0;
        Person namnetPåRikaste = null;
        for (Person aktuell : listaMedPersoner) {
            if (aktuell.hämtaTotaltVärde() >= högstasumman) {
                högstasumman = aktuell.hämtaTotaltVärde();
                namnetPåRikaste = aktuell;;
            }
        }
        try {
            System.out.println("Rikast är: " + namnetPåRikaste.hämtaNamn() + " Totalt värde på prylar: " + namnetPåRikaste.hämtaTotaltVärde() + " kr");
            System.out.println("Här är alla föremål: ");
            namnetPåRikaste.skrivUtPrylar();
        } catch (NullPointerException e) {
            System.out.println("Det finns inga personer!");
        }
    }

    public static void visaVissPerson() {
        String personenViSöker = läsaInString("Vem vill du visa? ");
        boolean hittad = false;
        for (Person aktuell : listaMedPersoner) {
            if (aktuell.hämtaNamn().equalsIgnoreCase(personenViSöker)) {
                hittad = true;
                System.out.println(aktuell.hämtaNamn() + " har saker som är totalt värt:  " + aktuell.hämtaTotaltVärde());
                aktuell.skrivUtPrylar();
            }
        }
        if (hittad == false) {
            System.out.println("Personen finns inte!");
        }
    }

    public static void läggaTillPryl() {
        String ägare = läsaInString("Vem äger prylen? ");
        int typAvPryl = läsaInInt("Vill du lägga till: 1. Smycke 2. Aktie 3. Apparat");

        switch (typAvPryl) {
            case 1:
                läggaTillSmycke(ägare);
                break;
            case 2:
                läggaTillAktie(ägare);
                break;
            case 3:
                läggaTillApparat(ägare);
                break;
            default:
                System.out.println("Fel val!");
        }
    }

    public static void läggaTillPerson() {
        String namnPåPerson = läsaInString("Vad heter personen? ");
        boolean hittad = false;
        for (Person aktuell : listaMedPersoner) {
            if (aktuell.hämtaNamn().equalsIgnoreCase(namnPåPerson)) {
                System.out.println((namnPåPerson + " finns redan!"));
                hittad = true;
                break;
            }
        }
        if (!hittad) {
            Person p = new Person(namnPåPerson);
            listaMedPersoner.add(p);
            System.out.println(namnPåPerson + " är skapad!");

        }
    }

    public static void börsKrasch() {
        for (Person aktuell : listaMedPersoner) {
            aktuell.nollställaAktier();
        }
        System.out.println("Börskrasch utförd!");
    }

    public static void main(String[] args) {
        do {
            int val = läsaInInt("Vill du: 1. Lägga till person 2. Lägga till pryl 3. Visa alla 4. Visa rikaste personen 5. Visa viss person 6. Börskrasch 7. Ta bort person. 8. Avsluta ");
            switch (val) {
                case 1:
                    läggaTillPerson();
                    break;
                case 2:
                    läggaTillPryl();
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
                    börsKrasch();
                    break;
                case 7:
                    taBortPerson();
                    break;
                case 8:
                    System.out.println("Hejdå!");
                    System.exit(0);
                default:
                    System.out.println("Fel val!");
            }
        } while (true);
    }
}