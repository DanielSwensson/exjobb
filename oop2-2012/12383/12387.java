import java.util.ArrayList;

public class Person {
	private String personName;
	private ArrayList<BaseObject> ownedObjects = new ArrayList<BaseObject>();
	private int value, totalWorth;

	Person(String personName) {
		this.personName = personName;
	}

	public void addJewelery(String personName, String type, String material,
			int jewels) {

		Jewelery newJewelery = new Jewelery(personName, type, material, jewels);
		ownedObjects.add(newJewelery);
		System.out.println("Smycke registrerats på " + personName + "!");
	}

	public void addStockShare(String personName, String companyName,
			int amount, int stockSharePrice) {

		StockShare newStockShare = new StockShare(personName, companyName,
				amount, stockSharePrice);
		ownedObjects.add(newStockShare);
		System.out.println("Ny aktie har registrerats på " + personName + "!");

	}

	public void addDevice(String personName, String deviceType,
			double condition, double purchasePrice) {

		Device newDevice = new Device(personName, deviceType, condition,
				purchasePrice);
		ownedObjects.add(newDevice);
		System.out.println("Ny apparat har registrerarts på " + personName
				+ "!");

	}

	public int getWorth() {
		totalWorth = 0;
		for (BaseObject i : ownedObjects) {
			value = i.getWorth();
			totalWorth += value;
		}
		return totalWorth;
	}

	public void printObjects() {
		for (BaseObject i : ownedObjects) {
			if (i instanceof Device) {
				System.out.println(i.getDeviceType() + " " + i.getWorth());
			} else if (i instanceof StockShare) {
				System.out.println(i.getCompanyName() + " " + i.getWorth());
			} else if (i instanceof Jewelery) {
				System.out.println(i.getJeweleryType() + " " + i.getWorth());
			}
		}

	}

	public void StockCrash() {
		for (BaseObject i : ownedObjects) {
			if (i instanceof StockShare) {
				i.stockCrash();
			}

		}

	}

	public String getName() {

		return personName;
	}

}
