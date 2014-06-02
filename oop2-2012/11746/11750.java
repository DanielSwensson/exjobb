
/**
 * A class for stock, subclass to Valuables
 */
public class Stock extends Valuable {
    private int amount;
    private double price;
    
    /*
     * A stock is constructed with name, amount and price
     */
    public Stock(String name, int amount, double price) {
        super(name);
        this.amount = amount;
        this.price = price;
    }
    
    /*
     * Returns the amount of the stock
     */
    public int getAmount() {
        return this.amount;
    }
    
    /*
     * Returns the price of the stock
     */
    public double getPrice() {
        return this.price;
    }
    
    /*
     * Enables changes of the stock's price
     */
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
    
    /*
     * Overrides the super-method, returns the value of the stock
     */
    @Override
    public double getValue() {
        double value = 0;
        value += (this.amount * this.price);
        return value;
    }
}
