
public class Apparat extends Pryl {
	private double Ink�pspris;
	private double Slitage;

	public Apparat(String namn, double ink�pspris, double slitage) {
		super(namn);
		Ink�pspris = ink�pspris;
		Slitage = slitage;
	}
	public double getInk�pspris() {
		return Ink�pspris;
	}
	public double getSlitage() {
		return Slitage;
	}
	public int getValue() {
		return (int) (Ink�pspris * (Slitage / 10.0));
	}
}
