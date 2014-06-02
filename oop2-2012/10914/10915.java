import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class CLI {

    private PersonRegister persons = new PersonRegister();
    private Scanner input = new Scanner(System.in);

    public CLI() {
    }

    private void initialize() {
        try {
            FileInputStream fStream = new FileInputStream("save.obj");
            ObjectInputStream objStream = new ObjectInputStream(fStream);
            persons = (PersonRegister) objStream.readObject();
        } catch(IOException e) {
            // this indicates no file found or file could not be accessed due to permissions, will continue without restoring previous data
        } catch(ClassNotFoundException e) {
            System.err.println(e);
        }
    }

    private int showReadIntDialogue(String question, String errorMessage) {
        int integerValue;
        while(true) {
            try {
                System.out.print(question);
                integerValue = Integer.parseInt(input.nextLine());
                return integerValue;
            } catch(NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    private double showReadDoubleDialogue(String question, String errorMessage) {
        double doubleValue;
        while(true) {
            try {
                System.out.print(question);
                doubleValue = Double.parseDouble(input.nextLine());
                return doubleValue;
            } catch(NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    private String showReadStringDialogue(String question) {
        System.out.print(question);
        return input.nextLine();
    }

    private void showMenuDialogue() {
        System.out.println("1.Skapa person\n" +
                "2.Skapa pryl\n" +
                "3.Visa alla personer\n" +
                "4.Visa rikaste person\n" +
                "5.Visa viss person\n" +
                "6.Börskrasch\n" +
                "7.Avsluta");
    }

    private void showCreatePersonDialouge() {
        String personName;
        Person newPerson;
        System.out.print("Ange namn: ");
        personName = input.nextLine();
        newPerson = persons.addPerson(personName);
        if(newPerson != null) {
            System.out.println(newPerson.getName() + " har lagts till.");
        } else {
            System.out.println(personName + " fanns redan i listan.");
        }
    }

    private boolean showAddItemDialouge() {
        String personName, itemType;
        Person person;
        personName = showReadStringDialogue("Vilken person äger prylen: ");
        person = persons.getPersonByName(personName);
        if(person == null) {
            System.out.println("Personen du angav fanns inte i registret.");
            return false;
        }
        itemType = showReadStringDialogue("Vilken sorts pryl: ");
        if(itemType.equalsIgnoreCase("smycke")) {
            String juweleryType;
            boolean isGold;
            int juweleryNumberOfGems;
            juweleryType = showReadStringDialogue("Vilken sorts smycke: ");
            System.out.print("Är smycket av guld? Ja/Nej");
            isGold = input.nextLine().equalsIgnoreCase("ja") ? true : false;
            juweleryNumberOfGems = showReadIntDialogue("Antal ädelstenar: ", "Felaktigt antal, måste vara ett numeriskt värde.");
            person.addItem(new Juwelery(juweleryType, juweleryNumberOfGems, isGold));
        } else if(itemType.equalsIgnoreCase("apparat")) {
            String deviceName;
            double originalPrice;
            int wear;
            deviceName = showReadStringDialogue("Vilken sorts apparat: ");
            originalPrice = showReadDoubleDialogue("Inköpspris: ", "Felaktigt pris, måste vara ett numeriskt värde.");
            wear = showReadIntDialogue("Slitage(1-10 varav 1 är helt ny): ", "Felaktigt slitage, måste vara ett numeriskt värde.");
            person.addItem(new Device(deviceName, wear, originalPrice));
        } else if(itemType.equalsIgnoreCase("aktie")) {
            String companyName;
            int quantity;
            double price;
            companyName = showReadStringDialogue("Vilket bolag: ");
            quantity = showReadIntDialogue("Antal aktier: ", "Felaktigt antal, måste vara ett numeriskt värde.");
            price = showReadDoubleDialogue("Pris per aktie: ", "Felaktigt pris, måste vara ett numeriskt värde.");
            person.addItem(new Share(companyName, quantity, price));
        } else {
            System.out.println("Registret kan endast hantera smycken, apparater och aktier.");
            return false;
        }
        System.out.println("Den nya prylen har lagts till i registret.");
        return true;
    }

    private void showAllPersonsDialouge() {
        ArrayList<Person> personList = persons.getAllPersons();
        for(Person p : personList) {
            System.out.println(p.toString());
        }
    }

    private void showRichestPersonDialogue() {
        if(persons.getAllPersons().size() > 0) {
        	System.out.println("Rikaste person(er)");
            for(Person p : persons.getRichestPerson()) {
                System.out.println(p.toString());
                for(Item i : p.getItems()) {
                	System.out.println(i);
                }
            }
        }
    }

    private void showPersonDialogue() {
        String name;
        name = showReadStringDialogue("Vilken person: ");
        if(persons.getPersonByName(name) != null) {
            System.out.println(persons.getPersonByName(name).toString());
            for(Item i : persons.getPersonByName(name).getItems()) {
            	System.out.println(i);
            }
        } else {
            System.out.println("Personen du angav fanns inte i registret");
        }
    }

    private void showStockMarketCrashDialogue() {
        StockMarketHandler.stockMarketCrash(persons);
        System.out.println("Samtliga aktiers värde är nu satt till 0.");
    }

    private void quit() {
        try {
            FileOutputStream fStream = new FileOutputStream("save.obj");
            ObjectOutputStream objStream = new ObjectOutputStream(fStream);
            objStream.writeObject(persons);
        } catch(IOException e) {
            System.err.println(e);
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        CLI cli = new CLI();
        cli.initialize();
        cli.showMenuDialogue();
        int command;
        while(true) {
            command = cli.showReadIntDialogue("Ange kommando: ", "Felaktigt kommando, försök igen.");
            switch(command) {
                case 1:
                    cli.showCreatePersonDialouge();
                    break;
                case 2:
                    cli.showAddItemDialouge();
                    break;
                case 3:
                    cli.showAllPersonsDialouge();
                    break;
                case 4:
                    cli.showRichestPersonDialogue();
                    break;
                case 5:
                    cli.showPersonDialogue();
                    break;
                case 6:
                    cli.showStockMarketCrashDialogue();
                    break;
                case 7:
                	cli.quit();
                    break;
                default:
                    System.out.println("Felaktigt kommando, försök igen.");
                    break;
            }
        }
    }
}
