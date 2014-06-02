
public class Share extends Item {

	private double value;
	private int amount;
	
	Share(String name, double value, int amount) {
		super(name);
		this.value = value;
		this.amount = amount;
	}
	
	public double getValue() {
		return amount*value;
	}
	
	public void stockExchangeCrash() {
		value = 0;
	}
	
}
