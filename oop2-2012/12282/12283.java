public class Aktie extends Pryl {

	private int antalAktier;
	private double totalAktiePris;

	public Aktie(String prylNamn, int aktieAntal, double aktieTotalSumma) {
		super(prylNamn);
		antalAktier = aktieAntal;
		totalAktiePris = aktieTotalSumma;
	}

	public double nollst�llPris() {
		return totalAktiePris = 0;
	}

	public double f�V�rde() {
		return antalAktier * totalAktiePris;
	}

	public String toString() {
		return getNamn() + "\t" + " v�rde: " + f�V�rde();
	}

	public static void main(String[] args) {

	}

}
