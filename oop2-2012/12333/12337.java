import java.util.*;

public class Person {
	
	private ArrayList<Thing> thing = new ArrayList<Thing>();
	
	private String name;
	private int totalValue = 0;
	
	public Person (String name){
		this.name=name;

	}
	
	public String getName(){
		return name;
	}
	
	public int getTotalValue(){
		return totalValue;
	}
	
	public String toStringRichest(){
		String ret = name + " som sammanlagt �ger prylar till ett v�rde av " + getTotalValue() + " kr.\n";
		for(int n = 0 ; n < thing.size(); n++){
			ret += thing.get(n).toString() + "\n";
		}
		return ret;
	}
	
	public void addThing(Thing newThing){
		thing.add(newThing);
		totalValue += newThing.getSum();
		
	}
	
	public String getPerson(){
		String ret = "\n" + name + " �ger dessa prylar: \n";
		for(int n = 0 ; n < thing.size() ; n++){
			ret += thing.get(n).toString() + "\n";
		}
		return ret;
	}
	
	public void marketCrash(){
		
		for(Thing t : thing){
			if(t instanceof Stock){
				totalValue -= t.getSum();
				((Stock) t).setStock();
			}
		}
	}

}
