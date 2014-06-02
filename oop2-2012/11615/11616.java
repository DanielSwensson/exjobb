package valuables;

public class Appliance extends Valuable {
	private int condition;
	private int price;

	public Appliance(String name, int condition, int price) throws Exception {
		super(name);
		this.condition = condition;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	@Override
	public int getValue() {
		return (getPrice() * getCondition()) / 10;
	}
}
