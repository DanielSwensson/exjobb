
public class StockShare extends Valuable {

	private int amountOfShares;
	private int pricePerShare;

	// Konstruktor
	public StockShare (String itemName, int amountOfShares, int pricePerShare) {
		super(itemName);
		this.amountOfShares = amountOfShares;
		this.pricePerShare = pricePerShare;
	}
	

	
	// Kraschar en stockShare
	public void crashPrice() {
			pricePerShare = 0;
			}
	
	// Beräknar värdet av en aktie
	public int value() {
		return amountOfShares*pricePerShare;
	}
		
}

