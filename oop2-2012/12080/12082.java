public class Apparat extends Pryl {
	private int inkšpspris;
	private int slitage;
	private int vŠrde;

	Apparat(String namn, int inkšpspris, int slitage) {
		super(namn);
		this.inkšpspris = inkšpspris;
		this.slitage = slitage;
	}

	public int hŠmtaVŠrde() {
		vŠrde = (slitage / 10) * inkšpspris;
		return vŠrde;
	}

	public int hŠmtaSlitage() {
		return slitage;
	}

	public int hŠmtaInkšpspris() {
		return inkšpspris;
	}

	public String toString() {
		return super.toString() + "		" + vŠrde;
	}
}
