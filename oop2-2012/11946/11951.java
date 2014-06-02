import java.util.*;

public class Person {
	private String name;

	private ArrayList<Accessorie> all = new ArrayList<Accessorie>();

	public Person(String name) {
		this.name = name;

	}

	public String getName() {

		return name;

	}

	public void addItem(Accessorie d) {

		all.add(d);
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
		double value = 0;

		for (Accessorie a : all) {

			value = value + a.getValue();

		}
		return value;

	}

	public void stockCrash() {

		for (Accessorie a : all) {
			System.out.println("Sorry");
			if (a instanceof Stock) {
				System.out.println(" Your stocks are crashing");
				((Stock) a).stockCrash();
			}
		}
	}

	public String toString() {
		return name + "Name: " + this.getTotalValue() + "and the total value: ";
	}

	public void add(Accessorie a) {
		this.all.add(a);

	}

	public void showPerson() {
		System.out.println("Name = " + name);
		System.out.println("Total value = " + this.getTotalValue());
		System.out.println();

		for (Accessorie a : all) {
			System.out.println(a.getItemName() + " " + a.getValue());

		}
		System.out.println();
	}
}
