import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Erik Welander
 * @version 2012-02-04
 * Encoding: UTF-8
 * IDE: Netbeans 7.2.1
 */
public class Main {
   private ArrayList<Person>alPerson = new ArrayList<Person>();
   private boolean running = true;
    private Main(){
        loadStateFromFile();
        while(running){
            printMenu();
            evaluateChoice();
        }
    }
    private void printMenu(){
        System.out.println("==========Prylregister V 2012-01-31==========\n"
        + "Av: Erik Welander\n"
        + "1. Skapa person\n"
        + "2. Skapa pryl\n"
        + "3. Visa alla\n"
        + "4. Visa Rikaste\n"
        + "5. Visa viss person\n"
        + "6. Börskrash\n"
        + "7. Ta bort person\n"
        + "8. Ta bort sak\n"
        + "9. Avsluta");
    }
    private void evaluateChoice() {
        int choice = IOLib.askQuestionInt("");
        switch(choice){
            case 1:
                addPerson();
                break;
            case 2:
                addThing();
                break;
            case 3:
                showAll();
                break;
            case 4:
                showMostRich();
                break;
            case 5:
                showPerson();
                break;
            case 6:
                crashStock();
                break;
            case 7:
                deletePerson();
                break;
            case 8:
                deleteThing();
                break;
            case 9:
                quit();
                break;
        }
    }
   private void addPerson(){
       String name = IOLib.askQuestion("Vad heter den nya personen?");
       int id = findPerson(name);
       if(id == -1){
            alPerson.add(new Person(name));
            System.out.println(name+" är tillagd!");
       }
       else{
            System.out.println("\nEn person exiterar redan med det namnet\n");
       }
   }
   private void addThing(){
       String name = IOLib.askQuestion("Vilken person äger prylen: ");
       int id = findPerson(name);
       if(id == -1){
            System.out.println("Det existerar ingen användare med det namnet!");
            System.out.println("Skapa en ny användare eller kontrollera stavningen.\n\n");
            IOLib.askQuestion("Tryck för att fortsätta...");
       }
       else{
           String sort = IOLib.askQuestion("Vilken sorts pryl?");
           sort = sort.toLowerCase();
           if(sort.equals("smycke") || sort.equals("juvel")){
                String type = IOLib.askQuestion("Vilken sorts smycke?");
                String gold = IOLib.askQuestion("Är smycket av guld?");
                int stones = IOLib.askQuestionInt("Antal ädelstenar?");

                boolean isGold = false;
                if(gold.equals("ja")){isGold = true;}

                alPerson.get(id).ownsNewThing(new Jewelry(type, isGold, stones));
           }
           else if(sort.startsWith("aktie")){
                String stName = IOLib.askQuestion("Vad heter aktieposten?");
                int num = IOLib.askQuestionInt("Hur många har du?");
                int value = IOLib.askQuestionInt("Hur mycket är varje aktie värd?");

                alPerson.get(id).ownsNewThing(new StockShare(stName, value, num));
           }
           else if(sort.equals("apparat")){
                String type = IOLib.askQuestion("Vad är det för typ av apparat?");
                int price = IOLib.askQuestionInt("Hur mycket kostade apparaten?");
                int condition = IOLib.askQuestionInt("I vilket skick befinner sig apparaten?");
                
                alPerson.get(id).ownsNewThing(new Device(type, price, condition));
           }
           else{
               System.out.println("Det finns ingen sådan sorts pryl!");
               System.out.println("Försök igen...");
               addThing();
           }
       }
   }
   private int findPerson(String name){
       boolean found = false;
       int id = 0;
       for(; id < alPerson.size() && !found; id++){
           if(alPerson.get(id).getName().equals(name)) { found = true; }
       }
       if(!found){ id = -1; }
       else{id -= 1;}
       return id;
   }
   private void deletePerson(){
       String name = IOLib.askQuestion("Vilken person vill du ta bort?");
       int id = findPerson(name);
       if(id == -1){
            System.out.println("Det existerar ingen användare med det namnet!");
            System.out.println("Skapa en ny användare eller kontrollera stavningen.\n\n");
            IOLib.askQuestion("Tryck för att fortsätta...");
       }
       else{
            alPerson.remove(id);
       }   
   }
   private void deleteThing(){
       String name = IOLib.askQuestion("Vem tillhör saken?");
       int id = findPerson(name);
       if(id == -1){
            System.out.println("Det existerar ingen användare med det namnet!");
            System.out.println("Skapa en ny användare eller kontrollera stavningen.\n\n");
            IOLib.askQuestion("Tryck för att fortsätta...");
       }
       else{
           System.out.println(name+" äger följande saker:");
            for(int i = 0; i < alPerson.get(id).numOfThings(); ++i){
                System.out.println((i+1)+" "+alPerson.get(id).getThing(i));
            }
           int num = IOLib.askQuestionInt("Vilken vill du ta bort?");
           num -= 1;
           if(num < alPerson.get(id).numOfThings()){
               alPerson.get(id).deleteThing(num);
           }
           else{
               System.out.println("Ogiltigt nummer!");
               System.out.println("Försök igen...");
               deleteThing();
           }
       }   
   }
   
   private void showAll(){
       System.out.println("I registret finns: ");
       for(int i = 0; i < alPerson.size(); ++i){
           System.out.println(alPerson.get(i).getName()+" "+alPerson.get(i).getTotalValue());
       }
   }
   private void showMostRich(){
       int highest = 0;
       int highestPID = 0;
       int currentPerson = 0;
       for(int i = 0; i < alPerson.size(); ++i){
           currentPerson = alPerson.get(i).getTotalValue();
           if(currentPerson > highest){
               highest = currentPerson;
               highestPID = i;
           }
       }
       System.out.println("Rikast är "+alPerson.get(highestPID).getName()
               +" som sammanlagt äger "+alPerson.get(highestPID).getTotalValue());
       for(int i = 0; i < alPerson.get(highestPID).numOfThings(); ++i){
           System.out.println(alPerson.get(highestPID).getThing(i));
       }
   }
   private void showPerson(){
       String name = IOLib.askQuestion("Vad heter personen?");
       int id = findPerson(name);
       if(id == -1){
            System.out.println("Det existerar ingen användare med det namnet!");
            System.out.println("Skapa en ny användare eller kontrollera stavningen.\n\n");
            IOLib.askQuestion("Tryck för att fortsätta...");
       }
       else{
           System.out.println(name+" äger följande saker:");
           for(int i = 0; i < alPerson.get(id).numOfThings(); ++i){
               System.out.println(alPerson.get(id).getThing(i));
           }
       }
   }
   private void crashStock(){
       for(int i = 0; i < alPerson.size(); ++i){
           alPerson.get(i).stockShareCrash();
       }
       
   }
   private void saveStateToFile(String filename, ArrayList a){
        try {
            ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(filename));
            fileOut.writeObject(a);
            fileOut.close();
        } catch (IOException ex) {
            System.err.println("Failed to save to file: "+ex);
        }
   }
   private Object loadObjectsFromFile(String filename){
       ArrayList al = null;
       try{
       ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(filename));
       al = (ArrayList) fileIn.readObject();
       }
       catch(Exception ex){
           al = null;
       }
       return al;
       
   }
   private void loadStateFromFile(){
       if(loadObjectsFromFile("Persons") != null){
            alPerson = (ArrayList<Person>) loadObjectsFromFile("Persons");   
       }
   }
   private void quit(){
       System.out.println("Avslutar...");
       running = false;
       saveStateToFile("Persons", alPerson);
       System.exit(0);
   }
    public static void main(String[] args){
        new Main();
    }
}
