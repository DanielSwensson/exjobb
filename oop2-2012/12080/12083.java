import java.util.ArrayList;

public class Person {
	private ArrayList<Pryl> prylar = new ArrayList<Pryl>();

	private String personNamn;

	Person(String personNamn) {
		this.personNamn = personNamn;
		
	}

	public int hämtaTotaltVärde() {
		int totaltVärde = 0;
		for (Pryl p : prylar) {
			totaltVärde += p.hämtaVärde();
		}
		return totaltVärde;
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
				a.nollställVärde();

			}
		}
	}

	public String hämtaNamn() {
		return personNamn;
	}

	public void läggTillPryl(Pryl p) {
		prylar.add(p);
	}

}
