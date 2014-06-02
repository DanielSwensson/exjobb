package inlupp2;

import java.util.*;

public class Person {

	/* ----------- Field & Attributes ----------- */
	private ArrayList<Pryl> allThings = new ArrayList<Pryl>();
	
	private String name;
	private String prylar;
	private double totalValue;

	/* ---------- Construktor ---------- */
	public Person(String name) { // en person har ett namn likväl som prylar
		this.name = name;
	}

	/* ---------- Methods ---------- */
	public String getName() {
		return name;
	}

	public void addPryl(Pryl thing) { // skapar en ny pryl
		allThings.add(thing);
	}

	public ArrayList<Pryl> getPrylar() {
		return allThings;
	}

	public ArrayList pryl() {
		return allThings;
	}

	public String showPrylar() { // visar alla prylar för en person
		String thing = "";
		for (Pryl p : allThings)
			thing += p.toString(); // samma sak som: thing = (thing + p.toString());
		return thing;
	}

	public String prylValue() { 
		for (Pryl p : allThings)
			prylar += p.getValue(); // samma sak som: prylar = (prylar + p.getvalue());
		return prylar;
	}

	public double getTotalValue() { // hämtar totala värdet för en person
		totalValue = 0;
		for (Pryl p : allThings) {
			totalValue += p.getValue();  // samma sak som: totalValue = (totalValue + p.getValue());
		}
		return totalValue;
	}

	public String toString() { 
		return name;
	}

}