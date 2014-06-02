import java.util.ArrayList;
import java.io.*;
public class Person implements Serializable{
	private String name;
	private ArrayList<Thing> thingList = new ArrayList<Thing>();
	public Person(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void addThing(Thing thing){
		this.thingList.add(thing);
	}
	public double getValue(){
		double sum = 0.0;
		for(Thing thing : thingList){
			sum = sum + thing.getValue();
		}
		return sum;
	}
	public String getThingString(){
		String list = "";
		int i=0;
		for(Thing thing: thingList){
			i++;
			list = list + i + ": " + thing.getName()+"\t"+thing.getValue()+"\n";
		}
		return list;
	}
	public ArrayList<Thing> getThingList(){
		return this.thingList;
	}
	public String toString(){
		return this.name+"\t"+this.getValue();
	}
	public void changeShareValue(String name, double value){
		for(Thing thing : thingList){
			if(thing instanceof Share){
				Share s = ((Share)thing);
				if (s.getName().equals(name)){
					s.setValue(value);
				}
			}
		}
	}
	public void crashMarket(){
		for(Thing thing : thingList){
			if(thing instanceof Share){
				((Share)thing).setValue(0);
			}
		}
	}
}
