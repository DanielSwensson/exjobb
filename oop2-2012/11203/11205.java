public class Apparat extends Pryl {
	private int inköpspris;
	private int slitage;

	public Apparat (String prylNamn, int inköpspris, int slitage){
		super (prylNamn);
		this.inköpspris=inköpspris;
		this.slitage=slitage;

	}
	public int getInköpspris(){
		return inköpspris;
	}
	public int getSlitageVärde(){
		return slitage;
	}

	public int getVärde(){
		return inköpspris*slitage/10;

	}
}
