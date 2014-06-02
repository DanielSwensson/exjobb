package peopleandstuff;

 public class Item {

    protected int itemValue;
    protected String itemName;

   public Item() {
        this.itemName = "";
        this.itemValue = 0;
    }

    public Item(String itemName, int itemValue) {
        this.itemName = itemName;
        this.itemValue = itemValue;
    }

    public int getItemValue() {
        return itemValue;
    }

    public String getItemName() {
        return itemName;

    }
    public void setName(String inName)
    {
        itemName=inName;
    }  
    public void setValue(int iValue)
    {
        itemValue=iValue;
    } 
    
    public String toString() {
        return "Name of item: " + itemName + ". Value: " + itemValue + "USD.\n";
    }
}
