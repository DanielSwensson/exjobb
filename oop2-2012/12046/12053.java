
public class Smycke extends Pryl{
	private int �delsten;
	private boolean guld;

	public double getV�rde(){
		return (�delsten * 500) + (guld ? 2000 : 700);
	}

	public Smycke(String namn, int �delsten, boolean guld) {
		super(namn);
		this.�delsten = �delsten;
		this.guld = guld;
	}
	
}
