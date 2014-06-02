package Inlupp2;

import java.util.ArrayList;

public class Person {
	private ArrayList<Item> itemList = new ArrayList<Item>();

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public double getTotalValue() {
		double totalValue = 0;
		for (Item i : itemList) {
			totalValue += i.getValue();

		}
		return totalValue;
	}

	public String toString() {
		return getName() + "\t" + getTotalValue();
	}

	public void showItems() {
		for (Item i : itemList) {
			System.out.println(i.getItemName() + "\t" + (i.getValue()));
		}
	}

	public void searchStock() {
		for (Item i : itemList)
			if (i instanceof Stock) {
				((Stock) i).setPrice(0);
			}
	}
}
