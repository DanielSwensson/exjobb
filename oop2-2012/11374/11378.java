
public class Jewelry extends Valuable {
		
	 private int numbersOfGemstones;
	 private String jewelryMadeOf;

	public Jewelry(String name, int numbersOfGemstones, String jewelryMadeOf) {
		super(name);
		
		this.numbersOfGemstones = numbersOfGemstones;
		this.jewelryMadeOf = jewelryMadeOf;
	}


	public String toString() {
		return super.toString() + " Numbers of gemstones: " + numbersOfGemstones + "st. Made of: " + jewelryMadeOf + ".";
	}
	
	public double value() {
			
		if (jewelryMadeOf.equals("gold")) {
			return 2000 + (numbersOfGemstones*500);
		}
		
		return 700 + (numbersOfGemstones*500);
			
	}
	
	public int getNumbersOfGemstones() {
		
		return numbersOfGemstones;
	}
	
	public String getjewelryMadeOf() {
		
		return jewelryMadeOf;
	}
}
