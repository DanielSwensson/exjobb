import java.util.ArrayList;

class Person {

	//Creates arraylist for all items
	private ArrayList <Item> item = new ArrayList<Item>();

	private String name;
	private int total;

	//Constructor
	public Person(String name, int total){
		this.name=name;
		this.setTotal(total);

	}
	public String getName() {
		return name;
	}
	public void addItem(Item n){
		item.add(n);
	}

	public ArrayList<Item> getItems() {
		return item;
	}

	public String toString() {
		return "Name: "+ name + "		Total Value: " + total + "\n";

	}
	public int getTotal() {
		return total;
	}
	//Sets the total value of all items for person
	public void setTotal(int total) {
		this.total = total;
	}
}
