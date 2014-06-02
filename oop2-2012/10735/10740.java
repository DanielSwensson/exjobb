// Tjena! Tänkte bara ge lite information angående navigering i koden för att göra det 
// lite enklare. All kod för att skapa saker är över huvudmenyn (som är ungefär i mitten av programmet).
// All kod för saker som börskrasch, hitta personer, säker inläsning, etc. ligger under huvudmenyn.
// Och allra längst ned i koden är main-metoden.
//          Happy reading!
//      MVH Emil af Jochnick.

import java.util.ArrayList;
import java.util.Scanner;

public class Register{
    private ArrayList <Person> people;
    private Scanner keyboard;

    public Register() {
        people = new ArrayList <Person>();
        keyboard = new Scanner (System.in);
        menu();
    }

    public void createPerson(){

        String name = readString("What is the name of the person?");

        for (Person p : people){
            if(p.getName().equalsIgnoreCase(name)){
                System.out.println("This person already exists! This program does not allow cloning.");
                return;
            }
        }

        Person p = new Person(name);
        people.add(p);
        System.out.println(name + " was successfully added to the register! Huzzah!");

    }

    public void createItem(){
        int chooseItem = readInt("Choose what you want to create!\n"+
                "1. Create Jewelry!\n"+
                "2. Create a device!\n"+
                "3. Create stocks!");
        switch (chooseItem){
            case 1:
            createJewelry();
            break;

            case 2:
            createDevice();
            break;

            case 3:
            createStock();
            break;

            default:
            System.out.println("You can't type that, fool!");
            break;
        }
    }

    public void createJewelry(){

        boolean material = false;
        boolean materialCheck = false;

        while (materialCheck == false){

            int materialChoice = readInt("Is the jewelry of gold or silver?\n"+
                    "1. Gold\n"+
                    "2. Silver");

            switch (materialChoice){
                case 1:
                material = true;
                materialCheck = true;
                break;

                case 2:
                material = false;
                materialCheck = true;
                break;

                default:
                System.out.println("You can't type that! Type correctly or be destroyed!");
            }
        }

        int gems = readInt("How many gems does the jewelry possess?");
        
        gems = gems * 500;
        
        String name = readString("What is the name of the jewelry?");

        Jewelry i = new Jewelry (name, material, gems);
        addItem(i);
    }

    public void createDevice(){
        String name = readString("What is the name of the device?");

        int devicePrice = readInt("What was the original price of the device?");

        boolean qualityCheck = false;
        while (qualityCheck == false){
            double quality = readInt("What is the quality of the device? Choose between 1 - 10, 10 being perfect quality and 1 being worst");
            if  (quality > 10 || quality < 1){
                System.out.println("The device can not have this quality number, try again, fool!");
            } else {
                quality = quality / 10;
                qualityCheck = true;
                Device i = new Device (name, devicePrice, quality);
                addItem(i);
            }
        }
    }

    public void createStock(){
        String name = readString("In which company do you own stocks?");

        int amount = readInt("What is the amount of stocks?");

        int stockPrice = readInt("What is one stock worth?");

        Stock i = new Stock (name, amount, stockPrice);
        addItem(i);
    }

    public void addItem(Item i){

        String owner = readString("What is the name of the owner?");

        for (Person p : people){
            if(p.getName().equalsIgnoreCase(owner)){
                p.getPossesions().add(i);
                System.out.println("The reigster added the item to " + owner + " Successfully!");
                return;
            }
        }
        System.out.println("This person does not exist in the register!");
    }

    public void menu(){
        boolean x = false;
        while (x == false){   
            int menu = readInt("Welcome to the menu! Navigate by using the keys 1 - 7 on your keyboard! \n"+
                    "1. Create a person\n"+
                    "2. Create an item\n"+
                    "3. Show all\n"+
                    "4. Show wealthiest\n"+
                    "5. Show specific person\n"+
                    "6. Innitiate stockmarket crash\n"+
                    "7. Exit program\n");
            switch (menu)
            {
                case 1:
                createPerson();
                break;

                case 2:
                createItem();
                break;

                case 3:
                showAll();

                break;
                case 4:
                getWealthiest();
                break;

                case 5:
                showPerson();
                break;

                case 6:
                stockMarketCrash();
                break;

                case 7:
                System.out.println("Good bye, dude.");
                x = true;
                break;

                default:
                System.out.println("Impossibru! Fooluru!");
                break;
            }
        }
    }

    public int readInt(String question){
        for(;;){
            try {
                System.out.println(question + " ");
                int input = Integer.parseInt(keyboard.nextLine());    
                return input;
            }
            catch (NumberFormatException e) {
                System.out.println("Wrong! Ye must insert a number ye dirty pirate!");
            }
        }
    }

    public String readString(String question){
        String input=null;
        while (input==null || input.length()<1){
            System.out.println(question + " ");
            input=keyboard.nextLine();
            input=input.replaceAll("\\W", "");
        }
        return input;
    }

    public void showAll(){

        if(people.size() > 0){
            for (int n = 0; n < people.size(); n++){  
                System.out.println(people.get(n));
            }
            return;
        }
        System.out.println("There are no people in the register! You fool!");
    }

    public void getWealthiest(){
        int a = 0;
        double wealthiest = 0;

        if(people.size() > 0){
            for(int n = 0; n < people.size(); n++){  
                if(people.get(n).getWealth() > wealthiest){
                    a = n;
                    wealthiest = people.get(n).getWealth();
                }
            }
            Person p = people.get(a);

            System.out.println(p);
            System.out.println(p.showPossesions());
            return;
        }
        System.out.println("There are no people in the register! Save mankind by creating people!");
    }

    public void showPerson(){

        if(people.size() > 0){
        String input = readString("WWhich person to you wish to show?");

        for (int n = 0; n < people.size(); n++){
            if(people.get(n).getName().equalsIgnoreCase(input)){
                System.out.println(people.get(n) +  "\n" + people.get(n).showPossesions());
                return;
            }
        }

        System.out.println("This person does not exist! YOU LIE!");
        return;
    }
        System.out.println("There are no people in the register! Stop playing around!");
}

    public void stockMarketCrash(){
        if(people.size() > 0){

            for (int n = 0; n < people.size(); n++){
                people.get(n).findStocks();
            }
            System.out.println("The market has crashed, oh snap! All stocks are worth nothing!");
            return;
        }
        System.out.println("There are no people in the register!");
    }

    public static void main (String []args){
        new Register();
    } 
}