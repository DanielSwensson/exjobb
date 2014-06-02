
public class Apparat extends Pryl {

	private int inköpsPris;
	private int slitage;
	
	
	public Apparat(String prylNamn, int inköpsPris, int slitage) {
		/*
		 * Apparat konstruktor
		 */
		super(prylNamn);
		this.inköpsPris = inköpsPris;
		this.slitage = slitage;
	}


	private int setVärde(){
		
	/*
	 * räknar ut värdet på apparaten. använder räknare(double) för att värdet ska kunna räknas ut på rätt sätt
	 */
		double räknare = slitage /10.0;
		int lokalVärde=(int) (inköpsPris*räknare);
		return lokalVärde;
		
	}
	
	protected int getVärde(){
		return setVärde();
	}

}
