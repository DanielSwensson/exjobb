
package prylregister;

import java.util.ArrayList ;

public class Person {
    
    private String name;
    private ArrayList<Pryl> things= new ArrayList<Pryl> (); 

//Konstruktorn för klassen person
public Person(String name, ArrayList<Pryl> things ){
    
    this.name = name;
    this.things = things;
    
    }
    
    public String getName(){
        return name;
    } 

    public void addThing(Pryl p){
        things.add(p);
    }
    
    public Pryl getAllPersonalObjects(int index){

    return things.get(index);

    }
    
    public int getPrylIndex(){
    
    return things.size();
    
    }
    
    public double getValueOfAllPersonalItems(){
        double sum=0;
        for(Pryl p: things){
            sum+=p.value();
        }
        return sum;
    }
    
     public void setStockToZero(){
        for(Pryl p: things){
            if(p instanceof Aktier){
                Aktier a = (Aktier)p;
                a.setPrice();
            }
        }
    }

}
