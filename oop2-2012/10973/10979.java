
        
/**
 *
 * @author Tor Brambeck
 */
public abstract class Prylar {
    private String name;
    
    public Prylar(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public abstract double getValue();
}
