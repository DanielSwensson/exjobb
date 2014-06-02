class Apparat extends Pryl {
	private int inköpspris;
	private int slitage;
	private int värde;

	Apparat(String namn, int inköpspris, int slitage) {
		super(namn);
		this.inköpspris = inköpspris;
		this.slitage = slitage;
	}

	public double getVärde() {
		double värde;
		värde = inköpspris * slitage * 0.1;
		return värde;
	}

}
