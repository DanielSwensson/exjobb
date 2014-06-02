package Inlupp2;

public class Stock extends Item {
	private int amount;
	private double price;
	private double value;

	public Stock(String na, int am, double pri) {
		super(na);
		this.amount = am;
		this.price = pri;
	}

	public int getAmount() {
		return amount;
	}

	public double getPrice() {
		return price;
	}

	public double getValue() {
		value = (price * amount);
		return value;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}