
public class Share extends Gadget{
	
	private int amount;
	private int rate;
	private int value;

	public Share(String typeName, int amount, int rate) {
		super(typeName, "Aktie");
		this.amount = amount;
		this.rate = rate;
		countValue(amount, rate);
	}

	private void countValue(int amount, int rate) {
		value = amount * rate;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getRate() {
		return rate;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return super.toString() + "och har ett värde av " + getValue();
	}
}	