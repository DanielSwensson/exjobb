
import java.io.Serializable;

/**
 *
 * @author Erik Welander
 * @version 2012-02-04
 * Encoding: UTF-8
 * IDE: Netbeans 7.2.1
 */
public class Jewelry extends Thing implements Serializable{
    private int stones;
    private boolean isGold;
    
    Jewelry(String name, boolean is_gold, int stones){
        this.stones = stones;
        this.isGold = is_gold;
        newValue(isGold, stones);
        super.setName(name);
        
    }
    public void newValue(boolean isGold, int stones){
        this.isGold = isGold;
        this.stones = stones;
        int value = 0;
        if(isGold){value = 2000;}
        else{value = 700;}
        value = value+ (500*stones);
        super.setValue(value);
    }
    public int getStones(){
        return stones;
    }
    public boolean isGold(){
        return isGold;
    }
    
}
