import java.util.ArrayList;

public class Person
{
    private String name;
    private ArrayList<Item> allItems;

    public Person(String name) {
        this.name=name;
        allItems = new ArrayList<Item>();
    }

    public void addJewelry(String name, boolean material, int numberOfGems) {
        Item i = new Jewelry(name, material, numberOfGems);
        allItems.add(i);
    }

    public void addShareholding(String name, int purchasePrice, int amount) {
        Item i = new Shareholding(name, purchasePrice, amount);
        allItems.add(i);
    }

    public void addDevice(String name, int purchasePrice, int quality) {
        Item i = new Device(name, purchasePrice, quality);
        allItems.add(i);
    }

    public int total() {
        int total = 0;
        for(Item i : allItems) {
            total+=i.getValue();
        }
        return total;
    }

    public void setShareholdingValue (int change) {
        for(Item i : allItems) {
            if(i instanceof Shareholding) {
                Shareholding s = (Shareholding) i;
                s.setPurchasePrice(change);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void list() {
        System.out.println(name);
        System.out.println();
        for(Item i : allItems) {
            System.out.println(i);
        }
    }
}
