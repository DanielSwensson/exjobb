
public class Shareholding extends Item
{
    private int purchasePrice;
    private int amount;

    public Shareholding(String name, int purchasePrice, int amount) {
        super(name);

        this.purchasePrice=purchasePrice;
        this.amount=amount;
    }

    public void setPurchasePrice (int purchasePrice) {
        this.purchasePrice=purchasePrice;
    }
    
    public int getValue() {
        return amount*purchasePrice;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public int getPurchasePrice() {
        return purchasePrice;
    }
}
