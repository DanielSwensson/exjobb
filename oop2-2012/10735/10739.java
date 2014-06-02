import java.util.ArrayList;

public class Person{
    private String name;
    private ArrayList <Item> possesions = new ArrayList<Item>();

    public Person(String name){

        this.name = name;
        this.possesions = possesions;

    }

    public String getName(){

        return name;

    }

    public ArrayList<Item> getPossesions(){

        return possesions;

    }

    public double getWealth(){

        double wealth = 0;

        for(Item i : possesions){
            wealth += i.getValue();
        }
        return wealth;
    }

    
    
    public String toString(){
        return "Name: " + name + "           Wealth: " + getWealth() + "\n";      
    }
    
    
     public void findStocks(){

        for(Item i : possesions){
            if(i instanceof Stock){
                Stock s = (Stock)i;
                s.setPrice();
            }
        }
    }
    
    
    public String showPossesions(){

        String things = "";

        for(Item i : possesions){
           things += i + "\n";
        }
        return things;
    }
    
    
}