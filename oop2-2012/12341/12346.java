import java.io.Serializable;

public class Valuable implements Serializable{
    private String owner;
    private String name;
    private double value;
   
    Valuable(String owns, String thingName){
        owner = owns;
        name = thingName;
    }
    
    public String getName(){
        return name;
    } 
    
     public String getOwner(){
        return owner;
    }
    
    public double getValue(){
        return value;
    }
    
    public void changeValue(double newValue){
        value = newValue;
    }
    
}
