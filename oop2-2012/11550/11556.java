
public class Jewelry extends Gadget {
	
	private int numGem;
	private int matter;
	private int value;
	
	public Jewelry(String typeName, int matter, int numGem) {
		super(typeName, "Smycke");
		
		this.matter = matter;
		this.numGem = numGem;
		countValue(numGem, matter);
		
	}

	private void countValue(int numGem, int matter) {
		if (matter == 2) {
			value +=2000;
		} else {
			value +=700;
		}
		if (numGem > 0) {
			value += numGem*500;
		}
				
	}
	
	public int getValue() {
		return value;
	}
	
	public int getNumGem() {
		return numGem;
	}
	
	public int getMatter() {
		return matter;
	}
	
	public String toString() {
		return super.toString() + "och har ett vŠrde av " + getValue();
	}
}
