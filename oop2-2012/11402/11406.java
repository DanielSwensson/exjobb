package inlupp2;
import java.util.ArrayList;

public class Person {
	protected String name;
	protected int totalValue;
	ArrayList <Gadget> gadgets = new ArrayList<Gadget>();
	
	public Person(String na){
		name = na;
	}
	public String getName(){
		return name;
	}
	public void addGadget(Gadget x){
		gadgets.add(x);
	}
	
	public int totalValue(){
		for(Gadget g: gadgets){
			totalValue += g.value();
		}
		return totalValue;
	}
	public ArrayList<Gadget> getGadget(){
		return gadgets;
	}
	public String toString(){
		return name + " äger total "+ totalValue()+":  "+
				"\n " + gadgets.toString();
	}
}
