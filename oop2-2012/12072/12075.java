import java.util.ArrayList;

public class Person {
	private String personNamn;
	private ArrayList<Pryl> prylNamn = new ArrayList<Pryl>();

	Person(String personNamn) {
		this.personNamn = personNamn;
	}

	public void addPryl(Pryl p) {
		prylNamn.add(p);
	}

	public String getpersonNamn() {
		return personNamn;
	}

	public String toString() {
		return personNamn;
	}

	public int getTotalVärde() {
		int värde = 0;
		for (Pryl pryl : prylNamn) {
			värde += pryl.getVärde();
		}
		return värde;
	}

	public String listPryl() {
		String list = "";
		for (Pryl pryl : prylNamn) {
			list += " " + pryl;
		}
		return list;
	}

	public void börsKrasch() {
		for (Pryl p : prylNamn) {
			if (p instanceof Aktie) {
				Aktie aktie = (Aktie) p;
				aktie.setVärde(0);
			}
		}
	}

}
