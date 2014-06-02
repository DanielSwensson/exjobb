
public class Aktier extends Pryl {

	private int antalAktier, aktiePris, varde;

	Aktier(String aktieTyp, int antal,int npris){
		super(aktieTyp);
		antalAktier=antal;
		aktiePris=npris;
		varde=antalAktier * aktiePris;
	}

	public int varde() {
		return varde;
	}

	void setVarde (int bvarde){
		this.varde=bvarde;
	}
}

