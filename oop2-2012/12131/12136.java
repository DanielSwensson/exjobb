

public class Jewellery extends Accessorie {

	private String goldOrSilver;
	private int amountOfGem; 
	private int price;

	Jewellery(String name, int amountOfGem, String goldOrSilver) {
		super(name);
		this.goldOrSilver = goldOrSilver;
		this.amountOfGem = amountOfGem;
		
		setValue(getItemValue());

	}

	public int price() {
		return price;
	}

	public int amountOfGem() {
		return amountOfGem;
	}

	public String goldOrSilver() {
		return goldOrSilver;

	}

	
	private double getItemValue() {
		double tempPrice=0;
		if (this.goldOrSilver.matches("Gold")) {
			tempPrice = 2000 + (500 * this.amountOfGem);

		} else if (this.goldOrSilver.matches("gold")) {
			tempPrice = 2000 + (500 * this.amountOfGem);
		
		} else if (this.goldOrSilver.matches("Silver")) {
			tempPrice = 700 + (500 * this.amountOfGem);
		
		} else if (this.goldOrSilver.matches("silver")) {
		tempPrice = 700 + (500 * this.amountOfGem);
		}
		return tempPrice;
	}

}
