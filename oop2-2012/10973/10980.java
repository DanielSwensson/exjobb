

/**
 *
 * @author Tor Brambeck
 */
import java.util.*;
public class Huvudprogram {
    public Huvudprogram(){
        this.start();
    }
    
    private ArrayList<Personer> allaPersoner = new ArrayList<Personer> ();
    
    private static Scanner keyboard = new Scanner(System.in);
    
    public void start(){
        while (true){
               boolean l = true;
               do{
                   try{
                        System.out.println(" ");
                        System.out.println("Välj en åtgärd nedan: ");
                        System.out.println("1. Skapa person ");
                        System.out.println("2. Skapa pryl ");
                        System.out.println("3. Visa alla ");
                        System.out.println("4. Visa rikast ");
                        System.out.println("5. Visa viss person ");
                        System.out.println("6. Börskrasch");
                        System.out.println("7. Avsluta program");                       
                        int respond = Integer.parseInt(keyboard.nextLine());
                        l = false;
                        switch(respond){
                        case 1:
                            addPerson();
                            break;
                       case 2:
                            addPryl();
                            break;
                       case 3:
                            printTotal();
                            break;
                       case 4:
                            showRichest();
                            break;
                       case 5:
                            printPerson();
                            break;
                       case 6:
                            stockCrasch();
                            break;
                       case 7:
                                System.out.print("Är du säker? (Yes/No)");
                                String quit = keyboard.nextLine();
                                if(quit.equals("Yes")){
                                    System.out.print("Systemet avslutas");
                                    System.exit(1);
                                }
                                else if(quit.equals("No")){
                                    break;
                                }
                            break;
                       default:
                            System.out.println(respond + " är inte ett giltigt kommando");         
                            break;
                        }
                   }
                   catch(Exception e){
                       System.out.println("Ange åtgärd genom att välja en siffra 1-7");
                       break;
                   }
               }while(l == true);
           }
    }
    
    public void addPerson(){
        System.out.println("Ange personens namn: ");
        String inputName = keyboard.nextLine();
        if(allaPersoner.size() !=0){
            boolean notFound = true;
            for (Personer p : allaPersoner){
                if (p.getName().equalsIgnoreCase(inputName)){
                    System.out.println(inputName + " finns redan i registret");
                        notFound = false;
                }
            }
            if (notFound == true){
                allaPersoner.add(new Personer(inputName));
            }
         }
        else{
            allaPersoner.add(new Personer(inputName));
        }
    }
    
    public void addPryl(){      
        System.out.println("Vem äger prylen? ");
        String addToPerson = keyboard.nextLine();
        int j = 0;
        for(Personer p : allaPersoner) {
                if(p.getName().equals(addToPerson)){
                        System.out.println("Personen " + addToPerson + " får en ny pryl");
                        j = 1;
                }
                while(j == 1){
                    int u = 1;
                    do{
                        try{
                            System.out.println("Vad är det för typ av pryl? ");
                            System.out.println("1. Aktie");
                            System.out.println("2. Smycke");
                            System.out.println("3. Apparat");
                            int answer = Integer.parseInt(keyboard.nextLine());
                            u = 2;
                            switch(answer){
                            case 1:
                                int z = 1;
                                do{
                                    try{                                        
                                        System.out.print("Ange företagets namn: ");
                                        String inputCompany = keyboard.nextLine();
                                        System.out.print("Ange inköpspris: ");
                                        double inputPrice = Double.parseDouble(keyboard.nextLine());
                                        System.out.print("Ange antal aktier: ");
                                        int inputAmount = Integer.parseInt(keyboard.nextLine());
                                        p.addPryl(new Aktie(inputCompany, inputPrice, inputAmount));
                                        z = 2;
                                        j = 2;
                                        break;
                                    }
                                    catch(NumberFormatException e){
                                        System.out.println("Ange antalet aktier och inköpris som siffror!");
                                    }
                                }while(z==1);
                                break;
                                
                             case 2:
                                int y = 1;
                                do{
                                    try{
                                        System.out.print("Ange typ av smycke: ");
                                        String inputType = keyboard.nextLine(); 
                                        System.out.print("Ange antal stenar: ");
                                        int inputStones = Integer.parseInt(keyboard.nextLine());
                                        System.out.print("Ange material (Guld/Silver): ");
                                        String inputMaterial = keyboard.nextLine();
                                        p.addPryl(new Smycke(inputType, inputStones, inputMaterial));
                                        y = 2;
                                        j = 2;
                                        break;
                                    }
                                    catch (NumberFormatException e){
                                        System.out.println("Ange slitaget och antal stenar som siffror!");
                                    }
                                }while(y==1);
                                break;
                                
                            case 3:
                                int x = 1;
                                do{
                                    try{
                                    System.out.print("Ange typ av apparat: ");
                                    String inputAppart = keyboard.nextLine();
                                    System.out.print("Ange slitage (1-10): ");
                                    int inputUsage = Integer.parseInt(keyboard.nextLine());
                                    System.out.print("Ange inköpspris: ");
                                    double inputAppartPrice = Double.parseDouble(keyboard.nextLine());
                                    p.addPryl(new Appart(inputAppart, inputUsage, inputAppartPrice));
                                    x = 2;
                                    j = 2;
                                    break;
                                    }
                                    catch (NumberFormatException e){
                                    System.out.println("Slitaget och inköpspris måste anges som siffror!");
                                    }
                                }while(x==1);
                                break;
                                
                            default:
                            System.out.println("Inte ett giltigt kommando");
                            }
                            break;
                        }
                                catch(NumberFormatException e){
                                    System.out.println("Lägg till en pryl genom att ange sifforna l-3");
                                }
                    }while(u ==1);
                }
        }
        if(j==0){
        System.out.println("Personen " + addToPerson +  " finns inte i listan:");
        }
    }

    
    public void printTotal(){
        System.out.println("Dessa personer finns registerade i listan: ");
        for(Personer p : allaPersoner){
        p.totalAssets();
        System.out.println(p.toStringAssets());
        }
    }
    
    public void showRichest(){
        Personer richest = new Personer("Ingen");
        for (Personer p : allaPersoner){
            if(p.totalAssets() > richest.totalAssets()){
                richest = p; 
            }
        }
        System.out.println(richest.toStringRichest());
        richest.printAllStuff();
    }
    
    public void printPerson(){
        System.out.println("Ange vilken persons prylar som skall visas: ");
        String showPerson = keyboard.nextLine();
        int k = 0;
        for(Personer p : allaPersoner) {
            if(p.getName().equals(showPerson)){
                k = 1;
                while(k==1){
                System.out.println("Visar prylar för " + showPerson);
                p.printAllStuff();
                break;
                }
            }
        }
        if(k==0){
        System.out.println("Personen " +showPerson + " finns inte listan");
        }
    }
    
    public void stockCrasch(){
        System.out.print("Dagens datum är den 29 oktober 1929, alla aktier är nu värda 0 kr");
        for(Personer p : allaPersoner){
            p.setStocksZero();
        }        
    }    
}
    
