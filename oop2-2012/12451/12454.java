
public class Apparat extends Pryl {

	private int slitage;
	private int ink�pspris;



	public int getslitage(){
		return slitage;
	}
	public Apparat( String prylNamn, String prylTyp, int slitage, int ink�pspris){
		super(prylNamn, prylTyp);
		this.slitage=slitage;
		this.ink�pspris = ink�pspris;
	}
	public int getV�rde (){
		return ink�pspris*slitage/10;

	}
}