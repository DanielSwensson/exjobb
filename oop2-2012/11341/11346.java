// Av Emil Isaksson & Oscar Larsson DSK:1 OOP HT12			

abstract class Pryl {

	private String prylNamn;

	public Pryl(String prylNamn) {
		this.prylNamn = prylNamn;

	}

	abstract public double getV�rde();

	public String getPrylNamn() {
		return prylNamn;
	}

	public String tostring() {
		return prylNamn;
	}
}
