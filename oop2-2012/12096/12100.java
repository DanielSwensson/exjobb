

public abstract class Pryl {
	
	
	
	private String prylNamn;
	
	public Pryl (String prylNamn){
		/*
		 * Pryl konstruktor (superklassen)
		 */
		this.prylNamn = prylNamn;
		
	}
	
	abstract int getV�rde();/*Alla subklasser m�ste ha en getV�rde() metod*/
	
	public String getPrylNamn() {return prylNamn;}/*returnerar namnet p� prylen*/
	
}
