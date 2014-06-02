import java.util.ArrayList;

class Person {

	private ArrayList<Thing> items = new ArrayList<Thing>();
	private String humanName;

	public Person(String humanName){
		this.humanName = humanName;
	}

	public void addThing(Thing New){
		items.add(New);
	}
	public String getHumanName(){
		return humanName;
	}
	public int totalSum(){
		int sum = 0;
		for (Thing x : items)
			sum += x.worth();
		return sum;
	}
	public void showThing(){
		for (Thing x : items)
			System.out.println(x.name()+" "+x.worth());
	}
	public void stockCrash(){
		for (Thing x : items)
			if (x instanceof Stock)
				((Stock)x).stockCrash();
	}
	
}