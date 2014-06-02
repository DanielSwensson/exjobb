
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

	private int setVärde() {
		/*
		 * Beskriver värdet för aktier
		 */
		return pris*antalAktier;
	}

	protected int getVärde(){
		return setVärde();
	}
	
	public void börsKraschAktier(){
		/*
		 * Om denna metod kallas så gör den aktiepriset till 0 kr
		 */
		pris = 0;
	}
}
