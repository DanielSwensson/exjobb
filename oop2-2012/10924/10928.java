import java.util.ArrayList;

public class Person {
	private ArrayList<Pryl> personsPrylar = new ArrayList<Pryl>();
	private String namn;

	public Person(String namn) {
		this.namn = namn;
	}

	public String h�mtaNamn() {
		return namn;
	}

	public int h�mtaTotaltV�rde() {
		int totaltV�rde = 0;
		for (Pryl p : personsPrylar) {
			totaltV�rde += p.h�mtaV�rde();
		}
		return totaltV�rde;
	}

	public void l�ggTillPryl(Pryl p) {
		personsPrylar.add(p);
	}

	public void b�rsKrasch() {
		for (Pryl pr : personsPrylar)
			if (pr instanceof Aktie)
				((Aktie) pr).s�ttPrisTillNoll();
	}

	public String h�mtaPrylLista() {
		return namn + " har totalt" + " " + h�mtaTotaltV�rde() + "kr" + '\n'
				+ personsPrylar + '\n';
	}

	@Override
	public String toString() {
		return namn + " har f�ljande prylar:\n" + personsPrylar + '\n';
	}

}
