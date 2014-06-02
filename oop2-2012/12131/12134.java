

public class Device extends Accessorie {

	
	private int tear;
	private int purchasePrice1;

	public Device(String name, int tear, int purchasePrice1) {
		super(name);
		this.tear = tear;
		this.purchasePrice1 = purchasePrice1;
		
		setValue(getItemValue());

	}

	public int setTear(int tear) {
		return tear;
	}

	public int setPurchasePrice1(int purchasePrice1) {
		return purchasePrice1;

	}

	public String getName(String name) {
		return name;
	}

	public int getTear(int tear) {
		return tear;
	}

	public int getPurchasePrice1(int purchasePrice1) {
		return purchasePrice1;
	}
	
	
	private double getItemValue() {
		double tempValue= (double)((this.purchasePrice1*this.tear) / 10);
		return tempValue;
		

	}

}
