
public class Stock extends Item {

	private int stockQuantity, stockPrice;
	
	public Stock (String stockName, int stockQuantity, int stockPrice){
		super (stockName);
		this.stockQuantity = stockQuantity;
		this.stockPrice = stockPrice;
	}
	
	public int getQuantity(){
		return stockQuantity;
	}
	
	public int getPrice(){
		return stockPrice;
	}
	
	public int getValue(){
		return stockQuantity * stockPrice;
	}
	
	public void setPriceZero(){
		stockPrice = 0;
		return;
	}
}
