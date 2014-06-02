
import java.util.*;

public class Person {

	private String name;
	private double totalValue;
	

	ArrayList<Accessorie> all = new ArrayList<Accessorie>();
	Scanner scan = new Scanner(System.in);

	public Person(String name) {
		this.name = name;
		
	}

	public String getName() {
		return this.name;
	}

	public String getAcessorie() {
		String accessorie = "(";

		for (int i = 0; i < all.size(); i++)

		{

			accessorie += all.get(i).getItemName();

		}
		accessorie += ")";
		return accessorie;
	}

	public double getTotalValue() {
		return this.totalValue;

	}
	
	public void setTotalValue(double value){
		this.totalValue += value;
	}

	public void stockCrash() {

		for (Accessorie a : this.all)
			if (a instanceof Stock)
				((Stock) a).stockCrash();
	}

	public String toString() {
		return name + "Name: " + totalValue + "and the total value: ";
	}

	public void add(Accessorie a) {
		this.all.add(a);
		
	}

	public void showPerson(){
		System.out.println("Name = " + name);
		System.out.println("Total value = " + totalValue);
		System.out.println();
		 
		for(Accessorie a: all){
			System.out.println(a.getItemName() + " " + a.getValue());
		
		 }
		System.out.println();
	}
}
