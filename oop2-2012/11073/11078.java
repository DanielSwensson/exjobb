
public abstract class Valuable {

	private String itemName;
	
	// Konstruktor
	public Valuable (String itemName) {
		this.itemName = itemName;
	}
	
	// Ber�knar v�rde
	abstract public int value();
	
	// toString
	public String toString() {
		return "\n" + itemName + ", " + value();
	}

}
