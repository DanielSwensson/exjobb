public class Jewelery extends Item {
	private int numberOfGems;
	private String material;
	
	public Jewelery(String type, String material, int numberOfGems) {
		setType(type);
		this.material = material;
		this.numberOfGems = numberOfGems;
		setValue();
	}
	
	public void setValue() {
		int value;
		
		if(material.equalsIgnoreCase("gold"))
			value = 2000;
		else
			value = 700;
		
		value += 500*numberOfGems;
		
		setValue(value);
	}
}
