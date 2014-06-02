// Av Emil Isaksson & Oscar Larsson DSK:1 OOP HT12		

public class Smycke extends Pryl {
	private int antalÄdelstenar;
	private boolean guld;

	Smycke(String prylNamn, int antalÄdelstenar, boolean guld) {
		super(prylNamn);
		this.antalÄdelstenar = antalÄdelstenar;
		this.guld = guld;

	}

	public int getAntalÄdelstenar() {
		return antalÄdelstenar;

	}

	public double getVärde() {

		if (guld == true) {
			return 2000 + (antalÄdelstenar * 500);
		} else {
			return 700 + (antalÄdelstenar * 500);
		}

	}

}
