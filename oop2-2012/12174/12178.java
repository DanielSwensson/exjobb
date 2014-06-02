
public class Device extends Item
{
    private int purchasePrice;
    private int quality;

    public Device(String name, int purchasePrice, int quality) {
        super(name);
        
        this.purchasePrice=purchasePrice;
        this.quality=quality;
    }
    
    public int getValue() {
        double qualityPercentage = quality/10.0;
        int totalValue = (int) (qualityPercentage*purchasePrice);
        
        return totalValue;
    }
    
    public int getQuality() {
        return quality;
    }
    
    public int getPurchasePrice() {
        return purchasePrice;
    }
}
