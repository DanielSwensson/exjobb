package Inlupp2;

public class Device extends Item {

	private int purchasePrice;
	private double wear;
	private double value;

	public Device(String na, int pur, int we) {
		super(na);
		purchasePrice = pur;
		wear = we;
	}

	public int getpurchasePrice() {
		return purchasePrice;
	}

	public double getValue() {
		value = (purchasePrice * (wear * 0.01));
		return value;
	}
}
