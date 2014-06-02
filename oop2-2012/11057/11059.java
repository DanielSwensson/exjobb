
class Stock extends Item{

	private double stockPrice;
	
	private int numberOfStocks;
	
	Stock(String sN,double sP, int nOS) {
		super(sN);
		stockPrice = sP;
		numberOfStocks = nOS;
	}
	
	public double returnValue(){
		return numberOfStocks*stockPrice;	
	}
	
	public void returnValueStockCrash() {
		stockPrice = 0;
	}
}

