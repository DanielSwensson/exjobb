import java.util.ArrayList;
import java.util.Scanner;

public class ValuableManaging {
    private Scanner keyboard = new Scanner(System.in);
    private ArrayList<Person> allPersons = new ArrayList<Person>();
    
    public static void main(String[] args){
        new ValuableManaging();
    }
    
    public ValuableManaging(){
        boolean cont = true;
        while (cont){
            int command = getInt("Please enter a command(1: Register person, 2: List all registered persons, 3: Create and assign a item to a user, 4: Show the person with the most assets, 5: Show a specific person, 6: Stock market crash 7: terminate session): ");
            switch (command) {
                case 1:
                    registerNewPerson();
                    break;
                case 2:
                    listRegisteredPersons();
                    break;
                case 3:
                    assignItemOwner();
                    break;
                case 4:
                    showRichestPerson();
                    break;
                case 5:
                    showSpecificPerson();
                    break;
                case 6:
                    stockMarketCrash();
                    break;
                case 7:
                    cont = false;
                    break;
                default: 
                    System.out.println("That is not a valid command, please enter a valid command");
            }
        }
    }
    
    public boolean checkRegister(String name){
        boolean alreadyregistered=false;
        for (Person p : allPersons){
            if (p.getName().equalsIgnoreCase(name)){
                alreadyregistered=true;
            }
        }
        return alreadyregistered;
    }

    public void showRichestPerson(){
        Person richest=null;
        double assets=0;
        for (Person p : allPersons){
            if (p.assets()>=assets){
                richest=p;
                assets=p.assets();
            }
        }
        if(richest!=null){
            richest.listAllInfo();
        }
    }
        
    public void showSpecificPerson(){
        String name = getString("Who do you want to see specific information about?: ");
        if (checkRegister(name)){
            for (Person p : allPersons){
                if (p.getName().equalsIgnoreCase(name)){
                    p.listAllInfo();
                }
            }
        }else{
            System.out.println("The person you specified was not found in the register");
        }
    }
    
    public void stockMarketCrash(){
        for(Person p : allPersons){
            p.stockMarketCrash();
        }
        System.out.println("All shares have reached a worth of zer0!");
    }
    
    public Valuable createAndAssignItem(){
            int command = getInt("What kind of item do you want to assign to the selected person(1: A jewelery, 2: a shareholding, 3: a technical device): ");
            for (;;){
            switch (command) {
                case 1:
                    return createJewelery();
                case 2:
                    return createShare();
                case 3:
                    return createDevice();
                default: 
                    System.out.println("That is not a valid item-command, please enter a valid command");
            }
        }
    }
    
    public Valuable createDevice(){
        String dname=getString("what kind of device is it?: ");
        int value=getInt("How much did it cost?: ");
        int condition;
        do{
            condition=getInt("In how good condition is it(enter a number between 1-10, where 1 is very bad condition)?: ");
        }while(condition<1 || condition>10);
        TechnicalDevice device=new TechnicalDevice(dname, value, condition);
        return device;
    }
    
    public Valuable createShare(){
    String sname=getString("What is the name of the shares?: ");
    int quantity=getInt("How many is it?: ");
    int baseWorth=getInt("For what price were they bought?: ");
    Shareholding share=new Shareholding(sname, quantity, baseWorth);
    return share;
    }
    
    public Valuable createJewelery(){
        String silverOrGold = getString("is it made fom gold or silver?: ");
        int gems=getInt("how many gems is in the jewelery?: ");
        String type=getString("what kind of jewelery is it(ring, necklace etc.)?: ");
        if(silverOrGold.equalsIgnoreCase("gold")){
            Jewelery jwl=new GoldJewelery(type,gems);
        return jwl;
        }else{
            Jewelery jwl=new SilverJewelery(type,gems);
        return jwl;
        }
    }
            
    public void registerNewPerson(){
        String name = getString("What is the name of the one you want to register?: ");
        Person registering = new Person(name);
        if (!checkRegister(name)){
            allPersons.add(registering);
            System.out.println(registering.getName()+" is now registered in the system.");
        }else{
            System.out.println("This person is already registered");
        }
    }
    
    public void listRegisteredPersons(){
        for (Person p : allPersons){
                System.out.println(p);
        }
    }
    
    public void assignItemOwner(){
        String owner = getString("Who is the owner for the item?: ");
        if (checkRegister(owner)){
            for (Person p : allPersons){
                if (p.getName().equalsIgnoreCase(owner)){
                    System.out.println("The user: "+p.getName()+" is now selected");
                    p.addItem(createAndAssignItem());
                    System.out.println("The new item is now registered with "+p.getName()+" as owner");
                }
            }
        }else{
            System.out.println("The person you specified was not found in the register");
        }
    }
    
    public String getString (String message){
        System.out.print(message);
        String str = keyboard.nextLine();
        return str;
    }
        
    public int getInt (String message){
        int integer;
        for(;;){
            try{
                System.out.print(message);
                integer = Integer.parseInt(keyboard.nextLine());
                return integer;
            }
            catch(NumberFormatException e){
                System.out.println("please enter valid value");
            }
        }
    }
    
}
