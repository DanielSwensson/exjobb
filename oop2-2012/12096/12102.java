
public class Smycke extends Pryl {
	private boolean guld;
	private int antalStenar;
	
	public Smycke (String prylNamn, Boolean guld, int antalStenar){
		/*
		 * smycke sub-konstruktor
		 */
		super(prylNamn);
		this.guld = guld;
		this.antalStenar = antalStenar;	
	}
	
	protected int getV�rde(){return setV�rde();}
	
	private int setV�rde(){
		/*
		 * Om det �r guld s� r�knar v�rdet ut p� ett vis, silver p� ett vis
		 */
		if(guld){
			return 2000 + (500*antalStenar);
		}
		else{
			return 700 + (500*antalStenar);
		}
	}
}


	
