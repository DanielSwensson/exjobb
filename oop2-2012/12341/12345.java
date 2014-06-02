public class Stocks extends Valuable {
    private int number;
    private double price;
    
    Stocks(String owns, String itemName, int newNumber, double newPrice){
        super(owns, itemName);
        number = newNumber;
        price = newPrice;
    }
    
    public String toString(){
        return getName() + " " + getValue();
    }
    
    public double getValue(){
        return (double)number * price;
    }
    
    public void changeValue(double newValue){
        price = newValue;
    }
}
