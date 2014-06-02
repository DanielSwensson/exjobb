
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Erik Welander
 * @version 2012-02-04
 * Encoding: UTF-8
 * IDE: Netbeans 7.2.1
 */
public class Person implements Serializable {
    private String name;
    private ArrayList<Thing> alThing = new ArrayList<Thing>();
    
    Person(String name){
        setName(name);
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void ownsNewThing(Thing t){
        alThing.add(t); 
        System.out.println("Added thing in index: "+alThing.size());
    }
    public int getTotalValue(){
        System.out.println("Thing size: "+alThing.size());
        int total = 0;
        for(int i = 0; i < alThing.size(); ++i){
            total += alThing.get(i).getValue();
        }
        return total;
    }
    public int numOfThings(){
        return alThing.size();
    }
    public Thing getThing(int id){
        return alThing.get(id);
    }
    public String getThingName(int id){
        return alThing.get(id).getName();
    }
    public void deleteThing(int id){
        alThing.remove(id);
    }
    public void stockShareCrash(){
        for(int i = 0; i< alThing.size(); ++i){
            if(alThing.get(i).getClass().getName().equals("StockShare")){
                alThing.get(i).setValue(0);
            }
        }
    }
}
