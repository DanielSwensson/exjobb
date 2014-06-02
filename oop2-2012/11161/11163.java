
public class Jewelry extends Thing {
	private static final long serialVersionUID = -4033580088682630426L;

	//Instance variables
	private String material;
	private int numberOfJewels;
	
	//Constructor
	public Jewelry(String startName, int startNumberOfJewels, String startMaterial) {
		super(startName);
		numberOfJewels = startNumberOfJewels;
		material = startMaterial;
	}
	
	public int getValue() {
		int value = 0;
		if (material.equals("gold")) {
			value += 2000;
		}
		if (material.equals("silver")) {
			value += 700;
		}
		value += numberOfJewels * 500;
		return value;
	}
	
	public String toString() {
		return super.getName() + " " + numberOfJewels + " " + material;    
    }

} //Class
