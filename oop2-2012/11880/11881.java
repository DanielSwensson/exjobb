public class Item extends Possession {
	private int purchasePrice;
	private int condition;

	public Item(String poNa, int pur, int con) {
		super(poNa);
		purchasePrice = pur;
		condition = con;
	}
	
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	public int getCondition() {
		return condition;
	}
 	
	public int getWorth() {
		return (purchasePrice * condition) / 10;
	}
	
}
