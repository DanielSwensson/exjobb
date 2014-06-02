
import java.io.Serializable;


/**
 * A superclass for valuables
 */
public class Valuable implements Serializable {
    private String name;
    
    public Valuable(String name) {
        this.name = name;
    }

    /*
     * Returns the name of the valuable
     */
    public String getName() {
        return this.name;
    }

    /*
     * Returns a default value for the valuable
     */
    public double getValue() {
        double value = 0;
        return value;
    }
        
    public void setPrice(double newPrice) {        
    }
    
    /*
     * Returns the valuable and its value as a string
     */
    @Override
    public String toString() {
        return this.name + " Värde: " + this.getValue() + " "; 
    }

}
