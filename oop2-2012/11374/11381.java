
public class Share extends Valuable {

	private int numbersOfShares;
	private int price;
	
	public Share(String name, int numbersOfShares, int price) {
		
		super(name);
		this.numbersOfShares = numbersOfShares;
		this.price = price;
	}
	
	public int getPrice() {
		
		return price;
	}
	
	public void setPrice(int price) {
	
		 this.price=price;
	}
	
	public int getNumbersOfShares() {
		
		return numbersOfShares;
	}
	
	public double value() {
		return numbersOfShares * price;
		
	}
	
	public String toString() {
		return super.toString() + "Shares: " + numbersOfShares + "st. Price: " + price + "kr.";
	}	
}
