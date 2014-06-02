package Inlupp2;

public abstract class Item {
	private String name;

	public Item(String na) {
		this.name = na;
	}

	public String getItemName() {
		return name;
	}

	abstract public double getValue();

}
