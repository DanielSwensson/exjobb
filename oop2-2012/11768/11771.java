class Jewellery extends Valuable{



	private int gems;

	private String metal;


	public Jewellery(String nameOfJewellery, String metal, int gems){

		super(nameOfJewellery);

		this.metal = metal;

		this.gems = gems;

	}



	public int getValue(){

		if (metal.equalsIgnoreCase("ja")){

			return 2000+(gems*500);

		}

		return 700+(gems*500);

	}



	public String toString() {

		return name + " " + getValue();

	}

}
