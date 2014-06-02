import java.io.*;
import java.util.*;

public class ValuablesRegistry {

    private Scanner scan = new Scanner(System.in); 
    private ArrayList<Person> allPeople = new ArrayList<>();
    
    public void load(){
        try{
            FileInputStream fil = new FileInputStream("Valuables.obj");
            ObjectInputStream in = new ObjectInputStream(fil);
            allPeople = (ArrayList<Person>)in.readObject();
            }
        catch (FileNotFoundException e){
        }
        catch (IOException e){
        System.exit(2);
        }
        catch (ClassNotFoundException e){
        System.exit(3);
        }
    }
    
    public void save(){
        try{
            FileOutputStream fil = new FileOutputStream("Valuables.obj");
            ObjectOutputStream out = new ObjectOutputStream(fil);
            out.writeObject(allPeople);
            }
        catch (IOException e){
        System.exit(1);
            }
    }
    
    public int readInt(String query){
        for(;;){
            try{
                System.out.println(query);
                int answer=Integer.parseInt(scan.nextLine());
                return answer;
            }
            catch (NumberFormatException e){
            System.out.println("Not a valid number");
            }
        }
    }
    
    public double readDouble(String query){
        for(;;){
            try{
                System.out.println(query);
                double answer=Double.parseDouble(scan.nextLine());
                return answer;
            }
            catch (NumberFormatException e){
            System.out.println("Not a valid number");
            }
        }
    }
    
    public String readString(String query){
        System.out.println(query);
        String answer = scan.nextLine();
        return answer;
    }
    
    public Person getPerson(String name){
        for (Person p : allPeople){
            if (p.getName().equalsIgnoreCase(name)){
                return p;
            }       
        }
        return null;
    }
    
    public void makePerson(){
        String name = readString("Name of Person?");
        Person checkPerson = getPerson(name);
        if (checkPerson != null){
            System.out.println("That person already exists.");
        }
        else{
            Person newPerson = new Person(name);
            allPeople.add(newPerson);
            System.out.println(newPerson.getName() + " has been created.");
        }
    }
    
    public void makeValuable(){
        String name = readString("Who owns it?");
        Person p = getPerson(name);
        if (p == null){
            System.out.println("No such person.");
        }
        else{
            System.out.print("1. Stocks.\t");
            System.out.print("2. Jewelry.\t");
            System.out.println("3. Electronics.");
            int type = readInt("Type of item?");
            switch (type){
                case 1:
                    String stockName = readString("Name of item?");
                    int posts = readInt("Number of stockposts?");
                    double price = readDouble("Price per piece?");
                    Valuable s = new Stocks(p.getName(), stockName, posts, price);
                    p.addValuable(s);
                    break;
                case 2:
                    String jewelryName = readString("Name of item?");
                    String metal = readString("Gold or silver? (g/s)");
                    boolean metalType;
                        if (metal.equalsIgnoreCase("g")) {
                            metalType = true;
                        }
                        else if (metal.equalsIgnoreCase("s")){
                            metalType = false;
                        }
                        else{
                            System.out.println("Must choose g or s.");
                            metalType = false;
                        }
                    int rocks = readInt("Number of stones?");
                    Jewelry j = new Jewelry(p.getName(), jewelryName, rocks, metalType);
                    p.addValuable(j);
                    break;
                case 3:
                    String itemName = readString("Name of item?");
                    int usage = readInt("How worn out is it(10-1)?");
                    double piecePrice = readDouble("Price of item?");
                    Electronics e = new Electronics(p.getName(), itemName, piecePrice, usage);
                    p.addValuable(e);
					break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
    
    public void printPeople(){
        System.out.println("People in register:");
        for (Person p : allPeople){
            System.out.println(p);
        }
    }
    
    public void printPerson(){
        String name = readString("Name of person?");
        if (getPerson(name) == null){
            System.out.println("There is no person by that name registered.");
        }    
        else {
            Person p = getPerson(name);
            System.out.println(p);
            System.out.println("");
            p.printValuables();  
            }
    }
    
    public void printRichest(){
        System.out.print("Richest: ");
        Person richest = new Person(null);
        for (Person p : allPeople){
            if (p.getWealth() >= richest.getWealth()){
                richest = p;
            }
        }
        System.out.println(richest);
        System.out.println("");
        richest.printValuables();
    }
    
    public void printMostExpensive(){
        Valuable mostExpensive = new Valuable(null, null);
        for (Person p : allPeople){
            if (p.getMostExpensive().getValue() > mostExpensive.getValue()){
                mostExpensive = p.getMostExpensive();
            }
        }
        if (mostExpensive.getValue() > 0){
            System.out.println("Most Expensive item: ");
            System.out.println(mostExpensive.getOwner()+" "+mostExpensive.toString()); 
        }
        else {
            System.out.println("No items in registry."); 
        }
    }
    
    public void stockCollapse(){
        for (Person p : allPeople){
            p.stockCollapse();
        }
        System.out.println("The stock market has collapsed.");
    }
    
    public void removeMenu(){
        System.out.print("1. Remove person.\t");
        System.out.println("2. Remove valuable.");
        int choice=readInt("");
            switch (choice){
                case 1: 
                    removePerson();
                    break;
                case 2:
                    removeValuable();
                    break;
                default:
                    System.out.println("Invalid command");
            }
    }
    
    public void removeValuable(){
        String name = readString("Name of person owning the item.");
        if (getPerson(name) != null){
            Person p = getPerson(name);
            p.printValuables();
            String itemName = readString("Name of item to be removed.");
            if (p.getValuable(itemName) != null){
                Valuable v = p.getValuable(itemName);
                p.removeValuable(v);
            }
            else{
                System.out.println("No such item.");
            }
        }
        else{
            System.out.println("No such person.");
        }
    }
    
    public void removePerson(){
        String name = readString("Name of person to be removed.");
        if (getPerson(name) != null){
            System.out.println(getPerson(name).getName()+" has been removed.");
            allPeople.remove(getPerson(name));
        }
        else {
            System.out.println("There is no person with that name.");
        }
    }
    
    public static void main(String[] args) {       
        ValuablesRegistry run= new ValuablesRegistry();
        
        run.load();
        
        System.out.println("Valuables Registry.");
        for(;;){
            System.out.print("1. Make new person.\t");
            System.out.println("2. Make new valuable.");
            System.out.print("3. Display all people.\t");
            System.out.println("4. Display person.");
            System.out.print("5. Display richest.\t");
            System.out.println("6. Stock market collapse.");
            System.out.print("7. Remove item/person.\t");
            System.out.println("8. Show most expensive item.");
            System.out.println("9. Quit");
            int selection=run.readInt("Command(1-9):");
            switch (selection){
                case 1: 
                    run.makePerson(); 
                    break;
                case 2: 
                    run.makeValuable(); 
                    break;
                case 3: 
                    run.printPeople();
                    break;
                case 4: 
                    run.printPerson();
                    break;
                case 5: 
                    run.printRichest();
                    break;
                case 6: 
                    run.stockCollapse();
                    break;
                case 7:
                    run.removeMenu();
                    break;
                case 8:
                    run.printMostExpensive();
                    break;                    
                case 9: 
                    System.out.println("Thank you and goodbye.");
                    run.save();
                    System.exit(0);
					break;
                default: System.out.println("Invalid command. Please retry.");
            }
        }
    }//end of main
}
