public class Apparat extends Pryl {

	private int pris; 
	private int slitage;

	public Apparat(String namn, int pris, int slitage) {
		super(namn);
		this.pris = pris;
		this.slitage = slitage;
	}

	public int getV�rde() {
		return slitage * pris / 10;
	}
}
