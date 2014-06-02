
public class Jewelry extends Item
{
    private boolean material;
    private int numberOfGems;

    public Jewelry(String name, boolean material, int numberOfGems) {
        super(name);

        this.material=material;
        this.numberOfGems=numberOfGems;
    }

    public int getValue() {
        int baseValue;
        int gemValue = numberOfGems*500;

        if(material) {
            baseValue = 2000;
        } else {
            baseValue = 700;
        }
        return baseValue+gemValue;
    }
    
    public String getMaterial(boolean material) {
        if(material) {
            return "Guld";
        } else {
            return "Silver";
        }
    }
    
    public boolean getMaterial() {
        return material;
    }
    
    public int getNumberOfGems() {
        return numberOfGems;
    }
}
