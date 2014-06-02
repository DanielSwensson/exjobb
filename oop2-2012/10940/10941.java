
class Aktie extends Pryl {
	private int antalAktier;
	private int aktiePris;
	private int värde;

	public Aktie (String prylNamn, int antalAktier, int aktiePris) {
		super (prylNamn);
		this.antalAktier = antalAktier;
		this.aktiePris = aktiePris;

	}

	public double getVärde() {
		return värde = (antalAktier*aktiePris);
	}	
	
	public int börsKrasch(){
		return (aktiePris=0);
	}
}
