
public class Apparat extends Pryl {
	private double Inkšpspris;
	private double Slitage;

	public Apparat(String namn, double inkšpspris, double slitage) {
		super(namn);
		Inkšpspris = inkšpspris;
		Slitage = slitage;
	}
	public double getInkšpspris() {
		return Inkšpspris;
	}
	public double getSlitage() {
		return Slitage;
	}
	public int getValue() {
		return (int) (Inkšpspris * (Slitage / 10.0));
	}
}
