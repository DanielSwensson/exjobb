
public class Shareholding extends Valuable {
    private String name;
    private int quantity;
    private int baseWorth;
    private double percentChange=1;
    
    public Shareholding(String name, int quantity, int baseWorth){
    this.name=name;
    this.quantity=quantity;
    this.baseWorth=baseWorth;
    }
    
    public double getValue(){
        value=(quantity*(baseWorth*percentChange));
        return value;
    }
    
    public void stockMarketCrash(){
        setValue(-100.0);
    }
    
    public void setValue(double change){
        percentChange+=(change/100);
        if(percentChange<0){
            percentChange=0;
        }
    }
    public String toString() {
        return name + " ("+ quantity +") " + getValue();
    }
}
