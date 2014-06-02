
public class Jewelery extends Item {

	private String material;
	private int stones;
	private double value = 0;
	Jewelery(Object owner, String name, String material, int stones) {
		super(owner, name);
		this.material = material;
		this.stones = stones;
	}
	
	public double getValue() {		
		if (this.material.equalsIgnoreCase("gold")) {
			value = 2000;
		}
		else if (this.material.equalsIgnoreCase("silver")) {
			value = 700;
		}
		value += this.stones * 500;		
		return value;
	}
}
