
public class Apparat extends Pryl {

	private int slitage;
	private int inkšpspris;



	public int getslitage(){
		return slitage;
	}
	public Apparat( String prylNamn, String prylTyp, int slitage, int inkšpspris){
		super(prylNamn, prylTyp);
		this.slitage=slitage;
		this.inkšpspris = inkšpspris;
	}
	public int getVŠrde (){
		return inkšpspris*slitage/10;

	}
}