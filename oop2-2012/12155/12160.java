import java.util.ArrayList;

public class Person {

    private String name;
    private ArrayList<Thing> things = new ArrayList<Thing>();
    
    Person(String name) {
	this.name = name;
    }
    
    public String toString() {
	return name + ": " + getTotalWorth();
    }
    
    public String getName() {
	return name;
    }

    public void addNewThing(Thing thing) {
	things.add(thing);
    }

    public void printAllThings() {
	for(Thing t : things) {
	    System.out.println(t);
	}
    }
    
    public double getTotalWorth() {

	double totalWorth = 0;
	
	if(things.size() == 0) {
	    totalWorth = 0;
	}
	
	else {
	    for(Thing t : things) {
		totalWorth += t.getValue();
	    }
	}

	return totalWorth;
    }

    public void marketCrash() {
	for(Thing t : things) {
	    if(t instanceof Stock) {
		((Stock)t).setPrice(0);
	    }
	}
    }
}
