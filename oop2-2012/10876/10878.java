
public class Apparat extends Pryl {

	private int apparatPris;
	private int slitage;

	public Apparat(String prylNamn, int apparatPris, int slitage) {
		super(prylNamn);
		this.prylNamn = prylNamn;
		this.apparatPris = apparatPris;
		this.slitage = slitage;
		setv�rde();
	}

	public void setv�rde() {
		v�rde = apparatPris * slitage/10;
	}
}
