public class Apparat extends Pryl {
	private int ink�pspris;
	private int slitage;

	public Apparat (String prylNamn, int ink�pspris, int slitage){
		super (prylNamn);
		this.ink�pspris=ink�pspris;
		this.slitage=slitage;

	}
	public int getInk�pspris(){
		return ink�pspris;
	}
	public int getSlitageV�rde(){
		return slitage;
	}

	public int getV�rde(){
		return ink�pspris*slitage/10;

	}
}
