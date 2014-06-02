public class Jewelry extends Item {

    private boolean materialIsGold; //guld eller silver
    private int noOfGems;

    public Jewelry(String name, boolean materialIsGold, int noOfGems) {
        super(name);
        this.materialIsGold = materialIsGold;
        this.noOfGems = noOfGems;
    }

    public int getNoOfGems() {
        return noOfGems;
    }

    public void setNoOfGems(int noOfGems) {
        this.noOfGems = noOfGems;
    }

    public int getValue() {
        int value;

        if (materialIsGold) {
            value = 2000;
        } else {
            value = 700;

        }
        value = value + (500 * noOfGems);
        return value;
    }

    public boolean isMaterialIsGold() {
        return materialIsGold;
    }

    public void setMaterialIsGold(boolean materialIsGold) {
        this.materialIsGold = materialIsGold;
    }
}
