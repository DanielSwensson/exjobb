
public class Stock extends Item {
	private int price;
	private int number;
	
	public Stock(String name, int price, int number) {
		this.name = name;
		this.price = price;
		this.number = number;
	}
	
	public double getValue() {
		return price * number;
	}
	
	public void affectByStockcrash() {
		price = 0;
	}
}
//Aktier: värdet är antalet * priset