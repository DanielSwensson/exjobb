
class Aktie extends Pryl {
	private int antalAktier;
	private int aktiePris;
	private int v�rde;

	public Aktie (String prylNamn, int antalAktier, int aktiePris) {
		super (prylNamn);
		this.antalAktier = antalAktier;
		this.aktiePris = aktiePris;

	}

	public double getV�rde() {
		return v�rde = (antalAktier*aktiePris);
	}	
	
	public int b�rsKrasch(){
		return (aktiePris=0);
	}
}
