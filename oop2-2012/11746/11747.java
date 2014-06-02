
/**
 * A class for devices, subclass to Valuable
 */
public class Device extends Valuable {
    private double purchasePrice;
    private int wear;
    
    /*
     * A device is constructed with name, purchase price and wear
     */
    public Device(String name, double purchasePrice, int wear) {
        super(name);
        this.purchasePrice = purchasePrice;
        this.wear = wear;
    }
    
    /*
     * Returns the purchase price of the device
     */
    public double getPurchasePrise() {
        return this.purchasePrice;
    }
    
    /*
     * Returns the wear of the device
     */
    public int getWear() {
        return this.wear;
    }
    
    /*
     * Overrides the super-method, returns the device's value
     */
    @Override
    public double getValue() {
        double value = 0;
        value += (this.wear / 10.0) * this.purchasePrice;
        return value;
    }
}
