
public class Aktie extends Pryl {

	private int antal;
	private int aktiePris;

	public Aktie(String prylNamn, int antal, int aktiePris) {
		super(prylNamn);
		this.prylNamn = prylNamn;
		this.antal = antal;
		this.aktiePris = aktiePris;
		setvärde();
	}

	public void setvärde() { 
		värde = antal * aktiePris;
	}

	public void krasch() {
		aktiePris = 0;
		setvärde();
	}
}
