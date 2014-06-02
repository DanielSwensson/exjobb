import java.util.ArrayList;

public class Person {
	private ArrayList<Prylar> allaPrylar;

	private String personnamn;

	public String getPersonNamn() {
		return personnamn;
	}

	public double getSumma() {
		double summa = 0;
		for (int i = 0; i < allaPrylar.size(); i++) {
			summa += allaPrylar.get(i).getVarde();
		}
		return summa;
	}

	public String getPrylar() {
		String prylLista = " ";
		for (int i = 0; i < allaPrylar.size(); i++) {
			prylLista += allaPrylar.get(i).getNman() + " "
					+ allaPrylar.get(i).getVarde() + " kr";
		}
		return prylLista;
	}

	public void Krasch() {
		for (int i = 0; i < allaPrylar.size(); i++) {
			if (allaPrylar.get(i) instanceof Aktier) {
				Aktier a = (Aktier) allaPrylar.get(i);
				a.börskrasch();
			}
		}
	}

	Person(String pna) {
		personnamn = pna;
		allaPrylar = new ArrayList<Prylar>();
	}

	public void addPrylar(Prylar ny) {
		allaPrylar.add(ny);
	}
}