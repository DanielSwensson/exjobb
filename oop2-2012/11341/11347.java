// Av Emil Isaksson & Oscar Larsson DSK:1 OOP HT12		

public class Smycke extends Pryl {
	private int antal�delstenar;
	private boolean guld;

	Smycke(String prylNamn, int antal�delstenar, boolean guld) {
		super(prylNamn);
		this.antal�delstenar = antal�delstenar;
		this.guld = guld;

	}

	public int getAntal�delstenar() {
		return antal�delstenar;

	}

	public double getV�rde() {

		if (guld == true) {
			return 2000 + (antal�delstenar * 500);
		} else {
			return 700 + (antal�delstenar * 500);
		}

	}

}
