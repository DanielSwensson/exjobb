
public class Aktie extends Pryl {


	private int antal;
	private int pris;




	public Aktie (String prylNamn, String prylTyp, int antal, int pris){
		super( prylNamn, prylTyp);
		this.antal = antal;
		this.pris = pris;

	}
	public int getVŠrde (){
		return pris*antal;

	}
	public void bšrskrasch(){
		pris=0; 
	}

}
