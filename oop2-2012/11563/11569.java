public class Stock extends Property {

	private int noOfPosts; 
	private int price;

	public Stock(String name, int noOfPosts, int price) {
		super(name);
		this.noOfPosts = noOfPosts;
		this.price = price;
	}

	public int getValue() {
		return price * noOfPosts;
	}

	public void setPrice(int newPrice) {
		price = newPrice;
	}
}