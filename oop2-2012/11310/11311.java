/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inlupp2_valuables;
import java.util.List;
import java.util.ArrayList;
import static java.util.Arrays.asList;

/**
 *
 * @author Robin Hem
 */
public class Register {
    private ArrayList <Person> peopleArray = new ArrayList<Person> ();
    private List<String> itemTypes = asList("appliance","stock","valuable");

    public void showList(int list){
        boolean quit = false;
        Query q = new Query();
        int intInput = 0;

        switch(list){
            case 0:
                System.out.print(
                "1. Register new item. \n" +
                "2. Register new person. \n" +
                "3. List users. \n" +
                "4. List user items. \n" +
                "5. List richest user. \n" +
                "6. Stockmarket crash \n" +
                "7. Quit program. \n" + ": ");
                
                intInput = Integer.parseInt(q.askQuestion("Int", "", "Invalid or empty input, try again. "));
                System.out.print("\n");

                    switch(intInput){
                        case 1: this.showList(1);
                                break;
                        case 2: this.showList(2);
                                break;
                        case 3: this.showList(3);
                                break;
                        case 4: this.showList(4);
                                break;
                        case 5: this.showList(5);
                                break;
                        case 6: this.showList(6);
                                break;
                        case 7: this.showList(7);
                                break;
                        default: System.out.println("Invalid Command.");
                                 this.showList(0);
                                 break;
                    }
                break;
            case 1:
                this.regItem();
                break;
            case 2:
                this.regPerson();
                break;
            case 3:
                this.listPeople();
                break;
            case 4:
                this.listItems();
                break;
            case 5:
                this.showRichest();
                break;
            case 6:
                this.stockCrash();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                this.showList(0);
                break;
        }
        this.showList(0);
    }

    private boolean validateItem(String type){
        boolean valid = false;
        type = type.toLowerCase();
            for(String i: this.itemTypes)
            {
                if(i.equals(type))
                {
                    valid = true;
                }
            }
        return valid;                
    }

    private void addPerson(String name){
        Person p = new Person(name);
        this.peopleArray.add(p);
    }

    private void regPerson(){
        Query q = new Query();
        String pName = q.askQuestion("String", "Input person name: ", "Invalid name or empty input.");
        
        if(existsPerson(pName)){
            System.out.println("Person by that name already exists!");
        }
        else{
            System.out.println("Person registered.");
            this.addPerson(pName);
        };
    }

    private void addItem(Person p , Item item){
        p.addItem(item);
    }

    private Person findPerson(String person){
        Person owner = null;
            for(Person p: this.peopleArray)
            {
                if(p.getName().equalsIgnoreCase(person))
                {
                    owner = p;
                }
            }
        return owner;
    }

    private boolean existsPerson(String person){
        boolean done = false;
            for(Person p: this.peopleArray)
            {
                if(p.getName().equalsIgnoreCase(person))
                {
                    done = true;
                }
            }
        return done;
    }

    private void regItem(){
        Item newItem = null;
        Person iOwner = null;
        String iName = null;
        String iType1 = "";
        String iType2 = "";
        Query q = new Query();

        iName = q.askQuestion("String", "Input item owner: ","No owner specifed, try again.");

        if(this.existsPerson(iName)){
            iOwner = this.findPerson(iName);
        }else{
            System.out.print("User doesn't exist, returning to menu. \n \n");
            this.showList(0);
        }
        
        while(!this.validateItem(iType1))
            iType1 = q.askQuestion("String", "Input item type: ", "No type specified, try again.");
        
        iType2 = q.askQuestion("String","Input " + iType1 + " name: ", "No " + iType1 + " specified, try again.");

        if(iType1.equalsIgnoreCase("appliance")){
            Double itemCost = Double.parseDouble(q.askQuestion("Double", "Input Appliance cost: ", "No cost specified, try again."));
            int itemWear = Integer.parseInt(q.askQuestion("Int", "Input Appliance wear: ", "No wear specified, try again."));
            
            newItem = new Appliance(iType2, itemCost, itemWear);
            iOwner.addItem(newItem);
            System.out.print(iType2 + "added to user. \n \n");
        }
        
        else if(iType1.equalsIgnoreCase("stock")){
            int stockCount = Integer.parseInt(q.askQuestion("Int", "Input Stock amount: ", "No amount specified, try again."));
            Double stockValue = Double.parseDouble(q.askQuestion("Double", "Input Stock value(per stock): ", "No value specified, try again."));
            newItem = new Stock(iType2, stockValue, stockCount);

            iOwner.addItem(newItem);
            System.out.print(iType2 + "added to user. \n \n");
        }

        else if(iType1.equalsIgnoreCase("valuable")){
            int gemCount = Integer.parseInt(q.askQuestion("Int", "Input gem count: ", "No amount specified, try again."));
            String itemMaterial = q.askQuestion("String", "Input item material(silver/gold): ", "No value specified, try again.");

            newItem = new Valuable(iType2, gemCount, itemMaterial);
            iOwner.addItem(newItem);
            System.out.print(iType2 + "added to user. \n \n");
        }
        else{
            System.out.println("Incorrect item type.");
        }
    }

    public void regRandItem(){
        //Never got this done.
    }

    private void listItems(){
        Query q = new Query();
        boolean done = false;
        Person p = null;
        
        String iOwner = q.askQuestion("String", "Input user to display items for: ", "Invalid or empty input, try again.");
        System.out.print("\n");
            if(existsPerson(iOwner)){
                p = this.findPerson(iOwner);
                this.printItems(p.getItems());
            }
            else
                System.out.println("User doesn't exist!");
    }

    private void printItems(ArrayList <Item> itemArray){
        int count = 0;
        for (Item i : itemArray) {
            System.out.print(i);
            count++;
        }
        if (count == 0) {
            System.out.println("User has no items!");
        }
    }

    private void listPeople(){
        System.out.println("|User Register|");
        for(Person p: this.peopleArray){
            System.out.print(p);
        }
        System.out.print("\n");
    }

    private void showRichest(){
        Double value = 0.0;
        Person pRich = null;
        
        for(Person p: peopleArray){
            if(p.getTotalValue() > value){
                value = p.getTotalValue();
                pRich = p;
            }
        }
        
        if(value != 0){
            System.out.println("Richest person is " + pRich.getName() +
                    " with a total value of " + value);
            this.printItems(pRich.getItems());
        }else{
            System.out.print("No users present or nobody with value present. \n \n");
        }
                

    }

    private void stockCrash(){
        int count = 0;
        for(Person p: peopleArray){
            ArrayList <Item> iArray = p.getItems();
            for(Item i: iArray){
                if(i instanceof Stock)
                {
                    i.setValue(0.0);
                    count++;
                }
            }

            if(count > 0){
                System.out.print("Stock crashed! \n");
            }
            
        }
        System.out.print("\n");
    }

    private void deleteItem(){

    }

    public static void main(String[] args) {
        Register r = new Register();
        r.showList(0);
    }
}
