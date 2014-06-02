package p2;

import java.util.ArrayList;

public class Person {

	private String name;
	private ArrayList<Asset> assets;
	
	public Person(String name) {
		this.name = name;
		this.assets = new ArrayList<Asset>();
	}
	
	public void addAsset(Asset a) {
		assets.add(a);
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Asset> getAssets() {
		return assets;
	}
	
	public double getWealth() {
		double wealth = 0;
		for (Asset a : assets) {
			wealth += a.getValue();
		}
		return wealth;
	}
	
}
