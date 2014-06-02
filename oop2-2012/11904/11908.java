import java.util.ArrayList;

public class Person {
	private String personNamn;
	private ArrayList<Pryl> personPryl = new ArrayList<Pryl>();

	Person(String personNamn) {
		this.personNamn = personNamn;
	}

	public void addPryl(Pryl p) {
		personPryl.add(p);
	}

	public String getpersonNamn() {
		return personNamn;
	}

	public String toString() {
		return personNamn;
	}

	public int getTotalVärde() {
		int värde = 0;
		for (Pryl pryl : personPryl) {
			värde += pryl.getVärde();
		}
		return värde;
	}

	public String listPryl() {
		String list = "";
		for (Pryl pryl : personPryl) {
			list += " " + pryl;
		}
		return list;
	}

	public void börsKrasch() {
		for (Pryl p : personPryl) {
			if (p instanceof Aktie) {
				Aktie aktie = (Aktie) p;
				aktie.setVärde(0);
			}
		}
	}

}
