
public class Stock extends Gadget{
	
	private int number = 0;
	private int price = 0;
	private double value;
	
	public Stock(String name, int stockNumber, int stockPrice) {
		super(name);
		number = stockNumber;
		price = stockPrice;
		
	}
	public double getValue(){
		value = number * price;
		return value;
	}
	public void setPrice(int x){
		price = x;
	}
}