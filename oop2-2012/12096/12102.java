
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
	
	protected int getVärde(){return setVärde();}
	
	private int setVärde(){
		/*
		 * Om det är guld så räknar värdet ut på ett vis, silver på ett vis
		 */
		if(guld){
			return 2000 + (500*antalStenar);
		}
		else{
			return 700 + (500*antalStenar);
		}
	}
}


	
