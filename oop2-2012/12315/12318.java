import java.util.ArrayList;

public class Person {

	private String personNamn;

	private ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>();

	public Person(String personNamn) {
		this.personNamn = personNamn;

	}

	public void laggTillPryl(Pryl prylnamn) {

		allaPrylar.add(prylnamn);
	}

	public String toString() {

		return personNamn;
	}

	public String getPersonNamn() {
		return personNamn;

	}

	public void skrivUtAllaPrylar() {
		for (int i = 0; i < allaPrylar.size(); i++) {
			System.out.println(allaPrylar.get(i).getPrylNamn() + " "
					+ allaPrylar.get(i).getVarde());
		}
	}

	public int vardePaAllaPrylar() {

		int summaVarde = 0;
		for (int i = 0; i < allaPrylar.size(); i++) {
			summaVarde += allaPrylar.get(i).getVarde();
		}
		return summaVarde;
	}

	public ArrayList getPrylar() {
		return allaPrylar;
	}
}