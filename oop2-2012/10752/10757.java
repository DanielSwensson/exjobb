import java.util.ArrayList;

public class Person {

	ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>();

	private String name;

	public Person(String name) {
		this.name = name;
	}

	public void addPryl(Pryl nyPryl) {
		allaPrylar.add(nyPryl);
	}
	public int getSum() {
		int sum = 0;
		for (Pryl p : allaPrylar)

			sum += p.getValue();
		return sum;
	}

	public String getPryl() {
		String prylar = " ";
		for (Pryl p : allaPrylar) {
			prylar += p;
		}
		
		return prylar;
	}

	public void bšrsKrasch() {
		for (Pryl p : allaPrylar)
			if (p instanceof Aktie)
				((Aktie) p).bšrsKrasch();
	}

	public String getNamn() {
		return name;
	}

	public String toString() {
		return name + "  " + getPryl();
	}
}
