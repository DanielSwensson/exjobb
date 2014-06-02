public class Electronics extends Valuable{
    private double purchasePrice;
    private int wear;
    
    Electronics(String owns, String itemName, double price, int usage){
        super(owns, itemName);
        purchasePrice = price;
        wear = usage;
    }
    
    public String toString(){
        return getName() + " " + getValue();
    }
    
    public double getValue(){
        return ((double)wear*0.1)*purchasePrice;
    }
    
}
