
public class Aktie extends Pryl {

	private int antal;
	private int aktiePris;

	public Aktie(String prylNamn, int antal, int aktiePris) {
		super(prylNamn);
		this.prylNamn = prylNamn;
		this.antal = antal;
		this.aktiePris = aktiePris;
		setv�rde();
	}

	public void setv�rde() { 
		v�rde = antal * aktiePris;
	}

	public void krasch() {
		aktiePris = 0;
		setv�rde();
	}
}
