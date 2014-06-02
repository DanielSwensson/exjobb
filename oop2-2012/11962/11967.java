import java.util.Scanner;
import java.util.ArrayList;
import java.lang.NumberFormatException;

public class MainRegistry {

    private static Scanner keyboard = new Scanner(System.in);
    private static ArrayList<Owner> ownerList = new ArrayList<Owner>();

    private static Owner getOwnerByName(String name) {

        for (Owner currentOwner : ownerList) {
            if (currentOwner.getName().equalsIgnoreCase(name)) {
                return currentOwner;
            }

        }
        return null; //hittar vi ingen användare så returnerar vi ingenting
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        String str = keyboard.nextLine();
        return str;
    } //får in även siffror som en sträng, behöver inga exceptions.

    private static int readInt(String prompt) {
        boolean gotInput = false;
        int number = 0;
        do {
            try {
                System.out.print(prompt); //ex skriv värde på aktie, nåt med en int
                String maybeNumber = keyboard.nextLine(); //behöver bara ändra en gång! kanske ett nummer här
                number = Integer.parseInt(maybeNumber);

                gotInput = true;
            } catch (NumberFormatException e) { //validerar INTARNTA
                System.out.println("Try again! ");
            }
        } while (!gotInput);
        return number;
    }

    private static boolean readBoolean(String prompt) {
        boolean gotInput = false;
        boolean answer = false;
        do {

            System.out.print(prompt);
            String maybeBool = keyboard.nextLine();
            if (maybeBool.equalsIgnoreCase("yes")) {
                answer = true;
                gotInput = true;
            } else if (maybeBool.equalsIgnoreCase("no")) {
                answer = false;
                gotInput = true;
            } else {
                gotInput = false;
                System.out.println("We need either a Yes or a No");
            }

        } while (!gotInput);
        return answer;
    }

    private static int startMenu() {

        System.out.println("1. Register owner");
        System.out.println("2. Create item");
        System.out.println("3. Display owners");
        System.out.println("4. Show richest");
        System.out.println("5. Display owner by name");
        System.out.println("6. Stock market crash");
        System.out.println("7. Exit");
        return readInt("Choose action: ");
    }

    private static void registerOwner() {
        String name = readString("Enter your name: ");
        System.out.println();
        boolean addOwner = true;
        for (Owner currentOwner : ownerList) {
            if (currentOwner.getName().equalsIgnoreCase(name)) { //för varje användare så går vi igenom och kollar om någon har samma namn som "name".
                addOwner = false;
                break; //använder break här eftersom jag rent teoretiskt skulle kunna hitta personen direkt i en stor lista och hoppar ur istället.
            }
        }
        if (addOwner) { //hittade ingen med samma namn, lägger till
            Owner newOwner = new Owner(name);
            ownerList.add(newOwner);

        } else {
            System.out.println("Name already exists!");
            System.out.println();
        }
    }

    private static void createItem() {
        String name = readString("Who owns the item? ");
        Owner itemOwner = getOwnerByName(name); //Owner = typen itemOwner = variabelnamn
        if (itemOwner == null) {
            System.out.println("Owner doesn't exist ");
            return; //returnerar ingenting. hoppar ur funktionen
        }
        System.out.println("1. Jewelry");
        System.out.println("2. Stock");
        System.out.println("3. Device");
        boolean choosingAction = true;
        int choice;
        do {
            choice = readInt("Choose your action! ");
            if (choice == 1 || choice == 2 || choice == 3) { // eller = ||
                choosingAction = false; //då har man gjort ett val
            } else {
                System.out.println("Not a choice, try again! ");
            }
        } while (choosingAction); //gör det här medan det är sant.

        if (choice == 1) {
            String typeOfJewelry = readString("What kind of jewelry is it? ");
            boolean isItGold = readBoolean("Is the jewelry made out of gold? ");
            int gemNumber = readInt("How many gems does it have? ");
            Jewelry jewelry = new Jewelry(typeOfJewelry, isItGold, gemNumber);
            itemOwner.addItem(jewelry);

        } else if (choice == 2) {
            String nameOnStock = readString("Name of stock? ");
            int priceOfStock = readInt("What's the price? ");
            int quantityOfStock = readInt("How much stock? ");
            Stock stock = new Stock(nameOnStock, quantityOfStock, priceOfStock);
            itemOwner.addItem(stock);
        } else {
            String typeOfDevice = readString("What kind of device is it? ");
            int priceOfDevice = readInt("What does it cost?");
            int qualityOfDevice = readInt("What's the condition? 1-10 ");
            Device device = new Device(typeOfDevice, priceOfDevice, qualityOfDevice);
            itemOwner.addItem(device);
        } //vet att det är 1,2 eller 3.




    }

    private static void listOwners() {
        for (Owner owner : ownerList) {
            System.out.println(owner);

        }
    }

    private static void showWealthiestOwner() {
        Owner currentWealthiest = null; //annars initialiseras den inte.
        for (Owner owner : ownerList) {
            if (currentWealthiest == null || owner.totalWorth() > currentWealthiest.totalWorth()) { // större än nuvarande med totalWorth. hoppar över om null
                currentWealthiest = owner; // nu är owner rikaste. 



            }
        }
        System.out.println("Richest are: " + currentWealthiest.getName());
        printOwnerDetails(currentWealthiest);


    }

    private static void printOwnerDetails(Owner owner) { //tar emot en parameter som är av typen Owner.
        for (Item item : owner.getItemList()) { //tar fram alla items av typen Item för ownern
            System.out.println(item);
        }

    }

    private static void showOneOwner() {

        String name = readString("Which owner are you looking for? ");
        Owner oneOwner = getOwnerByName(name); //Owner = typen itemOwner = variabelnamn
        if (oneOwner == null) {
            System.out.println("Owner doesn't exist ");
            return; //returnerar ingenting. hoppar ur funktionen
        }

        System.out.println(oneOwner);
        printOwnerDetails(oneOwner);
    }

    private static void stockMarketCrash() {
        for (Owner currentOwner : ownerList) {
            for (Item currentItem : currentOwner.getItemList()) {
                if (currentItem instanceof Stock) {
                    ((Stock) currentItem).setStockPrice(0); //castar, och itemet blir stock
                }
            }
        }
    }

    public static void main(String[] args) {

        boolean running = true;
        do {
            switch (startMenu()) {
                case 1:
                    registerOwner();
                    break;
                case 2:
                    createItem();
                    break;
                case 3:
                    listOwners();
                    break;
                case 4:
                    showWealthiestOwner();
                    break;
                case 5:
                    showOneOwner();
                    break;
                case 6:
                    stockMarketCrash();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Not an option!!!!!");
                    break;
            }
        } while (running);
        System.out.println("Bye bye!");

    }
}
