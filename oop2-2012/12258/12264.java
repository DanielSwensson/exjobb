package peopleandstuff;

public class Stock extends Item {

  //  private int amount;

    public Stock(String itemName, int itemValue) {
        super(itemName, itemValue);
    //    this.amount = amount;
    }

    public int getItemValue() {
        return itemValue;

    }

    public void setPriceZero() {
        itemValue = 0;
        return;

    }


}
