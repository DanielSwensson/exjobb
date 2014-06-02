import java.util.ArrayList;

public class Person {
	private ArrayList<Pryl> personsPrylar = new ArrayList<Pryl>();
	private String namn;

	public Person(String namn) {
		this.namn = namn;
	}

	public String hämtaNamn() {
		return namn;
	}

	public int hämtaTotaltVärde() {
		int totaltVärde = 0;
		for (Pryl p : personsPrylar) {
			totaltVärde += p.hämtaVärde();
		}
		return totaltVärde;
	}

	public void läggTillPryl(Pryl p) {
		personsPrylar.add(p);
	}

	public void börsKrasch() {
		for (Pryl pr : personsPrylar)
			if (pr instanceof Aktie)
				((Aktie) pr).sättPrisTillNoll();
	}

	public String hämtaPrylLista() {
		return namn + " har totalt" + " " + hämtaTotaltVärde() + "kr" + '\n'
				+ personsPrylar + '\n';
	}

	@Override
	public String toString() {
		return namn + " har följande prylar:\n" + personsPrylar + '\n';
	}

}
