
public abstract class Item
{
    private String name;
    private int value;

    public Item(String name) {
        this.name=name;
    }

    public String getName() {
        return name;    
    }

    public String toString() {
        return name + "\t\t" + getValue();
    }

    public abstract int getValue();

}
