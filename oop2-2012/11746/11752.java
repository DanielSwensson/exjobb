
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Handles the user communcation
 */
public class ValuablesRegister {

    private static ArrayList<Person> allPersons = new ArrayList<Person>();
    private static Scanner keyboard = new Scanner(System.in);

    /**
     * Handles the main menu
     */
    public static void main(String[] args) {

        boolean done = false;
        int command;
        String input;

        // Load saved data from file
        try {
            FileInputStream file = new FileInputStream("persons.obj");
            ObjectInputStream in = new ObjectInputStream(file);
            while (file.available() > 0) {
                Person p = (Person) in.readObject();
                allPersons.add(p);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }

        while (!done) {
            try {
                System.out.println("\nVälkommen! Vad vill du göra?");
                System.out.println("1 Skapa en ny person");
                System.out.println("2 Skapa en ny pryl");
                System.out.println("3 Visa alla personer");
                System.out.println("4 Visa rikaste");
                System.out.println("5 Visa särskild person");
                System.out.println("6 Börskrasch");
                System.out.println("7 Ta bort person");
                System.out.println("8 Ta bort värdesak");
                System.out.println("9 Avsluta");

                input = keyboard.nextLine();
                command = Integer.parseInt(input);

                switch (command) {
                    case 1:
                        createPerson();
                        break;
                    case 2:
                        createValuable();
                        break;
                    case 3:
                        showAll();
                        break;
                    case 4:
                        showRichest();
                        break;
                    case 5:
                        System.out.print("Vem vill du visa: ");
                        input = keyboard.nextLine();
                        showPerson(input);
                        break;
                    case 6:
                        crash();
                        break;
                    case 7:
                        removePerson();
                        break;
                    case 8:
                        removeValuable();
                        break;
                    case 9:
                        saveToFile();
                        done = true;
                        break;
                    default:
                        System.out.println("Skriv ett tal 1-9");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Du måste skriva en siffra.");
                done = false;
            }
        }

    }

    /**
     * Makes all the stock-valuables loose their value
     */
    public static void crash() {
        int amount = 0;
        for (Person p : allPersons) {
            for (Valuable v : p.valuables) {
                if (v instanceof Stock) {
                    v.setPrice(0.0);
                    amount++;
                }
            }
        }

        System.out.println(
                "Du har nu nollställt " + amount + " aktier");
    }

    /**
     * Creates a person and stores it in a list
     */
    public static void createPerson() {
        System.out.print("Personens namn: ");
        String name = keyboard.nextLine();
        if (findPerson(name) != null) {
            System.out.println("Namnet är upptaget.");
            return;
        }
        Person p = new Person(name);
        allPersons.add(p);
        System.out.println(p);
    }

    /**
     * Creates a valuable and asks for its owner
     */
    public static void createValuable() {
        boolean correct;
        double price;
        int choice;
        int diamonds, wear, amount, metal;
        String name, person, input;
        Valuable valuable = null;

        do {
            correct = true;
            try {
                System.out.println("Välj vad du vill skapa:");
                System.out.println("1 Smycke");
                System.out.println("2 Apparat");
                System.out.println("3 Värdepapper");
                System.out.println("4 Tillbaka");
                input = keyboard.nextLine();
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        System.out.print("Vilken sorts smycke: ");
                        name = keyboard.nextLine();
                        System.out.print("Vilken metal\n1 guld\n2 silver: ");
                        input = keyboard.nextLine();
                        metal = Integer.parseInt(input);
                        System.out.print("Antal diamanter: ");
                        input = keyboard.nextLine();
                        diamonds = Integer.parseInt(input);
                        valuable = new Jewelry(name, metal, diamonds);
                        break;
                    case 2:
                        System.out.print("Vilken sorts apparat: ");
                        name = keyboard.nextLine();
                        System.out.print("Inköpspris: ");
                        input = keyboard.nextLine();
                        price = Double.parseDouble(input);
                        System.out.print("Slitage (10 = ny) [1-10]: ");
                        input = keyboard.nextLine();
                        wear = Integer.parseInt(input);
                        valuable = new Device(name, price, wear);
                        break;
                    case 3:
                        System.out.print("Vilket företag: ");
                        name = keyboard.nextLine();
                        System.out.print("Pris: ");
                        input = keyboard.nextLine();
                        price = Double.parseDouble(input);
                        System.out.print("Antal: ");
                        input = keyboard.nextLine();
                        amount = Integer.parseInt(input);
                        valuable = new Stock(name, amount, price);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Välj ett nummmer 1-4");
                        correct = false;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Du måste ange siffror!");
                correct = false;
            }
        } while (!correct);
        if (valuable != null) {
            storeValuable(valuable);
        }
    }

    /**
     * Searches for and returns a person
     */
    public static Person findPerson(String name) {
        for (Person p : allPersons) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Removes a requested person
     */
    public static void removePerson() {
        String name;
        System.out.print("Vem vill du ta bort: ");
        name = keyboard.nextLine();
        allPersons.remove(findPerson(name));
    }

    /**
     * Removes a requested valuable from a person
     */
    public static void removeValuable() {
        int choice;
        Person p;
        String input;
        System.out.print("Från vem vill du ta bort något: ");
        input = keyboard.nextLine();
        p = findPerson(input);
        if (p != null) {
            showPerson(input);
            System.out.print("Skriv nummret på värdesaken: ");
            input = keyboard.nextLine();
            choice = Integer.parseInt(input);
            if (choice > p.valuables.size()) {
                System.out.println("Finns inget sådant nummer.");
            } else {
                p.valuables.remove(p.valuables.get(--choice));
            }
        } else {
            System.out.println("Personen hittades inte.");
        }
    }

    /**
     * Saves the created persons and valuables to a file
     */
    public static void saveToFile() {
        try {
            FileOutputStream file = new FileOutputStream("persons.obj");
            ObjectOutputStream out = new ObjectOutputStream(file);
            for (Person p : allPersons) {
                out.writeObject(p);
            }
        } catch (IOException e) {
            System.out.println("Det gick inte att spara filen.");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Shows all persons
     */
    public static void showAll() {
        if (testPersonsExist()) {
            System.out.println(allPersons);
        }
    }

    /**
     * Shows a person and its valuables
     */
    public static void showPerson(String name) {
        try {
            int counter = 1;
            Person p;
            p = findPerson(name);
            for (Valuable v : p.valuables) {
                System.out.print(counter++ + ": " + v + " ");
            }
        } catch (NullPointerException e) {
            System.out.print("Fel vid personval.");
        }
    }

    /**
     * Finds and prints the richest person
     */
    public static void showRichest() {
        if (testPersonsExist()) {
            Person richestPerson = allPersons.get(0);
            for (Person p : allPersons) {
                if (p.getValue() >= richestPerson.getValue()) {
                    richestPerson = p;
                }
            }
            System.out.println(richestPerson);
        }
    }

    /**
     * Asks for and finds a person for the valuable then stores the valuable in
     * two lists.
     */
    public static void storeValuable(Valuable valuable) {
        String name;
        System.out.println("Ägarens namn: ");
        name = keyboard.nextLine();
        Person p = findPerson(name);
        if (p == null) {
            System.out.println("\nVärdesaken kunde inte sparas till personen,"
                    + "\nVälj 1 för att skapa personen och försök sedan igen!");
            return;
        }
        p.valuables.add(valuable);
        System.out.println(p.valuables);
    }

    /**
     * Tests whether a persons is in the list or not
     */
    public static boolean testPersonsExist() {
        if (allPersons.size() < 1) {
            System.out.println("Det finns inga personer.\nVälj 1 för att lägga till personer!");
            return false;
        }
        return true;
    }
}
