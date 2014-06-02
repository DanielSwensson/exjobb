public class Aktie extends Pryl {

	private int antal;
	private int pris;

	public Aktie(String n, int a, int p) {
		super(n);
		antal = a;
		pris = p;
	}

	public int getAntal() {
		return antal;
	}

	public int getPris() {
		return pris;
	}

	public int getVärde() {
		return antal * pris;
	}

	public void setPris(int i) { // lägger till metoden setPris för att koden
									// ska funka i main
		pris = i;

	}

}
