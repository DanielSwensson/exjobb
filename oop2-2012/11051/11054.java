import java.util.ArrayList;

public class Person {
	private ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>();
	private String personNamn;

	Person(String n) {
		personNamn = n;

	}

	public String getNamn() {
		return personNamn;
	}

	public void nyPryl(Pryl nyPryl) {
		allaPrylar.add(nyPryl);

	}

	public void skrivUtÄgodelarOchVärde() {
		for (Pryl n : allaPrylar) {
			System.out.println(n.getTyp() + "\t" + n.getValue());
		}
	}

	public void börsKrash() {
		for (Pryl p : allaPrylar)
			if (p instanceof Aktie) {
				((Aktie) p).setAktieVärde(0);
			}
	}

	private int totValue;

	public int getTotValue() {
		totValue = 0;
		for (Pryl i : allaPrylar) {
			totValue += i.getValue();
		}

		return totValue;
	}
}
