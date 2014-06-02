abstract public class Item {

    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String toString() {

        String itemString = String.format("%s\t%d", name, getValue());

        return itemString;
    }

    abstract public int getValue();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
