// Av Emil Isaksson & Oscar Larsson DSK:1 OOP HT12	

public class Aktie extends Pryl {

	private int aktiePris;
	private int aktieAntal;

	public Aktie(String prylNamn, int aktieAntal, int aktiePris) {
		super(prylNamn);

		this.aktieAntal = aktieAntal;
		this.aktiePris = aktiePris;

	}

	public int getAktieAntal() {
		return aktieAntal;
	}

	public int getAktiePris() {
		return aktiePris;
	}

	public double getVärde() {
		return aktieAntal * aktiePris;
	}

	public int kraschadBörs() {
		return aktiePris = 0;
	}
}
