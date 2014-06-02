
public class Aktier extends Pryl {

	private int pris;
	private int antalAktier;
	
	public Aktier(String prylNamn, int pris, int antalAktier) {
		/*
		 * Aktier sub-konstruktor
		 */
		super(prylNamn);
		this.pris = pris;
		this.antalAktier = antalAktier;
	}

	private int setV�rde() {
		/*
		 * Beskriver v�rdet f�r aktier
		 */
		return pris*antalAktier;
	}

	protected int getV�rde(){
		return setV�rde();
	}
	
	public void b�rsKraschAktier(){
		/*
		 * Om denna metod kallas s� g�r den aktiepriset till 0 kr
		 */
		pris = 0;
	}
}
