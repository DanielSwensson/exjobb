
public class Aktie extends Pryl {


	private int antal;
	private int pris;




	public Aktie (String prylNamn, String prylTyp, int antal, int pris){
		super( prylNamn, prylTyp);
		this.antal = antal;
		this.pris = pris;

	}
	public int getV�rde (){
		return pris*antal;

	}
	public void b�rskrasch(){
		pris=0; 
	}

}
