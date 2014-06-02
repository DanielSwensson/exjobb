import java.util.ArrayList;
import java.util.Collection;

public class Person {
	private String sName;
	private ArrayList<Thing> aThing = new ArrayList<Thing>();
	
	public Person(String sName){
		this.sName = sName;
	}
	
	public void addThing(Collection<? extends Thing> aThing){
		this.aThing.addAll(aThing);
	}
	
	public void setAllStockValueZero(){
		for (int iN=0;iN<aThing.size();iN++){
			if (aThing.get(iN).getClass().getName().equals("Stock")){
				aThing.get(iN).setValueZero();
			}
		}
	}
	
	public int getTotalValue(){
		int iValue = 0;
		for (int iN=0;iN<aThing.size();iN++){
			iValue += aThing.get(iN).getValue();
		}
		return iValue;
	}
	
	public void listThings(){
		System.out.print("Person "+getName());
		System.out.println(aThing);
	}
	
	public void showNameTotalValue(){
		System.out.println(getName()+" "+getTotalValue());
	}
	
	public void showAllThingValue(){
		for(int iN=0;iN<aThing.size();iN++){
			System.out.println(aThing.get(iN).getName()+" "+aThing.get(iN).getValue());
		}
	}
	
	public String getName(){
		return sName;
	}
}
