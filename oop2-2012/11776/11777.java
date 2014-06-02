
public class Stock extends Thing {


	private int numberOfStock;
	private double price;

	public Stock (String name, int numberOfStock, double price){
		super (name);
		this.numberOfStock = numberOfStock;
		this.price = price;
	}

	public int getNumberOfStock(){
		return numberOfStock;
	}

	public void setPrice(double newPrice){
		this.price = newPrice;
	}

	public double getValue(){
		double stockValue;
		stockValue = numberOfStock * price;
		return stockValue;
	}
}

