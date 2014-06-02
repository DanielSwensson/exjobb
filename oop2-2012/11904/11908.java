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

	public int getTotalV�rde() {
		int v�rde = 0;
		for (Pryl pryl : personPryl) {
			v�rde += pryl.getV�rde();
		}
		return v�rde;
	}

	public String listPryl() {
		String list = "";
		for (Pryl pryl : personPryl) {
			list += " " + pryl;
		}
		return list;
	}

	public void b�rsKrasch() {
		for (Pryl p : personPryl) {
			if (p instanceof Aktie) {
				Aktie aktie = (Aktie) p;
				aktie.setV�rde(0);
			}
		}
	}

}
