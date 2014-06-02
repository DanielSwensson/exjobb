

public abstract class Pryl {
	
	
	
	private String prylNamn;
	
	public Pryl (String prylNamn){
		/*
		 * Pryl konstruktor (superklassen)
		 */
		this.prylNamn = prylNamn;
		
	}
	
	abstract int getVärde();/*Alla subklasser måste ha en getVärde() metod*/
	
	public String getPrylNamn() {return prylNamn;}/*returnerar namnet på prylen*/
	
}
