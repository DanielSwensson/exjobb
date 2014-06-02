class Device extends Valuable{



	private int purchasePrice, abrasion;


	public Device(String nameOfDevice, int purchasePrice, int abrasion){

		super(nameOfDevice);

		this.purchasePrice = purchasePrice;

		this.abrasion = abrasion;

	}

	public int getValue(){

		return (purchasePrice*abrasion)/10;

	}

}

