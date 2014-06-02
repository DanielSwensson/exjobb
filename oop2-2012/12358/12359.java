//
// MyAssets.java
//
// MyAssets.java utgör huvudprogrammet och innehåller main-metoden
//
// Jag implementerade inte funktionalitet för att ta bort personer och saker,
// men det borde framgå att jag vet hur :-)
//
// Programmet är en implementation av ett värdesaksregister med
// hantering för att lägga till personer och olika värdesaker
// samt att visa information om värdesakerna.
//
// Programmet tar sin utgångspunkt i förslagsuppgiften för kursen
// DSK:OOP, höstterminen 2012, vid DSV, Stockholms universitet.
//
// Skrivet av Patrick Wentzel
//

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import myassets.domainobjects.assets.*;
import myassets.domainobjects.person.Person;
import myassets.helper.ConsoleIO;

// Huvudprogrammet
public final class MyAssets {

    // Collections för personer och tillgångar
    private ArrayList<Person> persons = new ArrayList<>();
    private ArrayList<AbstractAsset> assets = new ArrayList<>();
    // Filer för att spara data
    private final String saveFilePersons = "persons.sav";
    private final String saveFileAssets = "assets.sav";
    // Skapa en instans av hjälpklassen för consolehanteringen
    public ConsoleIO cli = new ConsoleIO();

    public static void main(String[] args) {

        // Skapa en instans av huvudprogrammet och visa menyn
        MyAssets app = new MyAssets();
        app.showMenu();
        System.exit(0);
    }

    // Metod för att visa och loopa menyn.
    public void showMenu() {

        while (true) {

            cli.println("+-------------------------------------------------------+");
            cli.println("|           Värdesaksregistret MyAssets                 |");
            cli.println("+-------------------------------------------------------+");
            cli.println("| Vad vill du göra? (ange siffra och tryck enter)       |");
            cli.println("|                                                       |");
            cli.println("| 1. Skapa person          6. Visa alla prylar          |");
            cli.println("| 2. Skapa pryl            7. Börskrasch                |");
            cli.println("| 3. Visa alla personer    8. Läs in data från fil      |");
            cli.println("| 4. Visa rikaste          9. Spara data till fil       |");
            cli.println("| 5. Visa viss person                                   |");
            cli.println("|                                                       |");
            cli.println("| 0. Avsluta                                            |");
            cli.println("+-------------------------------------------------------+");

            int menuChoice = cli.readInt("> ");

            switch (menuChoice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    addAsset();
                    break;
                case 3:
                    showAllPersons();
                    break;
                case 4:
                    showWealthiestPerson();
                    break;
                case 5:
                    showSpecificPerson();
                    break;
                case 6:
                    showAllAssets();
                    break;
                case 7:
                    doStockMarketCrash();
                    break;
                case 8:
                    loadDataFromFile();
                    break;
                case 9:
                    saveDataToFile();
                    break;

                // Finns för debuggning.
                case 99:
                    debugShowData();
                    break;

                case 0:
                    cli.println("Avslutar...");
                    cli = null;
                    return;
                default:
                    cli.println("Ogiltigt kommando! Försök igen.");
                    break;
            }
        }
    }

    // Metod för att lägga till en ny person. 
    // Kollar om det redan finns en person med samma namn.
    private void addPerson() {

        String name = cli.readString("Ange namnet på personen du vill lägga till: ");

        Person p = getPersonByName(name);
        if (p != null) {
            cli.println("Det finns redan en person med det namnet!");
        } else {
            p = new Person(name);
            persons.add(p);
            cli.println(name + " las till i registret.");
        }
    }

    // Metod för att lägga till en ny sak.
    private void addAsset() {

        String strOwner = cli.readString("Vilken person ska äga prylen (? för att lista registrerade personer): ");
        if (strOwner.equalsIgnoreCase("?")) {
            showAllPersonsShort();
            strOwner = cli.readString("Vilken person ska äga prylen: ");
        }
        Person assetOwner = getPersonByName(strOwner);
        if (assetOwner == null) {
            cli.println("Det finns ingen person som heter " + strOwner + " registrerad.");
            cli.print("Vill du lägga till en person med det namnet? (ja/nej): ");
            if (cli.readString().equalsIgnoreCase("Ja")) {
                assetOwner = new Person(strOwner);
                persons.add(assetOwner);
            } else {
                cli.println("Kan inte lägga till ägarlösa prylar. Återgår till huvudmenyn.");
                return;
            }
        }

        int typeOfAsset = cli.readInt("Typ av pryl (1=Apparat, 2=Smycke, 3=Aktiepost): ");

        AbstractAsset newAsset = null;

        // Kör olika inmatningsrutiner beroende på typ av sak.
        switch (typeOfAsset) {

            case 1: // Apparat
                String gadgetName = cli.readString("Namn på apparaten: ");
                double purchasePrice = cli.readDouble("Inköpspris: ");
                int levelOfWear = cli.readInt("Vilket skick är det på apparaten (ny = 10 - 0 = helt utsliten): ");

                newAsset = new Gadget(purchasePrice, levelOfWear, gadgetName, assetOwner);
                break;

            case 2: // Smycke

                String jewelleryName = cli.readString("Vilken sorts smycke är det: ");
                String metal = cli.readString("Vilken metall är smycket gjort av (guld/silver): ");
                int numberOfGems = cli.readInt("Hur många juveler har smycket: ");

                newAsset = new Jewellery(numberOfGems, metal, jewelleryName, assetOwner);
                break;

            case 3: // Aktiepost
                String stockName = cli.readString("Aktiens namn: ");
                double price = cli.readDouble("Pris per styck: ");
                int quantity = cli.readInt("Antal: ");

                newAsset = new Stock(quantity, price, stockName, assetOwner);
                break;
        }

        // Lägg till den nyskapade saken i listan med saker och i listan med 
        // personens innehav.
        assets.add(newAsset);
        assetOwner.addAssetToHoldings(newAsset);

        cli.println("La till saken [" + newAsset.getAssetName() + " (värde " + newAsset.getAssetValueAsMoney() + ")] för " + assetOwner.getName());

    }

    // Metod för att visa alla personer
    private void showAllPersons() {

        if (persons.isEmpty()) {
            cli.println("Det finns inga personer i registret.");
            return;
        }

        cli.println("Följande personer finns i registret:");
        cli.println("------------------------------------");
        cli.println("Namn\tFörmögenhet");
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    // Metod för att visa alla personer, fast bara namnet.
    private void showAllPersonsShort() {

        if (persons.isEmpty()) {
            cli.println("Det finns inga personer i registret.");
            return;
        }

        cli.println("Följande personer finns i registret:");
        cli.println("------------------------------------");

        for (Person person : persons) {
            System.out.println(person.getName());
        }
    }

    // Metod för att hitta och via den rikaste personen.
    // Tar inte hänsyn till att flera personer kan vara lika rika eller fattiga
    // utan visar bara den senast hittade personen med mest tillgångar.
    private void showWealthiestPerson() {
        if (assets.isEmpty()) {
            cli.println("Det finns inga saker registrerade.");
            return;
        }

        Person wealthiestPerson = null;
        for (Person person : persons) {
            if (wealthiestPerson == null) {
                wealthiestPerson = person;
            }
            if (wealthiestPerson.getWealth() < person.getWealth()) {
                wealthiestPerson = person;
            }
        }

        cli.println("Den rikaste personen är " + wealthiestPerson.getName() + " som är värd " + wealthiestPerson.getWealthAsMoney());
        cli.println(wealthiestPerson.getName() + " äger följande saker:");
        for (AbstractAsset asset : wealthiestPerson.getHoldings()) {
            cli.println(asset);
        }
    }

    // Visa en specifik person
    private void showSpecificPerson() {

        String input = cli.readString("Vilket person vill du se (? för att visa vilka som finns registrerade): ");

        if (input.equalsIgnoreCase("?")) {
            showAllPersonsShort();
            cli.print(getPersonByName(cli.readString("Vem vill du se: ")));
        } else {
            cli.print(getPersonByName(input));
        }
    }

    // Metod som genomför en börskrasch vilket innebär att värdet på samtliga 
    // aktier nollställs (priset sätts till noll).
    private void doStockMarketCrash() {
        cli.println("Börskrasch nollställer värdet på samtliga aktieposter!");
        String choice = cli.readString("Vill du verkligen fortsätta (ja/nej): ");

        if (choice.equalsIgnoreCase("ja")) {

            for (AbstractAsset asset : assets) {
                if (asset instanceof Stock) {
                    Stock s = (Stock) asset;

                    // Justera aktieägarens förmögenhet innan värdet nollställs.
                    s.getAssetOwner().setWealth(s.getAssetOwner().getWealth() - s.getAssetValue());

                    // FEL FEL FEL FEL 
                    s.setStockPrice(0);
                }
            }
            cli.println("Börsen kraschad!");

        } else {
            cli.println("Avbryter.");
        }
    }

    // Metod som visar samtliga saker (assets) som finns registrerade.
    private void showAllAssets() {

        if (assets.isEmpty()) {
            cli.println("Det finns inga saker i registret.");
            return;
        }

        for (AbstractAsset asset : assets) {
            cli.println(asset + " (Ägare: " + asset.getAssetOwner().getName() + ")");
        }
    }

    // Metod som laddar in data från filer sparade i katalogen .\data
    private void loadDataFromFile() {

        // Läs in personer
        try {
            FileInputStream fp = new FileInputStream(saveFilePersons);
            ObjectInputStream op = new ObjectInputStream(fp);
            while (fp.available() > 0) {
                persons = ((ArrayList<Person>) op.readObject());
            }
            cli.println("Läste in " + persons.size() + " personer från filen.");

        } catch (FileNotFoundException e) {
            System.out.print(e);
        } catch (IOException e) {
            System.out.print(e);
        } catch (ClassNotFoundException e) {
            System.out.print(e);
        }

        // Läs in assets
        try {
            FileInputStream fa = new FileInputStream(saveFileAssets);
            ObjectInputStream oa = new ObjectInputStream(fa);
            while (fa.available() > 0) {
                assets = ((ArrayList<AbstractAsset>) oa.readObject());
            }
            cli.println("Läste in " + assets.size() + " saker från filen.");

        } catch (FileNotFoundException e) {
            System.out.print(e);
        } catch (IOException e) {
            System.out.print(e);
        } catch (ClassNotFoundException e) {
            System.out.print(e);
        }
    }

    // Metod som sparar de två ArrayList-objekten till fil med objektserialisering.
    private void saveDataToFile() {

        // Spara personer
        try {
            FileOutputStream fp = new FileOutputStream(saveFilePersons);
            ObjectOutputStream op = new ObjectOutputStream(fp);
            op.writeObject(persons);
            cli.println("Sparade " + persons.size() + " personer till filen.");
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Det gick inte att spara. Återgår till huvudmenyn.");
        }

        // Spara assets
        try {
            FileOutputStream fa = new FileOutputStream(saveFileAssets);
            ObjectOutputStream oa = new ObjectOutputStream(fa);
            oa.writeObject(assets);
            cli.println("Sparade " + assets.size() + " saker till filen.");

        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Det gick inte att spara. Återgår till huvudmenyn.");
        }
    }

    // Metod som kontrollerar om en person finns.
    // Returnerar personen om den finns, annars null.
    private Person getPersonByName(String name) {
        for (Person person : persons) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    // Metod som visar innehållet i de två Arraylistobjekten.
    // Används bara för debuggning.
    private void debugShowData() {
        System.out.println("Persons: " + persons);
        System.out.println("Assets: " + assets);
    }
}
