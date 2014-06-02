public class Stocks extends Items {
	
	private int stockPrice;
	private int stockQty;
	
	Stocks(String personNameData, String itemNameData, int stockPriceData, int stockQtyData) {
		super(personNameData, itemNameData);
		this.stockPrice = stockPriceData;
		this.stockQty = stockQtyData;	
		}
	
	public void crash(){
		stockPrice=0;
		}
	
	public int itemValue(){
		
		return stockPrice*stockQty;
		}	
}

