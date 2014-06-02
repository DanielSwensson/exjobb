package peopleandstuff;

import java.util.ArrayList;
import java.util.Scanner;

public class People {

    ArrayList<Item> allItems = new ArrayList<>();
    Scanner keyboard = new Scanner(System.in);
    private String name;

    public People(String name) {
        allItems = new ArrayList<Item>();
        this.name = name;
    }

    public People() {
    }

    public String toString() {
        return "Name: " + name;

    }

    String readString(String question) {
        System.out.println(question);
        String str = keyboard.nextLine();
        return str;
    }

    int readInt(String question) {
        for (;;) {
            try {
                System.out.print(question);
                int x = Integer.parseInt(keyboard.nextLine());
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Must be numeric!");
            }
        }
    }

    double readDouble(String question) {
        for (;;) {
            try {
                System.out.print(question);
                double x = Integer.parseInt(keyboard.nextLine());
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Must be numeric!");
            }
        }
    }

    public ArrayList<Item> getItem() {
        return allItems;
    }

    public String getName() {
        return name;
    }

    public int getTotalValue() {
        int totalValue = 0;
        String thing = null;
        for (Item i : allItems) {
            totalValue = totalValue + i.getItemValue();
            thing = i.getItemName();
        }
        return totalValue;
    }

    public void showAllItems() {
        int totalValue = 0;
        for (Item i : allItems) {
            System.out.println(i.getItemName());

        }

    }

    public void registerPerson() {
        name = readString("New persons name: ");
        System.out.println(name + " is added");
        
    }

    public void addItem(Item i) {
        allItems.add(i);
        return;
    }

    public void registerItems() {
        int itemValue = 0;
        String itemType = readString("Type of item (Stock, Gadget, Jewelry) ");
        String itemName = readString("Add name of item: ");

        if (itemType.equalsIgnoreCase("Stock")) {
            int amount = readInt("Add number of stocks: ");
            itemValue = readInt("Price of stock: ");
            itemValue = amount * itemValue;
            Stock stockNew = new Stock(itemName, itemValue);
            allItems.add(stockNew);

        } else if (itemType.equalsIgnoreCase("Gadget")) {
            itemValue = readInt("Gadget worth: ");
            double gadgetDecay = readDouble("How worn is the gadget? (1 (worn out) - 10 (brand new)): ");
            if (gadgetDecay < 1 || gadgetDecay > 10) {
                System.out.println("\nNot in correct range.");

            } else {
                itemValue = (int) ((gadgetDecay / 10) * itemValue);
                Gadgets gadgetNew = new Gadgets(itemName, itemValue);
                allItems.add(gadgetNew);

            }
        } else if (itemType.equalsIgnoreCase("Jewelry")) {
            String sort = readString("Is your item made of gold? (yes/no) ");
            if (sort.equalsIgnoreCase("Yes")) {
                itemValue = 2000;

            } else {
                itemValue = 700;
            }
            int amountGemstone = readInt("How many gemstones? ");
            int gemstone = amountGemstone * 500;
            itemValue = itemValue + gemstone;
            Jewelry jewelryNew = new Jewelry(itemName, itemValue);
            allItems.add(jewelryNew);
        }

    }
    
    public void setName(String inName){       
        name = inName;
        
    }
}
