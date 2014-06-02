public class Aktie extends Pryl {

	private int antalAktier;
	private double totalAktiePris;

	public Aktie(String prylNamn, int aktieAntal, double aktieTotalSumma) {
		super(prylNamn);
		antalAktier = aktieAntal;
		totalAktiePris = aktieTotalSumma;
	}

	public double nollställPris() {
		return totalAktiePris = 0;
	}

	public double fåVärde() {
		return antalAktier * totalAktiePris;
	}

	public String toString() {
		return getNamn() + "\t" + " värde: " + fåVärde();
	}

	public static void main(String[] args) {

	}

}
