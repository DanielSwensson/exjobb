import java.util.*;

class Person {

	private String newPerson;


	private ArrayList<Item> items = new ArrayList<Item>();				// All the items a person OWNS
	public void addItem(Item i){
		items.add(i);
	}

	public String getName(){
		return newPerson;
	}


	Person(String nPerson){
		newPerson = nPerson; 
	}

	public String toString(){
		return newPerson;	
	}

	public double totalValue() {
		double finalTotalValue=0;

		for(Item totalValue : items) {
			finalTotalValue += totalValue.returnValue(); 
		}
		return finalTotalValue;
	}


	public String specifiedBelongings() {

		String finalSpecifiedBelongings="";

		for(Item specifiedBelongings : items) {
			finalSpecifiedBelongings += specifiedBelongings.getName()+ " " + specifiedBelongings.returnValue() + " \n";
		}

		return finalSpecifiedBelongings;
	}

	public void stockValueCrash() {

		for (Item stockValueCrash : items) {

			if (stockValueCrash instanceof Stock) {
				((Stock) stockValueCrash).returnValueStockCrash();
			}
		}
	}
}
