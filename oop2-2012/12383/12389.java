public class StockShare extends BaseObject {
	private int amount, stockSharePrice;
	private String companyName;

	StockShare(String personName, String companyName, int amount,
			int stockSharePrice) {
		this.amount = amount;
		this.companyName = companyName;
		this.personName = personName;
		this.stockSharePrice = stockSharePrice;

	}

	public int getWorth() {

		int worth = 0 ;
		worth = amount * stockSharePrice;
		return worth;
	
	}
	
	public String getCompanyName(){
		
		return companyName;
	}

	public void stockCrash(){
		stockSharePrice = 0;
	}
}
