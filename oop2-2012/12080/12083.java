import java.util.ArrayList;

public class Person {
	private ArrayList<Pryl> prylar = new ArrayList<Pryl>();

	private String personNamn;

	Person(String personNamn) {
		this.personNamn = personNamn;
		
	}

	public int h�mtaTotaltV�rde() {
		int totaltV�rde = 0;
		for (Pryl p : prylar) {
			totaltV�rde += p.h�mtaV�rde();
		}
		return totaltV�rde;
	}

	public void skrivUtPryl() {
		for (Pryl p : prylar) {
			System.out.println(p);
		}
	}

	public void nollaAktier() {
		for (Pryl nuvarande : prylar) {
			if (nuvarande instanceof Aktie) {
				Aktie a = (Aktie) nuvarande;
				a.nollst�llV�rde();

			}
		}
	}

	public String h�mtaNamn() {
		return personNamn;
	}

	public void l�ggTillPryl(Pryl p) {
		prylar.add(p);
	}

}
