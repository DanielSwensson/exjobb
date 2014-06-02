import java.util.ArrayList;


public class Person {
	
	ArrayList<Gadget> gadgetIndex;
	
	private String name;

	public void addGadget(Gadget g){
	}
	public Person(String str) {
		name = str;
		this.gadgetIndex = new ArrayList<Gadget>();
	}
	public String getName (){
		return name;
	}
	public void addGadget(Jewlery jew) {
		
	}
	public void addGadget(Stock stock){
		
	}
	public void addGadget(Appliance app){
		
	}
	public double getSum(){
		double sum = 0;
		for (Gadget g : gadgetIndex){
			sum += g.getValue();
		}
		return sum;
	}

	public String toString(){
		return name + "\t" + getSum();
	}
	public String getGadget(){
		String gadget = "";
		for(Gadget g : gadgetIndex)
			gadget +=g;
			return gadget;
	}
	public void startMarketCrash(){
		for (Gadget s : gadgetIndex){
		if (s instanceof Stock)
			((Stock) s) .setPrice(0);
		}
	}
}
