
public class Stock extends Accessorie {
	private int amount;
	private int price = 0;

	Stock(String name, int amount, int price) {
		super(name);
		this.amount = amount;
		this.price = price;
		setValue(getItemValue());

	}

	public String setName(String name) {
		return name;
	}

	public int setAmount(int amount1) {
		return amount;

	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNamne(String name) {
		return name;
	}

	public int getAmount() {
		return amount;

	}

	public int getPrice() {
		return price;
	}

	public void stockCrash() {
		price = 0;
	}
	
	private double getItemValue() {
		double tempValue= (double) amount * price;
		return tempValue;

	}


}
