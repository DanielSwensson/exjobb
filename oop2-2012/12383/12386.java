public class Jewelery extends BaseObject {

	private String material, type;
	private int jewels;

	Jewelery(String personName, String type, String material, int jewels) {

		this.personName = personName;
		this.material = material;
		this.jewels = jewels;
		this.type = type;

	}

	public int getWorth() {

		int worth = 0;

		if (material.equals("guld")) {
			worth = 2000 + (500 * jewels);

		} else {
			worth = 700 + (500 * jewels);
		}
		return worth;

	}

	public String getOwner() {

		return personName;
	}

	public String getJeweleryType() {

		return type;
	}
}
