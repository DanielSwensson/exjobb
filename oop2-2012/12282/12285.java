
import java.util.ArrayList;

public class Person {

	ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>();

	private String personNamn;
	private double totalSumma;

	Person(String namnP�Person) {
		personNamn = namnP�Person;
	}

	public double totalSummaPerson() {
		int summa = 0;
		for (Pryl pekare : allaPrylar)
			summa += pekare.f�V�rde();
		return summa;
	}

	public void s�ttAktie() {
		for (Pryl dennaPryl : allaPrylar)
			if (dennaPryl instanceof Aktie) {
				Aktie a = (Aktie) dennaPryl;
				a.nollst�llPris();
				return;
			}
	}

	public String f�PersonNamn() {
		return this.personNamn;
	}

	public double f�Summa() {
		return this.totalSumma;
	}

	public String toString() {
		return personNamn + " har totalv�rdet: " + (totalSummaPerson());
	}

	public void visaPrylar() {
		for (int i = 0; i < allaPrylar.size(); i++) {
			System.out.println(allaPrylar.get(i));
		}
	}

	public void l�ggTillPryl(Pryl NyPryl) {
		allaPrylar.add(NyPryl);
	}

	public static void main(String[] args) {

	}

}