package peopleandstuff;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

public class PeopleAndItems {

    private ArrayList<People> allPeople = new ArrayList<>();
    Scanner keyboard = new Scanner(System.in);

    public PeopleAndItems() {
    }

    public void run() {

        System.out.println("Welcome to PeopleAndItems!\n");

        for (;;) {
            System.out.print("Choose an option.\n"
                    + "1 Register a person\n"
                    + "2 Register an item\n"
                    + "3 List all (every person and their items)\n"
                    + "4 Show richest\n"
                    + "5 Search for person\n"
                    + "6 Cause a stock market crash\n"
                    + "7 Exit\n"
                    + "> ");
            try {
                int alt = keyboard.nextInt();
                keyboard.nextLine();

                switch (alt) {
                    case 0:
                        testMe();
                        break;
                    case 1:
                        registerPerson();
                        break;
                    case 2:
                        registerItem();
                        break;
                    case 3:
                        listAll();
                        break;
                    case 4:
                        getRichest();
                        break;
                    case 5:
                        searchPerson();
                        break;
                    case 6:
                        stockCrash();
                        break;
                    case 7:
                        System.out.println("Later gator - I'm out!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Felaktigt kommando");
                }
            } catch (InputMismatchException e) {
                System.out.println("Must be numeric!");
                keyboard.nextLine();
            }
        }

    }

    private void registerItem() {

        try {
            System.out.print("To whom? ");
            String name = keyboard.nextLine();
            People op = getPerson(name);
            allPeople.remove(op);
            System.out.println("You're adding items to " + op.getName());
            op.registerItems();
            System.out.println(op.getItem().toString());
            allPeople.add(op);
        } catch (NullPointerException e) {
            System.out.println("There's no person with that name.");
        }

    }

    private void registerPerson() {

        System.out.println("New persons name: ");
        String name = keyboard.nextLine();
        boolean bExists = false;
        if( allPeople != null && !allPeople.isEmpty())
        {    
            for (People p : allPeople) 
            {
                if (p.getName().equalsIgnoreCase(name)) 
                {
                    bExists=true;
                    System.out.println(name + " already exists.");
                    break;
                }

            }
        }
        
        if (!bExists) 
        {
            People op = new People();
            op.setName(name);
            allPeople.add(op);
            System.out.println(name + " has been added");
        }
        

    }

    private void listAll() {

        try {
            People p = null;
            int value = 0;
            ListIterator li = allPeople.listIterator();
            while (li.hasNext()) {
                p = (People) li.next();
                value = p.getTotalValue();
                System.out.println(p.getName() + " " + Integer.toString(value) + " USD.");
            }
        } catch (NullPointerException e) {
            System.out.println("You don't have any people in your list.");
        }
    }

    private People getPerson(String namn) {
        People p = null;
        ListIterator li = allPeople.listIterator();
        while (li.hasNext()) {
            p = (People) li.next();
            if (p.getName().equalsIgnoreCase(namn)) {
                return p;
            }
        }
        return null;
    }

    public People getRichest() {

        int prevVal = -1;
        int thisVal = -1;
        People p = null;
        People richest = null;
        ListIterator li = allPeople.listIterator();
        while (li.hasNext()) {
            p = (People) li.next();
            thisVal = p.getTotalValue();
            if (prevVal < thisVal) {
                prevVal = thisVal;
                richest = p;
            }
        }
        if (richest != null) {
            System.out.println("The one with most money is: \n "
                    + richest
                    + "\nWho has " + richest.getTotalValue() + " USD in total.");
            System.out.println(richest.getItem().toString());
        } else {
            System.out.println("All are poor.");
        }

        return richest;

    }

    public void searchPerson() {

        boolean found = false;
        while (!found) {
            System.out.println("Who are you searching for? ");
            String name = keyboard.nextLine();
            int i = 0;
            while (i < allPeople.size()) {
                People p = allPeople.get(i);
                if (p.getName().equalsIgnoreCase(name)) {
                    System.out.println(p);
                    System.out.println(p.getItem().toString());
                    found = true;
                    break;
                } else {
                    found = false;
                }
                i++;
            }
            if (!found) {
                System.out.println("Not found.");
                break;
            }
        }

    }

    public void stockCrash() {
        System.out.println("All stocks are now worthless!");
        for (People p : allPeople) {
            for (Item i : p.getItem()) {
                if (i instanceof Stock) {
                    ((Stock) i).setPriceZero();
                }
            }
        }
    }

    public void showItems() {
        People p = null;
        p = getRichest();
        p.showAllItems();


    }

    public void testMe() {
        People p = new People();
        allPeople = new ArrayList<>();
        p.setName("Ulf");
        p.addItem(new Stock("Varg", 50));
        p.addItem(new Stock("Äpple", 200));

        allPeople.add(p);

        p = new People();
        p.setName("Birger");
        p.addItem(new Stock("Ericsson", 33));
        p.addItem(new Stock("SBAB", 10));
        allPeople.add(p);

        p = new People();
        p.setName("Lisa");
        p.addItem(new Stock("Gnu", 80));
        p.addItem(new Stock("Elefant", 100));
        allPeople.add(p);

        //showItems();
        listAll();

    }

    public static void main(String[] args) {

        PeopleAndItems pai = new PeopleAndItems();
        pai.run();;

    }
}
