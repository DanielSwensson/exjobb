public class Apparat extends Pryl {
	private int ink�pspris;
	private int slitage;
	private int v�rde;

	Apparat(String namn, int ink�pspris, int slitage) {
		super(namn);
		this.ink�pspris = ink�pspris;
		this.slitage = slitage;
	}

	public int h�mtaV�rde() {
		v�rde = (slitage / 10) * ink�pspris;
		return v�rde;
	}

	public int h�mtaSlitage() {
		return slitage;
	}

	public int h�mtaInk�pspris() {
		return ink�pspris;
	}

	public String toString() {
		return super.toString() + "		" + v�rde;
	}
}
