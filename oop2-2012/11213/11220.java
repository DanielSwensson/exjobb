public class Shares extends Belongings {
	
	private int price, amount;
	
	Shares(String name, int price, int amount) {
		super(name,	price * amount);
		this.price = price;
		this.amount = amount;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return getName() + ", Pris: " + price + ", Antal: " + amount + ", Värde: " +	getValue();
		
	}	
}
