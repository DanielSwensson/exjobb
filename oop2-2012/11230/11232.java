package assetmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class AssetManagement {//huvudklass AssetManagement 

    ArrayList<Person> persons = new ArrayList<Person>();//Arraylist-objekt på klassen Person
    Scanner scan = new Scanner(System.in); //Scanner-objekt

    public int readInt(String query) {//metod för att läsa in int'ar med kontroll
        for (;;) {
            try {
                System.out.print(query);
                int x = Integer.parseInt(scan.nextLine());
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Fel - skall vara numeriskt värde");
            }
        }
    }

    String readString(String query) {//metod för att läsa in strings
        System.out.print(query);
        String str = scan.nextLine();
        return str;
    }

    Person getPerson(String name) {//metod för att kontrollera om person finns sen tidigare
        for (Person p : persons) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
    
    public int subZeroCheck(int number) {//metod för kontroll av negativa int'ar
    if (number < 0) {
        System.out.println("Negativt tal! värdet sätts till noll");
        return 0;
    }
    return number;
}

    public void addAsset() {//metod för att lägga till tillgång till en person
        String name = readString("Vem äger prylen? : ");
        Person p = getPerson(name);
        if (p == null) {
            System.out.println("Personen finns inte!!");
            return;
        }
        Asset a = null;
        String n = null;
        int sort = readInt("Vilken tillgångstyp? 1=Smycke, 2=Aktier, 3=Apparat,"
                + "4=Läs in testdata: ");
        if (sort > 0 && sort < 4) {
            n = readString("Namnge tillgången: ");
        }
        if (sort == 1) {//lägga till smycke
            boolean isGold;
            if (readString("Av guld? J/N: ").equalsIgnoreCase("j")) {
                isGold = true;
            } else {
                isGold = false;
            }
            int numberstones = subZeroCheck(readInt("Antal ädelstenar?: "));
            a = new Jewelry(n, isGold, numberstones);
        }
        if (sort == 2) {//lägga till aktier
            int numberstocks = subZeroCheck(readInt("Antal aktier?: "));
            int stockprice = subZeroCheck(readInt("Aktiekurs?: "));
            a = new Stocks(n, numberstocks, stockprice);
        }
        if (sort == 3) {//lägga till apparat
            int pp = readInt("Inköpspris?: ");
            int wr = readInt("Slitage? 1-10 där 10=nyskick: ");
            a = new Gadget(n, wr, pp);
        }
        if (sort > 4 || sort < 1) {//går ur metoden vid felaktig inmatning
            System.out.println("Felaktig inmatning!!\n");
            return;
        }
        if (sort == 4) { //lägger in testdata
            p.addAsset(new Stocks("Aktie1", 160, 10));
            p.addAsset(new Gadget("Apparat1", 6, 9000));
            p.addAsset(new Jewelry("Smycke1", true, 1));
            p.addAsset(new Stocks("Aktie2", 140, 15));
            p.addAsset(new Gadget("Apparat2", 10, 390000));
            p.addAsset(new Jewelry("Smycke2", true, 3));
            p.addAsset(new Stocks("Aktie3", 100, 20));
            p.addAsset(new Gadget("Apparat3", 3, 700));
            p.addAsset(new Jewelry("Smycke3", false, 5));
            return;
        }
        p.addAsset(a);
    }

    void addPerson() {//metod för att lägga till person
        String name = readString("Nya personens namn: ");
        Person p = getPerson(name);
        if (p != null) {
            System.out.println("Den här personen finns redan");
        } else {
            Person np = new Person(name);
            persons.add(np);
        }
    }

    void showAllPersons() {//metod för att visa alla personer samt deras tillgångars värde
        if (!existPersons()) {
            return;
        }
        for (Person p : persons) {
            System.out.println(p.getName() + " äger tillgångar värda " + p.getValue());
        }
    }

    public boolean existPersons() { //metod för att kontrollera om det finns personer i arraylisten persons
        if (persons.isEmpty()) {
            System.out.println("Det finns inga registrerade personer!");
            return false;
        }
        return true;
    }

    void showRichest() {//metod för att finna den rikaste och presentera denna
        int max = 0;
        Person richest = null;
        if (!existPersons()) {
            return;
        }
        for (Person p : persons) {//loopar arraylisten persons
            if (p.getValue() > max) {//kontrollerar om rikare person finns
                richest = p;//sätter ny rikaste person
                max = p.getValue();//sätter nytt toppvärde
            }
        }
        if (richest == null) {//detta innebär att det finns personer men inga tillgångar värda mer än noll på personerna
            System.out.println("Finns inga tillgångar på registrerade personer");
            return;
        }
        System.out.println("Den rikaste personen är " + richest.getName() + " och dennes förmögenhet uppgår till " + max);
        System.out.println();
        System.out.println("Namn\t\tVärde\tÖvrigt");
        richest.showAssets();
    }

    void showPersonValue() {//metod för att visa specifik persons tillgångar är värde
        if (!existPersons()) {
            return;
        }
        String person = readString("Vilken persons tillgångar vill du visa?: ");
        Person p = getPerson(person);
        if (p == null) {
            System.out.println("Personen finns inte!!");
        } else {
            System.out.println("Personen " + p.getName() + " har tillgångar värda " + p.getValue() + " och listas nedan:");
            System.out.println();
            System.out.println("Namn\t\tVärde\tÖvrigt");
            p.showAssets();
        }
    }

    void stockmarketcrash() {//metod för att utföra börskrasch på alla personer
        for (Person p : persons) {
            p.doCrash();
        }
        System.out.println("Börsen har kraschat! Alla aktiekurser är nere på noll.");
    }

    void showHelp() {//metod för att visa hjälpsida
        System.out.println("0 för att avsluta programmet");
        System.out.println("1 Registrera person");
        System.out.println("2 Registrera tillgång");
        System.out.println("3 Visa alla personer samt deras tillgångars värde");
        System.out.println("4 Visa rikaste");
        System.out.println("5 Visa specifik persons tillgångar och värde");
        System.out.println("6 Börskrasch!");
        System.out.println("7 Visa denna hjälpsida");
    }

    public static void main(String[] args) {//huvudprogram
        AssetManagement am = new AssetManagement();//objekt am på klassen AssetManagement
        System.out.println("Välkommen till din tillgångshanterare!");
        for (;;) {
            int val = am.readInt("\nAnge kommando 0-7, 7 för hjälp: ");
            switch (val) {
                case 1:
                    am.addPerson();
                    break;
                case 2:
                    am.addAsset();
                    break;
                case 3:
                    am.showAllPersons();
                    break;
                case 4:
                    am.showRichest();
                    break;
                case 5:
                    am.showPersonValue();
                    break;
                case 6:
                    am.stockmarketcrash();
                    break;
                case 7:
                    am.showHelp();
                    break;
                case 0:
                    System.out.println("Tack och hej då!");
                    System.exit(0);
                default:
                    System.out.println("Fel kommando");
            }
        }
    }
}