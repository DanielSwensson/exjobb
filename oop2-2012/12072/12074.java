class Apparat extends Pryl {
	private int ink�pspris;
	private int slitage;
	private int v�rde;

	Apparat(String namn, int ink�pspris, int slitage) {
		super(namn);
		this.ink�pspris = ink�pspris;
		this.slitage = slitage;
	}

	public double getV�rde() {
		double v�rde;
		v�rde = ink�pspris * slitage * 0.1;
		return v�rde;
	}

}
