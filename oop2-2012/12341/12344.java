import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable{
    private String name;
    private ArrayList<Valuable> allValuables = new ArrayList<>();
    
    Person(String perName){
        name = perName;
    }
    
    public String getName(){
        return name;
    }
    
    public void addValuable(Valuable v){
        allValuables.add(v);
    }
   
    public void removeValuable(Valuable v){
        allValuables.remove(v);
    }
    
    public Valuable getValuable(String name){
        for (Valuable v : allValuables){
            if (v.getName().equalsIgnoreCase(name)){
                return v;
            }       
        }
        return null;
    }
    
    public void printValuables(){
        for (Valuable v : allValuables){
            System.out.println(v);
        }
    }
    
    public double getWealth(){
        double w = 0;
        try{
            for (Valuable v : allValuables){
                w += v.getValue();
            }
        }
        catch (NullPointerException e){
            System.out.println("No valuables registered to this person.");
        }
        return w;
    }
    
    public Valuable getMostExpensive(){
        Valuable expensive = new Valuable(null, null);
        for (Valuable v : allValuables){
            if (v.getValue() >= expensive.getValue()){
                expensive = v;
            }
        }
            return expensive;
    }
    
    public void stockCollapse(){
        for (Valuable v : allValuables){
            if (v instanceof Stocks);{
                v.changeValue(0);
            } 
        }
    }
    
    public String toString(){
        return getName() + " " + getWealth();
    }
    
}