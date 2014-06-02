import java.util.ArrayList;

public class Owner {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private ArrayList<Item> itemList;

    public Owner(String name) { //konstruktor

        this.name = name;
        this.itemList = new ArrayList<Item>(); //kallar på array-listens konstruktor. typat till Items som kan vara av typen stock, device osv. 

    }

    public void addItem(Item item) {
        this.getItemList().add(item);
    }

    public int totalWorth() {
        int worth = 0;
        for (Item currentItem : getItemList()) { //gör automatiskt för varje item jag har i listan. ist för "vanliga" countern.
            worth = worth + currentItem.getValue();
        }
        return worth;
    }

    public String toString() {

        String ownerString = String.format("%s\t%d", name, totalWorth()); //tabbar in. använder totalworth metoden.

        return ownerString;
    }

    public ArrayList<Item> getItemList() { //får ut items.
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }
}
