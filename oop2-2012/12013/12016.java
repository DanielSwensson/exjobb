import java.util.*;

public class Person {
	private String namn;
	private String pryl;
	private ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>();

	public Person(String namn) {
		this.namn = namn;
	}

	private ArrayList<Pryl> getList() {
		return allaPrylar;
	}

	public void addPryl(Pryl pryl) {
		allaPrylar.add(pryl);
	}

	public String getNamn() {
		return namn;
	}

	public String getPryl() {
		return pryl;
	}

	public void setName(String newName) {
		this.namn = newName;
	}

	public void krasch() {
		for (Pryl p : allaPrylar)
			if (p instanceof Aktie)
				((Aktie) p).setPris();
	}

	public int getTotalV�rde() {
		int total = 0;
		for (Pryl p : allaPrylar) {
			total += p.getV�rde();
		}
		return total;
	}

	public String toStringtotal() {
		return namn + "\t" + getTotalV�rde();
	}

	public String visaPrylar() {
		String x = "";
		for (Pryl p : allaPrylar) {
			x += p + "\n";
		}
		return x;
	}

	public String visaVissPerson() {

		return namn + "\n" + visaPrylar();
	}

	public String visaRikast() {
		return "Rikaste �r " + namn + " " + " som sammanlagt �ger "
				+ getTotalV�rde() + "\n" + visaPrylar();
	}

}
