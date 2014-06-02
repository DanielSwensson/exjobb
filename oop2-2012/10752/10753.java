public class Aktie extends Pryl {
	private int Antal;
	private int pris;

	public Aktie(String namn, int antal, int pris) {
		super(namn);
		this.Antal = antal;
		this.pris = pris;
	}
	public int getAntal() {
		return Antal;
	}
	public int getPris() {
		return pris;
	}
	public int getValue() {
		return Antal * pris;
	}
	 public void bšrsKrasch(){
	    	pris=0;
	 } 
}



