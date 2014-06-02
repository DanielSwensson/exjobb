public class Jewelry extends Valuable{
    private int stones; 
    private boolean gold;
    
    Jewelry(String owns, String itemName, int numberOfStones, boolean gold){
        super(owns, itemName);
        stones = numberOfStones;
        this.gold = gold;
    }
    
    public String toString(){
        return getName() + " " + getValue();
    }
    
    public double getValue(){
        if (gold==true){
            return (stones*500)+2000;
        }
        else {
            return (stones*500)+700;
        }
    }
    
}
