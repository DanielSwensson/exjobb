
public abstract class Jewelery extends Valuable {
    private String jeweleryType;
    private int numberOfJewels;
    
    public Jewelery(String jeweleryType, int numberOfJewels){
        this.jeweleryType = jeweleryType;
        this.numberOfJewels = numberOfJewels;
    }
    
    public double getValue(){
        value = (numberOfJewels * 500);
        return value;
    }

    public String toString() {
        return jeweleryType + " " + getValue();
    }
}
