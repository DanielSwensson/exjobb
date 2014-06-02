package Inlupp2;

public class Stock extends Valuable {
	private int quantity;
	private double stockPrice;
	public Stock(String name, int quantity, double stockPrice) {
		super(name);
		this.quantity=quantity;
		this.stockPrice=stockPrice;

		// TODO Auto-generated constructor stub
	}

	public double getWorth(){
		double worth = quantity*stockPrice;

		return worth;
	}
	public void setPrice(double stockPrice){
		this.stockPrice=stockPrice;

	}
}

