import java.util.ArrayList;

public class Person {
    private String name;
    private ArrayList<Valuable> Valuables = new ArrayList<Valuable>();
    
    public Person (String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void addItem(Valuable v){
        Valuables.add(v);
        System.out.println(name+" now owns: "+v);
    }
    
    public double assets(){
        double assets=0;
        for (Valuable v : Valuables){
            assets+=v.getValue();
        }
        return assets;
    }
    
    public void stockMarketCrash (){
        for (Valuable v : Valuables){
            if(v instanceof Shareholding){
                v.stockMarketCrash();
            }
        }
    }
    
    public void listAllInfo(){
        System.out.println(this);
        listItems();
    }
    
    public void listItems(){
        for (Valuable v : Valuables){
            System.out.println(v);
        }
    }
    
    
    public String toString() {
    return "Name: "+name+" Have: "+assets();
    }
}
