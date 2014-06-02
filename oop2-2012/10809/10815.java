public class Shares extends Item {
	private int numberOfShares;
	private int pricePerShare;
	
	public Shares(String type, int numberOfShares, int pricePerShare) {
		setType(type);
		this.numberOfShares = numberOfShares;
		this.pricePerShare = pricePerShare;
		setValue();
	}
	
	public void setValue() {
		setValue(numberOfShares*pricePerShare);
	}
}
